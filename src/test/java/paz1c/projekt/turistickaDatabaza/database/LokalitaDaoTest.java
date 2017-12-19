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
        // !!!! MISSING
    }

    @Test
    public void getByIdTest() {
        Lokalita l = new Lokalita();
        l.setNazov("test");
        l.setRegion("test");
        l.setPopis("test");
        dao.saveNew(l);
        assertEquals(l, dao.getById(l.getId()));
    }

    @Test
    public void getNaSchvalenieTest() {
        List<Lokalita> list = dao.getNaSchvalenie();
        assertNotNull(list);
        if (list != null) {
            assertTrue(list.size() > 0);
        }
        for (Lokalita l : list) {
            assertTrue(!l.isSchvalena());
        }
    }

    @Test
    public void getSchvalenaTest() {
        List<Lokalita> list = dao.getSchvalena();
        assertNotNull(list);
        if (list != null) {
            assertTrue(list.size() > 0);
        }
        for (Lokalita l : list) {
            assertTrue(l.isSchvalena());
        }

    }

    @Test
    public void saveNewTest() {
        int velkost = dao.getNaSchvalenie().size();
        Lokalita l = new Lokalita();
        l.setNazov("test");
        l.setRegion("test");
        l.setPopis("test");
        dao.saveNew(l);
        assertTrue(dao.getNaSchvalenie().size() == velkost+1);
    }

    @Test
    public void schvalByIdTest() {
        int velkostSchvalenych = dao.getSchvalena().size();
        int velkostNaSchvalenie = dao.getNaSchvalenie().size();
        Lokalita l = new Lokalita();
        l.setNazov("test");
        l.setRegion("test");
        l.setPopis("test");
        dao.saveNew(l);
        dao.schvalById(l.getId());
        assertEquals(velkostSchvalenych+1,dao.getSchvalena());
        assertEquals(velkostNaSchvalenie-1,dao.getNaSchvalenie());
    }
}
