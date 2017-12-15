package paz1c.projekt.turistickaDatabaza;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import paz1c.projekt.turistickaDatabaza.database.Pouzivatel;
import paz1c.projekt.turistickaDatabaza.models.PouzivatelFxModel;

class LoginSceneController {

    private PouzivatelFxModel pouzivatelModel = new PouzivatelFxModel();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registraciaButton;

    @FXML
    private PasswordField hesloPasswordField;

    @FXML
    private Label chybaLabel;

    @FXML
    private Label hlaskaLabel;

    @FXML
    void initialize() {

        loginTextField.textProperty().bindBidirectional(pouzivatelModel.loginProperty());

        hesloPasswordField.textProperty().bindBidirectional(pouzivatelModel.hesloProperty());

        loginButton.setOnAction(eh -> {
            Pouzivatel pouzivatel = DaoFactory.INSTANCE.getPouzivatelDao().getByLogin(pouzivatelModel.getLogin());
            hlaskaLabel.textProperty().set(null);
            chybaLabel.textProperty().set(null);
            if (pouzivatel != null) {
                if (pouzivatelModel.getHeslo().equals(pouzivatel.getHeslo())) {
                    mainScene(pouzivatel);
                } else {
                    chybaLabel.textProperty().set("Nesprávne heslo!");
                    hesloPasswordField.clear();
                }
            } else {
                chybaLabel.textProperty().set("Žiaden používateľ s daným loginom!");
                hesloPasswordField.clear();

            }
        });

        registraciaButton.setOnAction(eh -> {
            chybaLabel.textProperty().set(null);
            RegistrationSceneController controller
                    = new RegistrationSceneController();
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("RegistrationScene.fxml"));
                loader.setController(controller);

                Parent parentPane = loader.load();
                Scene scene = new Scene(parentPane);

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Turistická daatabáza: registrácia");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();

                // toto sa vykona az po zatvoreni okna
                hlaskaLabel.textProperty().set("Registrácia úspešná, pokračujte prihlásením");
                loginTextField.clear();
                hesloPasswordField.clear();
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        });

    }

    //samostatna metoda na spustenie mainScene - sprehladnenie kodu
    private void mainScene(Pouzivatel prihlasenyPouzivatel) {
        if (prihlasenyPouzivatel.isAdmin()) {
            try {
                MainSceneAdminController controller = new MainSceneAdminController(prihlasenyPouzivatel);
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("MainSceneAdmin.fxml"));
                loader.setController(controller);

                Parent parentPane = loader.load();
                Scene scene = new Scene(parentPane);

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Turistická databáza: Hlavné menu(administrátor)");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
                //po odhlaseni
                hesloPasswordField.clear();
                loginTextField.clear();
                hlaskaLabel.textProperty().set("Odhlásenie úspešné");
                chybaLabel.textProperty().set(null);
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        } else {
            try {
                MainSceneController controller = new MainSceneController(prihlasenyPouzivatel);
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("MainScene.fxml"));
                loader.setController(controller);

                Parent parentPane = loader.load();
                Scene scene = new Scene(parentPane);

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Turistická databáza: Hlavné menu");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
                //po odhlaseni
                hesloPasswordField.clear();
                loginTextField.clear();
                hlaskaLabel.textProperty().set("Odhlásenie úspešné");
                chybaLabel.textProperty().set(null);
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }
}
