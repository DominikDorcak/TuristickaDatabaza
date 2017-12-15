/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paz1c.projekt.turistickaDatabaza.models;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import paz1c.projekt.turistickaDatabaza.DaoFactory;
import paz1c.projekt.turistickaDatabaza.database.Pouzivatel;

/**
 *
 * @author dominik
 */
public class PouzivatelTableFxModel {
    
    private ObservableList<Pouzivatel> pouzivatelia;
    
    public ObservableList<Pouzivatel> getPouzivatelia() {
        return pouzivatelia;
    }
    
    public void setPouzivatelia(ObservableList<Pouzivatel> pouzivatelia) {
        this.pouzivatelia = pouzivatelia;
    }
    
    public void naplnPouzivatelov() {
        List<Pouzivatel> pouz = DaoFactory.INSTANCE.getPouzivatelDao().getAll();
        setPouzivatelia(FXCollections.observableArrayList(pouz));
        
    }
}
