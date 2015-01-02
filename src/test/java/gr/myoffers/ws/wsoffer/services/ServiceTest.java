/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.services;

//import com.google.gson.Gson;
import gr.myoffers.ws.wsoffer.model.Category;
import gr.myoffers.ws.wsoffer.model.Offer;
import gr.myoffers.ws.wsoffer.model.Response;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 *
 * @author fil
 */
public class ServiceTest {
    
    public ServiceTest() {
    }
    
//private static CompanyDao mockedCompanyDao;
private static Service mockedService;
//private static Response mockResponse1;
//private static List<Response> mockResponses;
//private static Company company1;
//private static Company company2;
//private static Category category1;
//private static Offer offer1;
//private static Store store1;
//private static String json;
@BeforeClass
public static void setup() {
    try {
            //  mockedCompanyDao = mock(CompanyDao.class);
            mockedService = mock(Service.class);
            // CompanyDao companyDao = new CompanyDao();
      Category category1 = new Category();
      Offer offer1=new Offer();
 //     Gson gson = new Gson();
    category1.setCategoryId(1);
    category1.setCatName("testCateName");
    offer1.setOfferId(1);
    offer1.setDescr("a");
    offer1.setOfferName("a");
    offer1.setPrice(0.0);
    offer1.setDisc(0.0);
    offer1.setStartdate(Date.valueOf(LocalDate.of(2014, Month.DECEMBER, 28)));
    offer1.setEnddate(Date.valueOf(LocalDate.of(2014, Month.DECEMBER, 28)));
    offer1.setCategory(category1);
 //   json = gson.toJson(offer1);
//    List<Offer> offers = new ArrayList<>();
//    offers.add(offer1);
//    store1.setStoreId(1);
//    store1.setAddress("a");
//    store1.setCity("a");
//    store1.setDirector("a");
//    store1.setLatitude(0.0);
//    store1.setLongitude(0.0);
//    store1.setStoreName("store1");
//    store1.setOffers(offers);
//    List<Store> stores = new ArrayList<>();
//    stores.add(store1);
            //  company1 = new Company();
            //  company1.setId(1);
            //  company1.setName("comp1");
//    company1.setStores(Collections.EMPTY_LIST);
            //  company2=new Company(222,"test2",stores);
            //   List<Company> companies = new ArrayList<>();
            //   companies.add(company1);
            //   when(mockedCompanyDao.getAllCompanies()).thenReturn(companies);
            List<Response> mockResponses;
            mockResponses = new ArrayList<>();
            Response mockResponse1= new Response();
            mockResponse1.setId(111);
            mockResponse1.setStatus("Company1");
            mockResponse1.setMessage("testcompname1");
            mockResponses.add(mockResponse1);
            Response mockResponse2= new Response();
            mockResponse2.setId(222);
            mockResponse2.setStatus("Company2");
            mockResponse2.setMessage("testcompname2");
            mockResponses.add(mockResponse2);
            
            when(mockedService.getAllCompaniesOnlyJSON()).thenReturn(mockResponses);
            when(mockedService.getOnlyCompanyByIdJSON("111")).thenReturn(mockResponse1);
            when(mockedService.getOfferByIdJSON(1)).thenReturn(offer1);
    } catch (Exception ex) {
            Logger.getLogger(ServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            }

    /**
     * Test of getAllCompaniesOnlyJSON method, of class Service.
     * @throws java.lang.Exception
     */
@Test
    public void testGetAllCompaniesOnlyJSON()  throws Exception {
    Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
  //  POJOResourceFactory noDefaults = new POJOResourceFactory(Service.class);
    //dispatcher.getRegistry().addResourceFactory(noDefaults);
    dispatcher.getRegistry().addSingletonResource(mockedService);

    {
        MockHttpRequest request = MockHttpRequest.get("/service/getAllCompaniesOnlyJSON");
        MockHttpResponse response = new MockHttpResponse();

        dispatcher.invoke(request, response);
        Assert.assertEquals("[{\"response\":{\"id\":111,\"status\":\"Company1\",\"message\":\"testcompname1\"}},"
                          + "{\"response\":{\"id\":222,\"status\":\"Company2\",\"message\":\"testcompname2\"}}]",response.getContentAsString());
    }
    }
    
        /**
     * Test of getOnlyCompanyByIdJSON method, of class Service.
     * @throws java.lang.Exception
     */
@Test
    public void testgetOnlyCompanyByIdJSON()  throws Exception {
    Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
    dispatcher.getRegistry().addSingletonResource(mockedService);
      {
        MockHttpRequest request = MockHttpRequest.get("/service/getOnlyCompanyByIdJSON/111");
        MockHttpResponse response = new MockHttpResponse();
        dispatcher.invoke(request, response);
        Assert.assertEquals("{\"response\":{\"id\":111,\"status\":\"Company1\",\"message\":\"testcompname1\"}}",response.getContentAsString());
      }
    }
    
    /**
     * Test of getOnlyCompanyByIdJSON method, of class Service.
     * @throws java.lang.Exception
     */
@Test
    public void testgetOnlyCompanyByZeroIdJSON()  throws Exception {
    Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
    dispatcher.getRegistry().addSingletonResource(mockedService);
      {
        MockHttpRequest request = MockHttpRequest.get("/service/getOnlyCompanyByIdJSON/0");
        MockHttpResponse response = new MockHttpResponse();
        dispatcher.invoke(request, response);
        Assert.assertEquals("",response.getContentAsString());
      }
    }
     /**
     * Test of not found ., of class Service.
     * @throws java.lang.Exception
     */
@Test
    public void testNotFoundCompanies()  throws Exception {
    Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
    POJOResourceFactory noDefaults = new POJOResourceFactory(Service.class);
    dispatcher.getRegistry().addResourceFactory(noDefaults);
   // dispatcher.getRegistry().addSingletonResource(mockedService);
    {
        MockHttpRequest request = MockHttpRequest.get("/service/testNotFoundCompanies");
        MockHttpResponse response = new MockHttpResponse();
        dispatcher.invoke(request, response);
         assertEquals(HttpServletResponse.SC_NOT_FOUND,response.getStatus());
     }
    }
  
    /**
     * Test of getOfferByIdJSON method, of class Service.
     */
    @Test
    public void testGetOfferByIdJSON() throws Exception{
    System.out.println("getOfferByIdJSON");
    Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
    dispatcher.getRegistry().addSingletonResource(mockedService);
      {
        MockHttpRequest request = MockHttpRequest.get("/service/getOfferByIdJSON/1");
        MockHttpResponse response = new MockHttpResponse();
        dispatcher.invoke(request, response);
     // Assert.assertEquals(json,response.getContentAsString());
        Assert.assertEquals("{\"offer\":{\"offerId\":1,\"offerName\":\"a\",\"descr\":\"a\",\"disc\":0,\"price\":0,\"startdate\":\"2014-12-28T00:00:00+02:00\",\"enddate\":\"2014-12-28T00:00:00+02:00\",\"category\":{\"categoryId\":1,\"catName\":\"testCateName\"}}}",response.getContentAsString());
      }

      }

}