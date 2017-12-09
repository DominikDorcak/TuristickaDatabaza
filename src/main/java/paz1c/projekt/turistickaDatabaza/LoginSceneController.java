package paz1c.projekt.turistickaDatabaza;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    void initialize() {
        loginTextField.textProperty().bindBidirectional(pouzivatelModel.loginProperty());
        
        hesloPasswordField.textProperty().bindBidirectional(pouzivatelModel.hesloProperty());
        
        loginButton.setOnAction(eh -> {
            Pouzivatel pouzivatel = DaoFactory.INSTANCE.getPouzivatelDao().getByLogin(pouzivatelModel.getLogin());
            if(pouzivatel != null){
                if(pouzivatelModel.getHeslo().equals(pouzivatel.getHeslo())){
                    System.out.println("vyslo to!!");
                }
            }
        });
        
        
        registraciaButton.setOnAction(eh ->{
        RegistrationSceneController controller = 
                    new RegistrationSceneController();
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
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        });

    }
}
