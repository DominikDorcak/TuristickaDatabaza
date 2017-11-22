
package paz1c.projekt.turistickaDatabaza;


public interface Recenzia {

    long getIdLokality();

    long getIdPouzivatela();

    String getText();

    void setIdLokality(long idLokality);

    void setIdPouzivatela(long idPouzivatela);

    void setText(String text);
    
}
