/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paz1c.projekt.turistickaDatabaza;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import paz1c.projekt.turistickaDatabaza.database.Lokalita;
import paz1c.projekt.turistickaDatabaza.database.Pouzivatel;
import paz1c.projekt.turistickaDatabaza.models.PouzivatelTableFxModel;

/**
 *
 * @author dominik
 */
class UserManagementController {

    private PouzivatelTableFxModel pouzivatelTableFxModel = new PouzivatelTableFxModel();

    @FXML
    private TableView<Pouzivatel> Pouzivatelia_table;

    @FXML
    private Button vymazatPouzivatelaButton;

    @FXML
    private Button povysitButton;

    @FXML
    private Button exitButton;

    @FXML
    void initialize() {
        Pouzivatelia_table.getColumns().clear();
        TableColumn loginCol = new TableColumn("Login");
        loginCol.setCellValueFactory(new PropertyValueFactory<Pouzivatel, String>("login"));
        Pouzivatelia_table.getColumns().add(loginCol);
        TableColumn adminCol = new TableColumn("Admin");
        adminCol.setCellValueFactory(new PropertyValueFactory<Pouzivatel, Boolean>("admin"));
        Pouzivatelia_table.getColumns().add(adminCol);
        pouzivatelTableFxModel.naplnPouzivatelov();
        Pouzivatelia_table.setItems(pouzivatelTableFxModel.getPouzivatelia());

        exitButton.setOnAction(eh -> {
            exitButton.getScene().getWindow().hide();
        });
    }

}
