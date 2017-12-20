package paz1c.projekt.turistickaDatabaza;

/**
 *
 * @author dominik
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import paz1c.projekt.turistickaDatabaza.database.Pouzivatel;
import paz1c.projekt.turistickaDatabaza.models.PouzivatelFxModel;

public class RegistrationSceneController {

    private PouzivatelFxModel pouzivatelFxModel = new PouzivatelFxModel();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button registrationButton;

    @FXML
    private Label hlaskaLabel;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField hesloPasswordField;

    @FXML
    private PasswordField overenieHeslaPasswordField;

    @FXML
    void initialize() {

        loginTextField.textProperty().bindBidirectional(pouzivatelFxModel.loginProperty());

        emailTextField.textProperty().bindBidirectional(pouzivatelFxModel.emailProperty());

        overenieHeslaPasswordField.textProperty().bindBidirectional(pouzivatelFxModel.hesloProperty());

        registrationButton.setOnAction(eh -> {

            if ((hesloPasswordField.textProperty().get().equals(overenieHeslaPasswordField.textProperty().get())) == false) {
                hlaskaLabel.textProperty().set("Heslá sa nezhodujú");
                hesloPasswordField.clear();
                overenieHeslaPasswordField.clear();
            } else if (DaoFactory.INSTANCE.getPouzivatelDao().
                    getByLogin(pouzivatelFxModel.getLogin()) != null) {
                hlaskaLabel.textProperty().set("Používateľ s takýmto loginom už existuje");
                hesloPasswordField.clear();
                overenieHeslaPasswordField.clear();
            } else if (hesloPasswordField.textProperty().get().length() < 4) {
                hlaskaLabel.textProperty().set("Heslo musí mať aspoň 4 znaky");
                hesloPasswordField.clear();
                overenieHeslaPasswordField.clear();
            } else {
                Pouzivatel pouzivatel = new Pouzivatel();
                pouzivatel.setAdmin(false);
                pouzivatel.setLogin(pouzivatelFxModel.getLogin());
                pouzivatel.setEmail(pouzivatelFxModel.getEmail());
                pouzivatel.setHeslo(pouzivatelFxModel.getHeslo());
                DaoFactory.INSTANCE.getPouzivatelDao().saveNew(pouzivatel);
                registrationButton.getScene().getWindow().hide();
            }
        });

    }

}
