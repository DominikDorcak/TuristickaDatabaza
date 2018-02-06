package paz1c.projekt.turistickaDatabaza;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dominik
 */
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import paz1c.projekt.turistickaDatabaza.DaoFactory;
import paz1c.projekt.turistickaDatabaza.database.Lokalita;
import paz1c.projekt.turistickaDatabaza.database.Pouzivatel;
import paz1c.projekt.turistickaDatabaza.database.Recenzia;
import paz1c.projekt.turistickaDatabaza.models.RecenziaFxModel;

public class PridatRecenziuController {

    private Pouzivatel prihlasenyPouzivatel;
    private Lokalita aktualnaLokalita;
    private RecenziaFxModel recenziaFxModel = new RecenziaFxModel();
    

    public PridatRecenziuController(Pouzivatel prihlasenyPouzivatel, Lokalita aktualnaLokalita) {
        this.prihlasenyPouzivatel = prihlasenyPouzivatel;
        this.aktualnaLokalita = aktualnaLokalita;
    }
    
    public PridatRecenziuController(Pouzivatel prihlasenyPouzivatel, Lokalita aktualnaLokalita,Recenzia recenzia) {
        this.prihlasenyPouzivatel = prihlasenyPouzivatel;
        aktualnaLokalita.getRecenzie().remove(recenzia);
        this.aktualnaLokalita = aktualnaLokalita;
        this.recenziaFxModel.setHodnotenie(recenzia.getHodnotenie());
        this.recenziaFxModel.setId(recenzia.getId());
        this.recenziaFxModel.setText(recenzia.getText());
        
    }
    
    
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lokalitaLabel;

    @FXML
    private Label PouzivatelLabel;

    @FXML
    private TextArea textTextArea;

    @FXML
    private ComboBox<Integer> hodnotenieComboBox;

    @FXML
    private Label hlaskaLabel;

    @FXML
    private Button UlozitButton;

    @FXML
    private Button odistButton;

    @FXML
    void initialize() {
       lokalitaLabel.textProperty().set("Lokalita: " + aktualnaLokalita.getNazov());
       PouzivatelLabel.textProperty().set( "Používateľ" + prihlasenyPouzivatel.getLogin());
       recenziaFxModel.setLokalitaId(aktualnaLokalita.getId());
       recenziaFxModel.setPouzivatelLogin(prihlasenyPouzivatel.getLogin());
       
       textTextArea.textProperty().bindBidirectional(recenziaFxModel.TextProperty());
       hodnotenieComboBox.getItems().addAll(0,1,2,3,4,5);
       hodnotenieComboBox.setValue(0);
       
       UlozitButton.setOnAction(eh -> {
       Recenzia r = new Recenzia();
       if(!(recenziaFxModel.getId() == null))
            r.setId(recenziaFxModel.getId());
       r.setIdLokality(recenziaFxModel.getLokalitaId());
       r.setLoginPouzivatela(recenziaFxModel.getPouzivatelLogin());
       r.setText(recenziaFxModel.getText());
       r.setHodnotenie(hodnotenieComboBox.getValue());
       r.setDatum(Timestamp.valueOf(LocalDateTime.now()));
              

           DaoFactory.INSTANCE.getRecenziaDao().save(r);
           aktualnaLokalita.getRecenzie().add(r);
           aktualnaLokalita.PriemerneHodnotenie();
           
           UlozitButton.getScene().getWindow().hide();
       
       });
       
       
       odistButton.setOnAction(eh -> {
       odistButton.getScene().getWindow().hide();
       });
       
    }
}

