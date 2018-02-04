/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paz1c.projekt.turistickaDatabaza.database;

/**
 *
 * @author dominik
 */
public interface RecenziaDao {

    void save(Recenzia recenzia);
    
    void update(Recenzia recenzia);
    
    boolean deleteById(Long id);

}
