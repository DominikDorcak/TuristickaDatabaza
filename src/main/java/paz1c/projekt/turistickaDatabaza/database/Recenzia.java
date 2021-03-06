package paz1c.projekt.turistickaDatabaza.database;

import java.sql.Timestamp;

public class Recenzia {

    private Long id;
    private long idLokality;
    private String loginPouzivatela;
    private String text;
    private int hodnotenie;
    private Timestamp datum;

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

    public Timestamp getDatum() {
        return datum;
    }

    public void setDatum(Timestamp datum) {
        this.datum = datum;
    }

    public Long getId() {
        if (id == null) {
            return null;
        }
        return id;
    }

    public void setId(Long id) {
        if (id == null) {
        } else {
            this.id = id;
        }
    }

}
