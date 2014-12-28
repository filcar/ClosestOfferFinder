/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.services;

import gr.myoffers.ws.wsoffer.dao.CompanyDao;
import gr.myoffers.ws.wsoffer.model.Category;
import gr.myoffers.ws.wsoffer.model.Company;
import gr.myoffers.ws.wsoffer.model.Offer;
import gr.myoffers.ws.wsoffer.model.Response;
import gr.myoffers.ws.wsoffer.model.Store;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    
private static CompanyDao mockedCompanyDao;
private static Service mockedService;
private static Response mockResponse;
private static List<Response> mockResponses;
private static Company company1;
private static Company company2;
private static Category category1;
private static Offer offer1;
private static Store store1;
@BeforeClass
public static void setup() {
 //  mockedCompanyDao = mock(CompanyDao.class);
   mockedService = mock(Service.class);
   // CompanyDao companyDao = new CompanyDao();
//    category1.setCategoryId(1);
//    category1.setCatName("Τρόφιμα Φαγητά");
//    offer1.setOfferId(1);
//    offer1.setDescr("a");
//    offer1.setOfferName("a");
//    offer1.setPrice(0);
//    offer1.setDisc(0);
//    offer1.setStartdate(Date.valueOf(LocalDate.of(2014, Month.DECEMBER, 28)));
//    offer1.setEnddate(Date.valueOf(LocalDate.of(2014, Month.DECEMBER, 28)));
//    offer1.setCategory(category1);
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
      Response mockResponse = new Response();//= (Response) iter1;
                mockResponse.setId(999);
                mockResponse.setStatus("Company");
                mockResponse.setMessage("testcompname");
                mockResponses.add(mockResponse);
    when(mockedService.getAllCompaniesOnlyJSON()).thenReturn(mockResponses);
            }

    /**
     * Test of getAllCompaniesOnlyJSON method, of class Service.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllCompaniesOnlyJSON()  throws Exception {
    Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
    POJOResourceFactory noDefaults = new POJOResourceFactory(Service.class);
    //dispatcher.getRegistry().addResourceFactory(noDefaults);
    dispatcher.getRegistry().addSingletonResource(mockedService);

    {
        MockHttpRequest request = MockHttpRequest.get("/service/getAllCompaniesOnlyJSON");
        MockHttpResponse response = new MockHttpResponse();

        dispatcher.invoke(request, response);
        assertEquals(HttpServletResponse.SC_OK, response.getStatus());
        Assert.assertEquals("[{\"response\":{\"id\":999,\"status\":\"Company\",\"message\":\"testcompname\"}}]", response.getContentAsString());
    }
    }
    
}
