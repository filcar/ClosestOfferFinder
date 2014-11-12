/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offerfinderalpha;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alext_000
 */
public class HelperTest {
    
    public HelperTest() {
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
     * Test of getStoreByID method, of class Helper.
     */
    @Test
    public void testGetStoreByID() {
        System.out.println("getStoreByID");
        int id = 2;
        Helper instance = new Helper();
        Stores expResult = new Stores();
        expResult.setId(2);
        expResult.setName("eShop");
        Stores result = instance.getStoreByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
