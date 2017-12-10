/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paz1c.projekt.turistickaDatabaza;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Michal
 */
public class AddLocationController implements Initializable {

    @FXML
    private Button CreateLocationButton;
    @FXML
    private TextField nazovTextField;
    @FXML
    private TextField regionTextField;
    @FXML
    private TextArea popisTextField;
    @FXML
    private Button CancelButton;
    @FXML
    private TextField suradnicaXTextField;
    @FXML
    private TextField suradnicaYTextField;
    @FXML
    private TextField suborTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
