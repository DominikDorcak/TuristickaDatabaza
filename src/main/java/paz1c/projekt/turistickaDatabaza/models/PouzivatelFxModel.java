
package paz1c.projekt.turistickaDatabaza.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PouzivatelFxModel {
    
    private StringProperty login = new SimpleStringProperty();
    private StringProperty heslo = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();

    public String getLogin() {
        return login.get();
    }
    public StringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getHeslo() {
        return heslo.get();
    }
    public StringProperty hesloProperty() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo.set(heslo);
    }

    public String getEmail() {
        return email.get();
    }
     public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
    
    
    
}
