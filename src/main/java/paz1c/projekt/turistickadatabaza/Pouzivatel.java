
package paz1c.projekt.turistickadatabaza;

public interface Pouzivatel {

    String getEmail();

    String getHeslo();

    long getId();

    String getLogin();

    boolean isAdmin();

    void setAdmin(boolean admin);

    void setEmail(String email);

    void setHeslo(String heslo);

    void setId(long id);

    void setLogin(String login);
    
}
