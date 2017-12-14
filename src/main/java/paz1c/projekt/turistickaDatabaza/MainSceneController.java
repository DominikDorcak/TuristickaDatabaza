/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paz1c.projekt.turistickaDatabaza;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import paz1c.projekt.turistickaDatabaza.database.Lokalita;
import paz1c.projekt.turistickaDatabaza.database.Pouzivatel;
import paz1c.projekt.turistickaDatabaza.models.LokalitaFxModel;
import paz1c.projekt.turistickaDatabaza.models.LokalitaTableFxModel;

/**
 * FXML Controller class
 *
 * @author Michal
 */
class MainSceneController {

    private Pouzivatel prihlaseneyPouzivatel;
    private LokalitaTableFxModel lokalitaTableFxModel = new LokalitaTableFxModel();

    @FXML
    private Button pridatLokaciuButton;

    @FXML
    private Button odhlasitButton;

    @FXML
    private Button nacitajOblubeneButton;

    @FXML
    private Button nacitajVsetkyButton;

    @FXML
    private TableView<Lokalita> lokality_table;

    @FXML
    private Label prihlasenyAkoLabel;

    MainSceneController(Pouzivatel prihlasenyPouzivatel) {
        this.prihlaseneyPouzivatel = prihlasenyPouzivatel;
    }

    @FXML
    void initialize() {
        prihlasenyAkoLabel.textProperty().set("Prihlásený ako: " + prihlaseneyPouzivatel.getLogin());

        pridatLokaciuButton.setOnAction(eh -> {
            try {
                AddLocationController controller = new AddLocationController();
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("AddLocation.fxml"));
                loader.setController(controller);

                Parent parentPane = loader.load();
                Scene scene = new Scene(parentPane);

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Turistická daatabáza: nová lokalita ");
                stage.initModality(Modality.WINDOW_MODAL);
                stage.showAndWait();
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        });

        lokality_table.getColumns().clear();
        TableColumn nazovCol = new TableColumn("Lokalita");
        nazovCol.setCellValueFactory(new PropertyValueFactory<Lokalita, String>("nazov"));
        lokality_table.getColumns().add(nazovCol);
        TableColumn regionCol = new TableColumn("Región");
        regionCol.setCellValueFactory(new PropertyValueFactory<Lokalita, String>("region"));
        lokality_table.getColumns().add(regionCol);

        lokalitaTableFxModel.loadAll();
        lokality_table.setItems(lokalitaTableFxModel.getLokality());

        nacitajOblubeneButton.setOnAction(eh -> {
            lokalitaTableFxModel.loadOblubene(prihlaseneyPouzivatel);
            lokality_table.setItems(lokalitaTableFxModel.getLokality());
        });

        nacitajVsetkyButton.setOnAction(eh -> {
            lokalitaTableFxModel.loadAll();
            lokality_table.setItems(lokalitaTableFxModel.getLokality());
        });

        odhlasitButton.setOnAction(eh -> {
            odhlasitButton.getScene().getWindow().hide();
        });
    }

}
