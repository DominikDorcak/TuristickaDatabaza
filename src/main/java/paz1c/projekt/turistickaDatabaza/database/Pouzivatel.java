package paz1c.projekt.turistickaDatabaza.database;

import java.util.ArrayList;
import java.util.List;

public class Pouzivatel {

    private String login;
    private String heslo;
    private String email;
    private boolean admin = false;
    private List<Lokalita> oblubene = new ArrayList();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Lokalita> getOblubene() {
        return oblubene;
    }

    public void setOblubene(List<Lokalita> oblubene) {
        this.oblubene = oblubene;
    }

}
