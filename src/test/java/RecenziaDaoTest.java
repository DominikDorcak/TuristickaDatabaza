

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import paz1c.projekt.turistickaDatabaza.DaoFactory;
import paz1c.projekt.turistickaDatabaza.database.RecenziaDao;

/**
 *
 * @author Michal
 */
public class RecenziaDaoTest {
    private RecenziaDao dao;
    public RecenziaDaoTest() {
        dao = DaoFactory.INSTANCE.getRecenziaDao();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void saveTest(){
        // !!!! MISSING
    }

}
