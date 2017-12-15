package paz1c.projekt.turistickaDatabaza.database;

import java.util.List;

/**
 *
 * @author dominik
 */
public interface LokalitaDao {

    void fillRecenzie(Lokalita lokalita);

    Lokalita getById(Long id);

    List<Lokalita> getNaSchvalenie();

    List<Lokalita> getSchvalena();

    void saveNew(Lokalita l);

}
