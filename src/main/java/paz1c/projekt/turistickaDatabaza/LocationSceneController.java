package paz1c.projekt.turistickaDatabaza;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import paz1c.projekt.turistickaDatabaza.database.Lokalita;
import paz1c.projekt.turistickaDatabaza.database.Pouzivatel;
import paz1c.projekt.turistickaDatabaza.database.Recenzia;

public class LocationSceneController {

    private Lokalita vybranaLokalita;
    private Pouzivatel prihlasenyPouzivatel;

    @FXML
    private ScrollPane SP;

    @FXML
    private Label Lokalita_label;

    @FXML
    private Label region_label;

    @FXML
    private Label hodnotenie_label;

    @FXML
    private Label popis_label;

    @FXML
    private ScrollPane RecenzieSP;

    @FXML
    private Button pridatRecenziuButton;

    @FXML
    private VBox obrazkyVbox;

    @FXML
    private Button schvalitButton;

    @FXML
    private Button pridatOblubenuButton;

    @FXML
    private Label hlaskaLabel;

    @FXML
    private Button cancel_button;

    public LocationSceneController(Lokalita vybranaLokalita, Pouzivatel prihlasenyPouzivatel) {
        this.vybranaLokalita = vybranaLokalita;
        this.prihlasenyPouzivatel = prihlasenyPouzivatel;

    }

    @FXML
    void initialize() {

        hlaskaLabel.textProperty().set(null);

        Lokalita_label.textProperty().set(vybranaLokalita.getNazov());

        region_label.textProperty().set("Región: " + vybranaLokalita.getRegion());

        hodnotenie_label.textProperty().set("Priemerné Hodnotenie: " + vybranaLokalita.getHodnotenie());

        popis_label.textProperty().set(vybranaLokalita.getPopis());
        SP.setVvalue(Double.NEGATIVE_INFINITY);
        RecenzieSP.setVvalue(Double.NEGATIVE_INFINITY);

        pridatRecenziuButton.setOnAction(eh -> {
            try {
                PridatRecenziuController controller = new PridatRecenziuController(prihlasenyPouzivatel, vybranaLokalita);
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("PridatRecenziu.fxml"));
                loader.setController(controller);

                Parent parentPane = loader.load();
                Scene scene = new Scene(parentPane);

                Stage stage = new Stage();
                stage.setMinHeight(400);
                stage.setMinWidth(600);
                stage.setScene(scene);
                stage.setTitle("Turistická daatabáza: pridať recenziu ");
                stage.initModality(Modality.WINDOW_MODAL);
                stage.showAndWait();
                naplnRecenzie();

            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        });

        naplnRecenzie();

        schvalitButton.setVisible(!vybranaLokalita.isSchvalena());
        schvalitButton.setDisable(vybranaLokalita.isSchvalena());

        schvalitButton.setOnAction(eh -> {
            boolean uspech = DaoFactory.INSTANCE.getLokalitaDao().schvalById(vybranaLokalita.getId());
            if (uspech) {
                hlaskaLabel.textProperty().set("Schválená!");
            } else {
                hlaskaLabel.textProperty().set("Nastala chyba!");
            }
        });

        pridatOblubenuButton.setOnAction(eh -> {
            boolean uspech = DaoFactory.INSTANCE.getPouzivatelDao().pridajOblubenu(vybranaLokalita, prihlasenyPouzivatel);
            if (uspech) {
                hlaskaLabel.textProperty().set("Pridaná!");
            } else {
                hlaskaLabel.textProperty().set("Nastala chyba!");
            }

        });

        cancel_button.setOnAction(eh -> {
            cancel_button.getScene().getWindow().hide();
        });

    }

    public void naplnRecenzie() {
        VBox recenzieBox = new VBox();
        List<Parent> recenzieList = new ArrayList();
        for (Recenzia r : vybranaLokalita.getRecenzie()) {
            try {
                RecenziaSceneController controller = new RecenziaSceneController(r, prihlasenyPouzivatel, vybranaLokalita,this);
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("RecenziaScene.fxml"));
                loader.setController(controller);

                Parent parentPane = loader.load();
                recenzieList.add(parentPane);

            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }

        recenzieBox.getChildren().addAll(recenzieList);
        recenzieBox.fillWidthProperty().set(true);

        RecenzieSP.setContent(recenzieBox);
    }
}
