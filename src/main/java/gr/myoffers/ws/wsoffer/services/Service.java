
package gr.myoffers.ws.wsoffer.services;

import gr.myoffers.ws.wsoffer.dao.CompanyDao;
import gr.myoffers.ws.wsoffer.dao.OfferDao;
import gr.myoffers.ws.wsoffer.dao.StoreDao;
import gr.myoffers.ws.wsoffer.model.Company;
import gr.myoffers.ws.wsoffer.model.Store;
import gr.myoffers.ws.wsoffer.model.Offer;
import gr.myoffers.ws.wsoffer.model.Response;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Iterator;
//import java.ua til.ArrayList;
//import java.util.HashMap;
import java.util.List;
import javax.persistence.Id;
//import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fil
 */

@Path("service")
public class Service {

    private OfferDao offerDao=new OfferDao();
    private StoreDao storeDao=new StoreDao();
    private CompanyDao companyDao=new CompanyDao();

    @GET
    @Path("/getOfferByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Offer getOfferByIdJSON(@PathParam("id") int offerId) {
             
        return offerDao.getOfferById(offerId);
    }

    @GET
    @Path("/getAllOffersJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Offer> getAllOffersJSON() {
        return offerDao.getAllOffers();
    }
      
    @GET
    @Path("/getOffersByDiscJSON/{disc}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Offer> getOffersByDiscJSON(@PathParam("disc") double disc){
        return offerDao.getOffersByDisc(disc);
    }
    
//    @GET
//    @Path("/getOffersByStoreJSON/{compId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Offer> getOffersByStoreJSON(@PathParam("compId") int compId){
//        return offerDao.getOffersByStore(compId);
//    }
//    
//    @GET
//    @Path("/getOffersByCategoryJSON/{catId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Offer> getOffersByCategoryJSON(@PathParam("catId") int catId){
//        return offerDao.getOffersByCategory(catId);
//    }
      
    @GET
    @Path("/getOffersByCityJSON/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Offer> getOffersByCityJSON(@PathParam("city") String city){
        return offerDao.getOffersByCity(city);
    }
    
    
        //This method return all offers in JSON format
    @GET
    @Path("/getMaxDisqOffersJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Offer> getMaxDisqOffersJSON() {
       // return new ArrayList<Offer>(offers.values());
        return offerDao.getMaxOffers();
    }
            //This method return all offers in JSON format
    @GET
    @Path("/getVersionWsJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public String getVersionWsJSON() {
        String ver_WS="ver 0.2";
        return "[{\"version\":{\"ver_ws\":\""+ver_WS+"\"}]";
    }
    
