package paz1c.projekt.turistickaDatabaza.database;

import java.util.List;

public interface PouzivatelDao {

    List<Pouzivatel> getAll();

    Pouzivatel getByLogin(String login);

    boolean saveNew(Pouzivatel pouzivatel);
    
    boolean povysByLogin(String login);
    
    boolean deleteByLogin(String login);
    
    boolean pridajOblubenu(Lokalita lokalita,Pouzivatel pouzivatel);

}
