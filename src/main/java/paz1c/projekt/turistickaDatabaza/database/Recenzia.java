
package paz1c.projekt.turistickaDatabaza.database;




public class Recenzia  {
    
    private long idLokality;
    private long idPouzivatela;
    private String text;

    
    public long getIdLokality() {
        return idLokality;
    }

    
    public void setIdLokality(long idLokality) {
        this.idLokality = idLokality;
    }

    
    public long getIdPouzivatela() {
        return idPouzivatela;
    }

    
    public void setIdPouzivatela(long idPouzivatela) {
        this.idPouzivatela = idPouzivatela;
    }

    
    public String getText() {
        return text;
    }

    
    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
