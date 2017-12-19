package paz1c.projekt.turistickaDatabaza.database;


import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import paz1c.projekt.turistickaDatabaza.DaoFactory;
import paz1c.projekt.turistickaDatabaza.database.Lokalita;
import paz1c.projekt.turistickaDatabaza.database.LokalitaDao;

/**
 *
 * @author Michal
 */
public class LokalitaDaoTest {

    private LokalitaDao dao;

    public LokalitaDaoTest() {
        dao = DaoFactory.INSTANCE.getLokalitaDao();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void fillRecenzieTest() {
        // !!!! MISSING nepotrebny??
    }

    @Test
    public void getByIdTest() {
        Lokalita l = new Lokalita();
        l.setNazov("test");
        l.setRegion("test");
        l.setPopis("test");
        dao.saveNew(l);
        assertNotNull(dao.getById(l.getId()));
        dao.deleteById(l.getId());
    }

    @Test
    public void getNaSchvalenieTest() {
        List<Lokalita> list = dao.getNaSchvalenie();
        assertNotNull(list);
        
        if (!list.isEmpty()){
        for (Lokalita l : list) {
            assertTrue(!l.isSchvalena());
        }
        }
    }

    @Test
    public void getSchvalenaTest() {
        List<Lokalita> list = dao.getNaSchvalenie();
        assertNotNull(list);
        
        if (!list.isEmpty()){
        for (Lokalita l : list) {
            assertTrue(l.isSchvalena());
        }
        }
    }

    @Test
    public void saveNewTest() {
        int velkost = dao.getNaSchvalenie().size();
        Lokalita l = new Lokalita();
        l.setNazov("test");
        l.setRegion("test");
        l.setPopis("test");
        assertTrue(dao.saveNew(l));
        assertTrue(dao.getNaSchvalenie().size() == velkost+1);
        dao.deleteById(l.getId());
    }

    @Test
    public void schvalByIdTest() {
        int velkostSchvalenych = dao.getSchvalena().size();
        Lokalita l = new Lokalita();
        l.setNazov("test");
        l.setRegion("test");
        l.setPopis("test");
        dao.saveNew(l);
        int velkostNaSchvalenie = dao.getNaSchvalenie().size();
        assertTrue(dao.schvalById(l.getId()));
        assertTrue(velkostSchvalenych+1==dao.getSchvalena().size());
        assertTrue(velkostNaSchvalenie-1==dao.getNaSchvalenie().size());
        dao.deleteById(l.getId());
    }
    
    
    
    @Test
    public void deleteByIdTest() {
        int velkost = dao.getNaSchvalenie().size();
        Lokalita l = new Lokalita();
        l.setNazov("test");
        l.setRegion("test");
        l.setPopis("test");
        dao.saveNew(l);
        assertTrue(dao.deleteById(l.getId()));
        assertTrue(velkost == dao.getNaSchvalenie().size());
    }
    
}
