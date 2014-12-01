/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.services;

import gr.myoffers.ws.wsoffer.dao.CompanyDao;
import gr.myoffers.ws.wsoffer.dao.OfferDao;
import gr.myoffers.ws.wsoffer.model.Company;
//import gr.myoffers.ws.wsoffer.dao.IOfferDao;
import gr.myoffers.ws.wsoffer.model.Offer;
//import java.ua til.ArrayList;
//import java.util.HashMap;
import java.util.List;
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

    private OfferDao offerDao= new OfferDao();
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
    
    @GET
    @Path("/getOffersByStoreJSON/{compId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Offer> getOffersByStoreJSON(@PathParam("compId") int compId){
        return offerDao.getOffersByStore(compId);
    }
    
    @GET
    @Path("/getOffersByCategoryJSON/{catId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Offer> getOffersByCategoryJSON(@PathParam("catId") int catId){
        return offerDao.getOffersByCategory(catId);
    }
      
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
        return ver_WS;
    }
    
               //This method company by ID in JSON format
    @GET
    @Path("/getCompanyByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Company getCompanyByIdJSON(@PathParam("id") int companyId) {
        return companyDao.getCompanyById(companyId);
    } 
 @GET
    @Path("/getAllCompaniesJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getAllCompaniesJSON() {
       // return new ArrayList<Offer>(offers.values());
        return companyDao.getAllCompanies();
    }   
    
     @GET
    @Path("/getCompaniesByRadiusJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getCompaniesByRadiusJSON() {
       // return new ArrayList<Offer>(offers.values());
        return companyDao.getCompaniesByRadius(40.4145, 42.2323, 1);
    }   
    
}
