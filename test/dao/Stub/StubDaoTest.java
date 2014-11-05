/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Stub;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Giannis
 */
public class StubDaoTest {
    public StubDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class StubDao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        StubDao instance = new StubDao(0,null,null,0.0,0.0,null,null,null,0.0);
        String expResult = "/n" + 0 + ", " + null + ", " + null + ", " + 
                0.0 + ", " + 0.0 + ", " + null + ", " + null 
                + ", " + null + ", " + 0.0 ;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFeed method, of class StubDao.
     */
    @Test
    public void testGetFeed() {
        System.out.println("getFeed");
        StubDao instance = new StubDao(1, "Μασούτης", "Μεραρχίας 50, Σέρρες", 41.086163, 23.546056, "Λευκό Κρασί 750ml", "Ποτά", "-50%", 3.94 );        
        List<Object> expResult = new ArrayList<>();
        expResult.add(1);
        expResult.add("Μασούτης");
        expResult.add("Μεραρχίας 50, Σέρρες");
        expResult.add(41.086163);
        expResult.add(23.546056);
        expResult.add("Λευκό Κρασί 750ml");
        expResult.add("Ποτά");
        expResult.add("-50%");
        expResult.add(3.94);       
        List<Object> result = instance.getFeed();      
        assertEquals(expResult.toString(), result.toString());
       
    }
    
    /**
     * Test of getFeed method, of class StubDao.
     */
    @Test
    public void testGetFeedNotNull(){
        System.out.println("getFeedNotNull");
        StubDao instance = new StubDao(1, "Μασούτης", "Μεραρχίας 50, Σέρρες", 41.086163, 23.546056, "Λευκό Κρασί 750ml", "Ποτά", "-50%", 3.94 );
        List<Object> result = instance.getFeed();
        assertNotNull(result);
    }
    
    /**
     * Test of getFeed method, of class StubDao.
     */
    @Test
    public void testGetFeedMultipleLists(){
        System.out.println("getFeedMultipleLists");
        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        StubDao instance = new StubDao(1, "Μασούτης", "Μεραρχίας 50, Σέρρες", 41.086163, 23.546056, "Λευκό Κρασί 750ml", "Ποτά", "-50%", 3.94 );        
        StubDao instance2 = new StubDao(2, "Μασούτης", "Μεραρχίας 50, Σέρρες", 41.086163, 23.546056, "Λευκό Κρασί 750ml", "Ποτά", "-50%", 3.94 );
        //The first list
        list1.add(1);
        list1.add("Μασούτης");
        list1.add("Μεραρχίας 50, Σέρρες");
        list1.add(41.086163);
        list1.add(23.546056);
        list1.add("Λευκό Κρασί 750ml");
        list1.add("Ποτά");
        list1.add("-50%");
        list1.add(3.94);
        //The second list
        list2.add(2);
        list2.add("Μασούτης");
        list2.add("Μεραρχίας 50, Σέρρες");
        list2.add(41.086163);
        list2.add(23.546056);
        list2.add("Λευκό Κρασί 750ml");
        list2.add("Ποτά");
        list2.add("-50%");
        list2.add(3.94);
        List<Object> result = new ArrayList<>();
        List<Object> expResult = new ArrayList<>();
        result.add(instance.getFeed());
        result.add(instance2.getFeed());
        expResult.add(list1);
        expResult.add(list2);
        assertEquals(expResult.toString(), result.toString());
    }
    
    /**
     * Test of getFeed method, of class StubDao.
     */
    @Test
    public void testGetFeedIsFalse(){
        System.out.println("getFeedIsFalse");
        StubDao instance = new StubDao(1, "Μασούτης", "Μεραρχίας 50, Σέρρες", 41.086163, 23.546056, "Λευκό Κρασί 750ml", "Ποτά", "-50%", 3.94 );
        List<Object> expResult = new ArrayList<>();
        expResult.add(434);
        expResult.add("testIsFalse");
        expResult.add("testIsFalse");
        expResult.add(545);
        expResult.add(96589);
        expResult.add("testIsFalse");
        expResult.add("testIsFalse");
        expResult.add("testIsFalse");
        expResult.add(5200);
        List<Object> result = instance.getFeed();
        assertFalse(result.equals(expResult));
    }
    
    
}
