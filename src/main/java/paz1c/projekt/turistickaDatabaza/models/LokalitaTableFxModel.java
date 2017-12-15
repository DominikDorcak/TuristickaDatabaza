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
import paz1c.projekt.turistickaDatabaza.database.Lokalita;
import paz1c.projekt.turistickaDatabaza.database.Pouzivatel;

/**
 *
 * @author dominik
 */
public class LokalitaTableFxModel {

    private ObservableList<Lokalita> lokality;

    public ObservableList<Lokalita> getLokality() {
        return lokality;
    }

    public void setLokality(ObservableList<Lokalita> lokality) {
        this.lokality = lokality;
    }

    public void loadAll() {
        List<Lokalita> lok = DaoFactory.INSTANCE.getLokalitaDao().getSchvalena();
        setLokality(FXCollections.observableArrayList(lok));
    }

    public void loadOblubene(Pouzivatel prihlasenyPouzivatel) {
        List<Lokalita> lok = prihlasenyPouzivatel.getOblubene();
        setLokality(FXCollections.observableArrayList(lok));
    }

    public void loadNaSchvalenie() {
        List<Lokalita> lok = DaoFactory.INSTANCE.getLokalitaDao().getNaSchvalenie();
        setLokality(FXCollections.observableArrayList(lok));
    }
}