          //This method returns store by ID in JSON format
    @GET
    @Path("/getStoreByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Store getStoreByIdJSON(@PathParam("id") String sstoreId) throws Exception {
        Store store = null;
        try {
            int storeId = Integer.parseInt(sstoreId);
            store = storeDao.getStoreById(storeId);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("Wrong parameter or character in id");
        } catch (Exception ex) { }
        if (store == null) {
            throw new Exception("Store not exist");
        }
        return store;
        
    } 
      //This method returns all stores in JSON format
    @GET
    @Path("/getAllStoresJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Store> getAllStoresJSON() {
    return storeDao.getAllStores();
    }   
      //This method returns all stores closer to radius (r) in JSON format  
     //with parameter user latitude and longitude (GPS)
    @GET
    @Path("/getStoresByRadiusJSON/{lat},{lon},{r}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Store> getStoresByRadiusJSON(@PathParam("lat") double lat, @PathParam("lon") double lon, @PathParam("r") double r)
            throws Exception {
     //   List<Store> stores = new ArrayList<>();
        
        if (abs(lat) > 180 || abs(lon)>180) {
            throw new Exception("Incorrect coordinate pair");
        } else if (r <= 0) {
            throw new Exception("Incorrect radius");
        }
        //stores = stores;
        return storeDao.getStoresByRadius(lat, lon, r);
        
    }
//-------------------
          //This method returns all stores closer to radius (r) in JSON format  
     //with parameter user latitude and longitude (GPS)
    @GET
    @Path("/getOnlyStoresByRadiusJSON/{lat},{lon},{r}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Response> getOnlyStoresByRadiusJSON(@PathParam("lat") double lat, @PathParam("lon") double lon, @PathParam("r") double r)
            throws Exception {
        List<Response> responses = new ArrayList<>();
      
        if (abs(lat) > 180 || abs(lon)>180) {
            throw new Exception("Incorrect coordinate pair");
        } else if (r <= 0) {
            throw new Exception("Incorrect radius");
        }
        List<Store> stores = storeDao.getStoresByRadius(lat, lon, r);
                for (Iterator iter = stores.iterator();iter.hasNext();) {
                Store store = (Store) iter.next();
        Response response = new Response();//= (Response) iter1;
                response.setId(store.getStoreId());
                response.setStatus("Store");
                response.setMessage(store.getStoreName()+"-"+store.getAddress());
                responses.add(response);
                }  
        return responses;
        
    }
//------------------
      //This method returns company by ID in JSON format
    @GET
    @Path("/getOnlyCompanyByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOnlyCompanyByIdJSON(@PathParam("id") String sId) throws Exception
    { 
        Response response = new Response();
        Company company = null;
        try {
            int id = Integer.parseInt(sId);
            company = companyDao.getCompanyById(id);
            response.setStatus(String.valueOf(company.getId()));
            response.setMessage(company.getName());
        } catch (NumberFormatException nfe) {

            throw new NumberFormatException("Wrong parameter or character in id");
        } catch (Exception ex) {

        }
        if (company == null) {
            throw new Exception("Company not exist");
        }

        return response;
    //    return companyDao.getCompanyById(Id);
    }     
//-----
       //This method returns company by ID in JSON format
    @GET
    @Path("/getCompanyByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Company getCompanyByIdJSON(@PathParam("id") String sId) throws Exception
    { 
        Company company = null;
        try {
            int id = Integer.parseInt(sId);
            company=companyDao.getCompanyById(id);
        } catch (NumberFormatException nfe) {

            throw new NumberFormatException("Wrong parameter or character in id");
        } catch (Exception ex) {

        }
        if (company == null) {
            throw new Exception("Company not exist");
        }

        return company;
    }    
    
//------
    @GET
    @Path("/getAllCompaniesOnlyJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Response> getAllCompaniesOnlyJSON() {
        List<Response> responses;
        responses = new ArrayList<>();
        List<Company> companies = companyDao.getAllCompanies();
        for (Iterator iter = companies.iterator();iter.hasNext();) {
                Company company = (Company) iter.next();
              //  Iterator  iter1= responses.iterator();
        Response response = new Response();//= (Response) iter1;
                response.setId(company.getId());
                response.setStatus("Company");
                response.setMessage(company.getName());
                responses.add(response);
              
            }
        
    return responses;
//---------
}
    @GET
    @Path("/getAllCompaniesJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getAllCompaniesJSON() {
    return companyDao.getAllCompanies();
}
    @GET
    @Path("/getOffersByRadiusJSON/{lat},{lon},{r}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Offer> getOffersByRadiusJSON(@PathParam("lat") double lat, @PathParam("lon") double lon, @PathParam("r") double r)
            throws Exception {
        List<Store> stores = new ArrayList<>();
        List<Offer> offers = new ArrayList<>();

        if (abs(lat) > 180 || abs(lon)>180) {
            throw new Exception("Incorrect coordinate pair");
        } else if (r <= 0) {
            throw new Exception("Incorrect radius");
        }
        //stores = stores;
        stores=storeDao.getStoresByRadius(lat, lon, r);
        for (Iterator iter = stores.iterator();iter.hasNext();) {
                Store store = (Store) iter.next();
                offers.addAll(store.getOffers());
        }
        return offers;
        
    }    
    
}
