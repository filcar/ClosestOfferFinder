/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.dao;

import gr.myoffers.ws.wsoffer.model.Company;
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

public class CompanyDaoTest {

    public CompanyDaoTest() {
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

    @Test
    public void testGetCompanyById() {
        System.out.println("getCompanyById");
        int companyId = 2;
        String companyName = "carrefour";
        CompanyDao instance = new CompanyDao();
        Company expResult = new Company();
        expResult.setCompName(companyName);
        Company result = instance.getCompanyById(companyId);
        assertEquals(expResult.toString(), result.toString());
    }

    @Test
    public void testGetCompanyByIdIsZero() {
        System.out.println("getCompanyByIdIsZero");
        int companyId = 0;
        CompanyDao instance = new CompanyDao();
        Company expResult = null;
        Company result = instance.getCompanyById(companyId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetCompanyByIdDoesNotExist() {
        System.out.println("getCompanyByIdDoesNotExist");
        int companyId = 100;
        CompanyDao instance = new CompanyDao();
        Company expResult = null;
        Company result = instance.getCompanyById(companyId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAllCompanies() {
        System.out.println("getAllCompanies");
        CompanyDao instance = new CompanyDao();
        List<Company> expResult = new ArrayList<>();
        Company company1 = new Company();
        Company company2 = new Company();
        Company company3 = new Company();
        company1.setCompName("carrefour");
        expResult.add(company1);
        company2.setCompName("κάντζας");
        expResult.add(company2);
        company3.setCompName("μασούτης");
        expResult.add(company3);
        List<Company> result = instance.getAllCompanies();
        assertEquals(expResult.toString(), result.toString());
    }

    @Test
    public void testGetCompaniesByRadius() {
        System.out.println("getCompaniesByRadius");
        double lat = 40;
        double lon = 40;
        double r = 100;
        CompanyDao instance = new CompanyDao();
        List<Company> expResult = new ArrayList<>();
        Company company1 = new Company();
        Company company2 = new Company();
        Company company3 = new Company();
        company1.setCompName("μασούτης");
        expResult.add(company1);
        company2.setCompName("carrefour");
        expResult.add(company2);
        company3.setCompName("κάντζας");
        expResult.add(company3);
        List<Company> result = instance.getCompaniesByRadius(lat, lon, r);
        assertEquals(expResult.toString(), result.toString());
    }

    @Test
    public void testGetCompaniesByRadiusIsZero() {
        System.out.println("getCompaniesByRadiusIsZero");
        double lat = 40;
        double lon = 40;
        double r = 0;
        CompanyDao instance = new CompanyDao();
        List<Company> expResult = new ArrayList<>();
        List<Company> result = instance.getCompaniesByRadius(lat, lon, r);
        assertEquals(expResult.toString(), result.toString());
    }
    
}
