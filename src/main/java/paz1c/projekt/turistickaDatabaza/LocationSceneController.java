package paz1c.projekt.turistickaDatabaza;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import paz1c.projekt.turistickaDatabaza.database.Lokalita;
import paz1c.projekt.turistickaDatabaza.database.Pouzivatel;
import paz1c.projekt.turistickaDatabaza.database.Recenzia;

public class LocationSceneController {

    private Lokalita vybranaLokalita;
    private Pouzivatel prihlasenyPouzivatel;
    

    @FXML
    private Label Lokalita_label;

    @FXML
    private Label region_label;

    @FXML
    private Label hodnotenie_label;

    @FXML
    private Label popis_label;

    @FXML
    private TableView<Recenzia> recenzie_table;

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
        
        schvalitButton.setVisible(!vybranaLokalita.isSchvalena());
        schvalitButton.setDisable(vybranaLokalita.isSchvalena());
        
        schvalitButton.setOnAction(eh ->{
        boolean uspech = DaoFactory.INSTANCE.getLokalitaDao().schvalById(vybranaLokalita.getId());
        if (uspech){
                hlaskaLabel.textProperty().set("Schválená!");
            }else{
                hlaskaLabel.textProperty().set("Nastala chyba!");
            }
        });
        
        pridatOblubenuButton.setOnAction(eh -> {
            boolean uspech = DaoFactory.INSTANCE.getPouzivatelDao().pridajOblubenu(vybranaLokalita, prihlasenyPouzivatel);
            if (uspech){
                hlaskaLabel.textProperty().set("Pridaná!");
            }else{
                hlaskaLabel.textProperty().set("Nastala chyba!");
            }
        
        });
        
        cancel_button.setOnAction(eh -> {
        cancel_button.getScene().getWindow().hide();
        });
        
        
       

    }
}
