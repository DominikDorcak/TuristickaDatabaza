/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paz1c.projekt.turistickadatabaza;

/**
 *
 * @author dominik
 */
public class RecenziaDao implements Recenzia {
    
    private long idLokality;
    private long idPouzivatela;
    private String text;

    @Override
    public long getIdLokality() {
        return idLokality;
    }

    @Override
    public void setIdLokality(long idLokality) {
        this.idLokality = idLokality;
    }

    @Override
    public long getIdPouzivatela() {
        return idPouzivatela;
    }

    @Override
    public void setIdPouzivatela(long idPouzivatela) {
        this.idPouzivatela = idPouzivatela;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
