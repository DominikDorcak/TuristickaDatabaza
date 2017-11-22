
package paz1c.projekt.turistickaDatabaza;


public class PouzivatelDao implements Pouzivatel {
    
   private long id;
   private String login;
   private String heslo;
   private String email;
   private boolean admin;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getHeslo() {
        return heslo;
    }

    @Override
    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean isAdmin() {
        return admin;
    }

    @Override
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
   
   
   
}
