/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.services;

import gr.myoffers.ws.wsoffer.model.Company;
import gr.myoffers.ws.wsoffer.model.Offer;
import gr.myoffers.ws.wsoffer.model.Response;
import gr.myoffers.ws.wsoffer.model.Store;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fil
 */
public class Service1Test {
    
    public Service1Test() {
    }

    /**
     * Test of getOfferByIdJSON method, of class Service.
     */
    @Test
    public void testGetOfferByIdJSON() {
        System.out.println("getOfferByIdJSON");
        int offerId = 0;
        Service instance = new Service();
        Offer expResult = null;
        Offer result = instance.getOfferByIdJSON(offerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllOffersJSON method, of class Service.
     */
    @Test
    public void testGetAllOffersJSON() {
        System.out.println("getAllOffersJSON");
        Service instance = new Service();
        List<Offer> expResult = null;
        List<Offer> result = instance.getAllOffersJSON();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOffersByDiscJSON method, of class Service.
     */
    @Test
    public void testGetOffersByDiscJSON() {
        System.out.println("getOffersByDiscJSON");
        double disc = 0.0;
        Service instance = new Service();
        List<Offer> expResult = null;
        List<Offer> result = instance.getOffersByDiscJSON(disc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOffersByCityJSON method, of class Service.
     */
    @Test
    public void testGetOffersByCityJSON() {
        System.out.println("getOffersByCityJSON");
        String city = "";
        Service instance = new Service();
        List<Offer> expResult = null;
        List<Offer> result = instance.getOffersByCityJSON(city);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxDisqOffersJSON method, of class Service.
     */
    @Test
    public void testGetMaxDisqOffersJSON() {
        System.out.println("getMaxDisqOffersJSON");
        Service instance = new Service();
        List<Offer> expResult = null;
        List<Offer> result = instance.getMaxDisqOffersJSON();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVersionWsJSON method, of class Service.
     */
    @Test
    public void testGetVersionWsJSON() {
        System.out.println("getVersionWsJSON");
        Service instance = new Service();
        String expResult = "";
        String result = instance.getVersionWsJSON();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStoreByIdJSON method, of class Service.
     */
    @Test
    public void testGetStoreByIdJSON() throws Exception {
        System.out.println("getStoreByIdJSON");
        String sstoreId = "";
        Service instance = new Service();
        Store expResult = null;
        Store result = instance.getStoreByIdJSON(sstoreId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllStoresJSON method, of class Service.
     */
    @Test
    public void testGetAllStoresJSON() {
        System.out.println("getAllStoresJSON");
        Service instance = new Service();
        List<Store> expResult = null;
        List<Store> result = instance.getAllStoresJSON();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStoresByRadiusJSON method, of class Service.
     */
    @Test
    public void testGetStoresByRadiusJSON() throws Exception {
        System.out.println("getStoresByRadiusJSON");
        double lat = 0.0;
        double lon = 0.0;
        double r = 0.0;
        Service instance = new Service();
        List<Store> expResult = null;
        List<Store> result = instance.getStoresByRadiusJSON(lat, lon, r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOnlyStoresByRadiusJSON method, of class Service.
     */
    @Test
    public void testGetOnlyStoresByRadiusJSON() throws Exception {
        System.out.println("getOnlyStoresByRadiusJSON");
        double lat = 0.0;
        double lon = 0.0;
        double r = 0.0;
        Service instance = new Service();
        List<Response> expResult = null;
        List<Response> result = instance.getOnlyStoresByRadiusJSON(lat, lon, r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOnlyCompanyByIdJSON method, of class Service.
     */
    @Test
    public void testGetOnlyCompanyByIdJSON() throws Exception {
        System.out.println("getOnlyCompanyByIdJSON");
        String sId = "";
        Service instance = new Service();
        Response expResult = null;
        Response result = instance.getOnlyCompanyByIdJSON(sId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompanyByIdJSON method, of class Service.
     */
    @Test
    public void testGetCompanyByIdJSON() throws Exception {
        System.out.println("getCompanyByIdJSON");
        String sId = "";
        Service instance = new Service();
        Company expResult = null;
        Company result = instance.getCompanyByIdJSON(sId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCompaniesOnlyJSON method, of class Service.
     */
    @Test
    public void testGetAllCompaniesOnlyJSON() {
        System.out.println("getAllCompaniesOnlyJSON");
        Service instance = new Service();
        List<Response> expResult = null;
        List<Response> result = instance.getAllCompaniesOnlyJSON();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCompaniesJSON method, of class Service.
     */
    @Test
    public void testGetAllCompaniesJSON() {
        System.out.println("getAllCompaniesJSON");
        Service instance = new Service();
        List<Company> expResult = null;
        List<Company> result = instance.getAllCompaniesJSON();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOffersByRadiusJSON method, of class Service.
     */
    @Test
    public void testGetOffersByRadiusJSON() throws Exception {
        System.out.println("getOffersByRadiusJSON");
        double lat = 0.0;
        double lon = 0.0;
        double r = 0.0;
        Service instance = new Service();
        List<Offer> expResult = null;
        List<Offer> result = instance.getOffersByRadiusJSON(lat, lon, r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
