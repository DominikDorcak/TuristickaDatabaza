
package paz1c.projekt.turistickaDatabaza.database;

import java.time.LocalDateTime;




public class Recenzia  {
    
    private long idLokality;
    private String loginPouzivatela;
    private String text;
    private int hodnotenie;
    private LocalDateTime datum;
    

    
    public long getIdLokality() {
        return idLokality;
    }

    
    public void setIdLokality(long idLokality) {
        this.idLokality = idLokality;
    }

    
    public String getLoginPouzivatela() {
        return loginPouzivatela;
    }

    
    public void setLoginPouzivatela(String LoginPouzivatela) {
        this.loginPouzivatela = LoginPouzivatela;
    }

    
    public String getText() {
        return text;
    }

    
    public void setText(String text) {
        this.text = text;
    }

    public int getHodnotenie() {
        return hodnotenie;
    }

    public void setHodnotenie(int hodnotenie) {
        this.hodnotenie = hodnotenie;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }
    
    
    
}
