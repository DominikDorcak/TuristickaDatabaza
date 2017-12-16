package paz1c.projekt.turistickaDatabaza.database;

import java.util.List;

public interface PouzivatelDao {

    List<Pouzivatel> getAll();

    Pouzivatel getByLogin(String login);

    void saveNew(Pouzivatel pouzivatel);
    
    boolean povysByLogin(String login);
    
    public boolean deleteByLogin(String login);
    
    public boolean pridajOblubenu(Lokalita lokalita,Pouzivatel pouzivatel);

}
