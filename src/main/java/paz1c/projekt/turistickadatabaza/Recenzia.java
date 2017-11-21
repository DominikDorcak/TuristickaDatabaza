
package paz1c.projekt.turistickadatabaza;


public interface Recenzia {

    long getIdLokality();

    long getIdPouzivatela();

    String getText();

    void setIdLokality(long idLokality);

    void setIdPouzivatela(long idPouzivatela);

    void setText(String text);
    
}
