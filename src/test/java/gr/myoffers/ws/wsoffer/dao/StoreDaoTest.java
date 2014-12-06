/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.dao;

import gr.myoffers.ws.wsoffer.model.Store;
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
 * @author alext_000
 */

public class StoreDaoTest {

    public StoreDaoTest() {
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

//    @Test
//    public void testGetStoreById() {
//        System.out.println("getStoreById");
//        int storeId = 2;
//        String storeName = "carrefour";
//        StoreDao instance = new StoreDao();
//        Store expResult = new Store();
//        expResult.setStoreName(storeName);
//        Store result = instance.getStoreById(storeId);
//        assertEquals(expResult.toString(), result.toString());
//    }
//
//    @Test
//    public void testGetStoreByIdIsZero() {
//        System.out.println("getStoreByIdIsZero");
//        int storeId = 0;
//        StoreDao instance = new StoreDao();
//        Store expResult = null;
//        Store result = instance.getStoreById(storeId);
//        assertEquals(expResult, result);
//    }
//    
//    @Test
//    public void testGetStoreByIdDoesNotExist() {
//        System.out.println("getStoreByIdDoesNotExist");
//        int storeId = 100;
//        StoreDao instance = new StoreDao();
//        Store expResult = null;
//        Store result = instance.getStoreById(storeId);
//        assertEquals(expResult, result);
//    }
//    
//    @Test
//    public void testGetAllStores() {
//        System.out.println("getAllStores");
//        StoreDao instance = new StoreDao();
//        List<Store> expResult = new ArrayList<>();
//        Store company1 = new Store();
//        Store company2 = new Store();
//        Store company3 = new Store();
//        company1.setStoreName("carrefour");
//        expResult.add(company1);
//        company2.setStoreName("κάντζας");
//        expResult.add(company2);
//        company3.setStoreName("μασούτης");
//        expResult.add(company3);
//        List<Store> result = instance.getAllStores();
//        assertEquals(expResult.toString(), result.toString());
//    }
//
//    @Test
//    public void testGetStoresByRadius() {
//        System.out.println("getStoresByRadius");
//        double lat = 40;
//        double lon = 40;
//        double r = 100;
//        StoreDao instance = new StoreDao();
//        List<Store> expResult = new ArrayList<>();
//        Store store1 = new Store();
//        Store store2 = new Store();
//        Store store3 = new Store();
//        store1.setStoreName("μασούτης");
//        expResult.add(store1);
//        store2.setStoreName("carrefour");
//        expResult.add(store2);
//        store3.setStoreName("κάντζας");
//        expResult.add(store3);
//        List<Store> result = instance.getStoresByRadius(lat, lon, r);
//        assertEquals(expResult.toString(), result.toString());
//    }
//
//    @Test
//    public void testGetStoresByRadiusIsZero() {
//        System.out.println("getStoresByRadiusIsZero");
//        double lat = 40;
//        double lon = 40;
//        double r = 0;
//        StoreDao instance = new StoreDao();
//        List<Store> expResult = new ArrayList<>();
//        List<Store> result = instance.getStoresByRadius(lat, lon, r);
//        assertEquals(expResult.toString(), result.toString());
//    }
//    
}
