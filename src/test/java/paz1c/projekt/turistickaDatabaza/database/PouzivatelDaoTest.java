package paz1c.projekt.turistickaDatabaza.database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import paz1c.projekt.turistickaDatabaza.DaoFactory;
import paz1c.projekt.turistickaDatabaza.database.Lokalita;
import paz1c.projekt.turistickaDatabaza.database.Pouzivatel;
import paz1c.projekt.turistickaDatabaza.database.PouzivatelDao;

/**
 *
 * @author Michal
 */
public class PouzivatelDaoTest {
    private PouzivatelDao dao;
    
    public PouzivatelDaoTest() {
        dao = DaoFactory.INSTANCE.getPouzivatelDao();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    @Test
    public void getAllTest(){
        
        Pouzivatel p = new Pouzivatel();
        p.setLogin("test");
        p.setHeslo("test");
        p.setEmail("test@test.sk");
        dao.saveNew(p);
        List<Pouzivatel> list = dao.getAll();
        assertTrue(!list.isEmpty());
        dao.deleteByLogin(p.getLogin());
       
        
    }
    @Test
    public void getByLoginTest(){
        Pouzivatel p = new Pouzivatel();
        p.setLogin("test");
        p.setHeslo("test");
        p.setEmail("test@test.sk");
        dao.saveNew(p);
        assertNotNull(dao.getByLogin("test"));
        dao.deleteByLogin("test");
        
    }
    
    @Test
    public void saveNewTest(){
        int velkost = dao.getAll().size();
        Pouzivatel p = new Pouzivatel();
        p.setLogin("test");
        p.setHeslo("test");
        p.setEmail("test@test.sk");
        dao.saveNew(p);
        assertNotNull(dao.getByLogin("test"));
        assertEquals(velkost + 1 , dao.getAll().size());
    }
    @Test
    public void povysByLoginTest(){
        Pouzivatel p = new Pouzivatel();
        p.setLogin("test");
        p.setHeslo("test");
        p.setEmail("test@test.sk");
        dao.saveNew(p);
        dao.povysByLogin("test");
        assertTrue(dao.getByLogin("test").isAdmin());
        dao.deleteByLogin("test");
    }
    @Test
    public void deleteByLoginTest(){
        int velkost = dao.getAll().size();
        Pouzivatel p = new Pouzivatel();
        p.setLogin("test");
        p.setHeslo("test");
        p.setEmail("test@test.sk");
        dao.saveNew(p);
        dao.deleteByLogin("test");
        assertTrue(velkost == dao.getAll().size());
             
    }
    @Test
    public void pridajOblubenuTest(){
        
        Pouzivatel p = new Pouzivatel();
        p.setLogin("test");
        p.setHeslo("test");
        p.setEmail("test@test.sk");
        
        Lokalita l = new Lokalita();
        l.setNazov("test");               
        l.setRegion("test");
        l.setPopis("test");        
        dao.pridajOblubenu(l, p);
        
        assertTrue(!p.getOblubene().isEmpty());
        
        dao.deleteByLogin("test");
    }
}
