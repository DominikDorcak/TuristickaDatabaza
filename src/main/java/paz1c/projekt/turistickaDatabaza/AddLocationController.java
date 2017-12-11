/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paz1c.projekt.turistickaDatabaza;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import paz1c.projekt.turistickaDatabaza.database.Lokalita;
import paz1c.projekt.turistickaDatabaza.models.LokalitaFxModel;

/**
 * FXML Controller class
 *
 * @author Michal
 */
public class AddLocationController{
    private LokalitaFxModel lokalitaFxModel = new LokalitaFxModel();
    
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
    private TextField suborTextField;

    @FXML
    public void initialize() {
        nazovTextField.textProperty().bindBidirectional(lokalitaFxModel.nazovProperty());
        regionTextField.textProperty().bindBidirectional(lokalitaFxModel.regionProperty());
        popisTextField.textProperty().bindBidirectional(lokalitaFxModel.popisProperty());
        
        CreateLocationButton.setOnAction(eh->{ 
        if(nazovTextField.getText() == null){
            nazovTextField.setText("Zadaj názov");
            return;
        }
        if(regionTextField.getText() == null){
            nazovTextField.setText("Zadaj región");
            return;
        }
        if(popisTextField.getText() == null){
            popisTextField.setText("Zadaj popis");
            return;
        }
        Lokalita lokalita = new Lokalita();
        lokalita.setNazov(lokalitaFxModel.getNazov());
        lokalita.setRegion(lokalitaFxModel.getRegion());
        lokalita.setPopis(lokalitaFxModel.getPopis());
        DaoFactory.INSTANCE.getLokalitaDao().saveNew(lokalita); 
        CreateLocationButton.getScene().getWindow().hide();
        });
        
        CancelButton.setOnAction(eh ->{
        CancelButton.getScene().getWindow().hide();
        });
    }    
    
}
