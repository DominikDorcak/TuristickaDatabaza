package paz1c.projekt.turistickaDatabaza;

import java.io.IOException;
import java.sql.Timestamp;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import paz1c.projekt.turistickaDatabaza.database.Lokalita;
import paz1c.projekt.turistickaDatabaza.database.Pouzivatel;
import paz1c.projekt.turistickaDatabaza.database.Recenzia;

public class LocationSceneController {

    private Lokalita vybranaLokalita;
    private Pouzivatel prihlasenyPouzivatel;
    private Recenzia vybranaRecenzia;

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
    private Button vymazatRecenziuButton;
    
    

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
        
        recenzie_table.getColumns().clear();
        TableColumn pouzivatelCol = new TableColumn("Používateľ");
        pouzivatelCol.setMinWidth(150);
        pouzivatelCol.setCellValueFactory(new PropertyValueFactory<Recenzia, String>("loginPouzivatela"));
        recenzie_table.getColumns().add(pouzivatelCol);
        
        TableColumn hodnotenieCol = new TableColumn("Hodnotenie");
        hodnotenieCol.setMinWidth(150);
        hodnotenieCol.setCellValueFactory(new PropertyValueFactory<Recenzia, Integer>("hodnotenie"));
        recenzie_table.getColumns().add(hodnotenieCol);
        
        TableColumn textCol = new TableColumn("text recenzie");
        textCol.setCellValueFactory(new PropertyValueFactory<Recenzia, String>("text"));
        textCol.setMinWidth(300);
        recenzie_table.getColumns().add(textCol);
        
         TableColumn datumCol = new TableColumn("Čas pridania");
        datumCol.setCellValueFactory(new PropertyValueFactory<Recenzia, Timestamp>("datum"));
        datumCol.setMinWidth(200);
        recenzie_table.getColumns().add(datumCol);
        
        vymazatRecenziuButton.setDisable(true);
        
        ObservableList<Recenzia> recenzie= FXCollections.observableArrayList(vybranaLokalita.getRecenzie());
        recenzie_table.setItems(recenzie);
         recenzie_table.setOnMousePressed((MouseEvent event) -> {
             if (event.isPrimaryButtonDown()){
                 vybranaRecenzia = recenzie_table.getSelectionModel().getSelectedItem();
                  vymazatRecenziuButton.setDisable(!(prihlasenyPouzivatel.isAdmin() || 
                 vybranaRecenzia.getLoginPouzivatela().equals(prihlasenyPouzivatel.getLogin())));
             }
        });
         
        
         
         vymazatRecenziuButton.setOnAction(eh ->{
         DaoFactory.INSTANCE.getRecenziaDao().deleteById(vybranaRecenzia.getId());
         vybranaLokalita = DaoFactory.INSTANCE.getLokalitaDao().getById(vybranaLokalita.getId());
         ObservableList noveRecenzie= FXCollections.observableArrayList(vybranaLokalita.getRecenzie());
         recenzie_table.setItems(noveRecenzie);
         
         });
        
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
                ObservableList noveRecenzie= FXCollections.observableArrayList(vybranaLokalita.getRecenzie());
                recenzie_table.setItems(noveRecenzie);
                
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        });
        
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
