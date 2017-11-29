package paz1c.projekt.turistickaDatabaza;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
        

    }
}
