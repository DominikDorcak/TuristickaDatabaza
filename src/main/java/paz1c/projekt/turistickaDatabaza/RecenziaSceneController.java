package paz1c.projekt.turistickaDatabaza;

/**
 *
 * @author dominik
 */
import java.io.IOException;
import java.text.SimpleDateFormat;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import paz1c.projekt.turistickaDatabaza.database.Lokalita;
import paz1c.projekt.turistickaDatabaza.database.Pouzivatel;
import paz1c.projekt.turistickaDatabaza.database.Recenzia;

public class RecenziaSceneController {

    private Recenzia recenzia;
    private Pouzivatel prihlasenyPouzivatel;
    private Lokalita vybranaLokalita;
    private LocationSceneController zavolaneZ;
    
    public RecenziaSceneController(Recenzia recenzia, Pouzivatel prihlasenyPouzivatel, Lokalita vybranaLokalita,LocationSceneController zavolaneZ) {
        this.recenzia = recenzia;
        this.prihlasenyPouzivatel = prihlasenyPouzivatel;
        this.vybranaLokalita = vybranaLokalita;
        this.zavolaneZ = zavolaneZ;
    }

    @FXML
    private Label LoginLabel;

    @FXML
    private Label HodnotenieLabel;

    @FXML
    private Label DatumLabel;

    @FXML
    private Button UpravitButton;

    @FXML
    private Button VymazatButton;

    @FXML
    private Label TextLabel;

    @FXML
    void initialize() {

        LoginLabel.textProperty().set(recenzia.getLoginPouzivatela());

        HodnotenieLabel.textProperty().set(Integer.toString(recenzia.getHodnotenie()));

        DatumLabel.textProperty().set(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(recenzia.getDatum()));

        TextLabel.textProperty().set(recenzia.getText());

        UpravitButton.setDisable(!(prihlasenyPouzivatel.isAdmin() || recenzia.getLoginPouzivatela().equals(prihlasenyPouzivatel.getLogin())));
        VymazatButton.setDisable(!(prihlasenyPouzivatel.isAdmin() || recenzia.getLoginPouzivatela().equals(prihlasenyPouzivatel.getLogin())));

        UpravitButton.setOnAction(eh -> {
            try {
                PridatRecenziuController controller = new PridatRecenziuController(prihlasenyPouzivatel, vybranaLokalita, recenzia);
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("PridatRecenziu.fxml"));
                loader.setController(controller);

                Parent parentPane = loader.load();
                Scene scene = new Scene(parentPane);

                Stage stage = new Stage();
                stage.setMinHeight(400);
                stage.setMinWidth(600);
                stage.setScene(scene);
                stage.setTitle("Turistická daatabáza: upraviť recenziu ");
                stage.initModality(Modality.WINDOW_MODAL);
                stage.showAndWait();
                zavolaneZ.naplnRecenzie();

                LoginLabel.textProperty().set(recenzia.getLoginPouzivatela());

                HodnotenieLabel.textProperty().set(Integer.toString(recenzia.getHodnotenie()));

                DatumLabel.textProperty().set(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(recenzia.getDatum()));

                TextLabel.textProperty().set(recenzia.getText());

                UpravitButton.setDisable(!(prihlasenyPouzivatel.isAdmin() || recenzia.getLoginPouzivatela().equals(prihlasenyPouzivatel.getLogin())));
                VymazatButton.setDisable(!(prihlasenyPouzivatel.isAdmin() || recenzia.getLoginPouzivatela().equals(prihlasenyPouzivatel.getLogin())));

            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        });

        VymazatButton.setOnAction(eh -> {
            DaoFactory.INSTANCE.getRecenziaDao().deleteById(recenzia.getId());
            for (Recenzia r : vybranaLokalita.getRecenzie()) {
                if (r.getId().equals(recenzia.getId())) {
                    vybranaLokalita.getRecenzie().remove(r);
                    zavolaneZ.naplnRecenzie();
                }

            }

        });

    }

}
