
package paz1c.projekt.turistickaDatabaza.database;

import java.util.ArrayList;
import java.util.List;


public class Pouzivatel {
    
   private String login;
   private String heslo;
   private String email;
   private boolean admin = false;
   private List<String> oblubene = new ArrayList();


    

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

    public List<String> getOblubene() {
        return oblubene;
    }

    public void setOblubene(List<String> oblubene) {
        this.oblubene = oblubene;
    }
   
   
   
   
   
    
    
}
