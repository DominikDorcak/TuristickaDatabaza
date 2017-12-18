/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paz1c.projekt.turistickaDatabaza.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author dominik
 */
public class RecenziaFxModel {
    
    private StringProperty pouzivatelLogin = new SimpleStringProperty();
    private LongProperty lokalitaId = new SimpleLongProperty();
    private StringProperty text = new SimpleStringProperty();
    private IntegerProperty hodnotenie = new SimpleIntegerProperty();

    public StringProperty PouzivatelLoginProperty() {
        return pouzivatelLogin;
    }
     public String getPouzivatelLogin() {
        return pouzivatelLogin.get();
    }

    public void setPouzivatelLogin(String pouzivatelLogin) {
        this.pouzivatelLogin.set(pouzivatelLogin);
    }

    public LongProperty LokalitaIdProperty() {
        return lokalitaId;
    }
    public Long getLokalitaId() {
        return lokalitaId.get();
    }

    public void setLokalitaId(Long lokalitaId) {
        this.lokalitaId.set(lokalitaId);
    }

    public StringProperty TextProperty() {
        return text;
    }
    public String getText() {
        return text.get();
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public IntegerProperty HodnotenieProperty() {
        return hodnotenie;
    }
     public Integer getHodnotenie() {
        return hodnotenie.get();
    }

    public void setHodnotenie(Integer hodnotenie) {
        this.hodnotenie.set(hodnotenie);
    }
    
    
    
}
