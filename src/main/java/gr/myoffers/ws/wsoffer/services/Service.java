/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.services;

import gr.myoffers.ws.wsoffer.dao.OfferDao;
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
/*
    //inserting stubvalue instited to database
    private static Map<Integer, Offer> offers = new HashMap<Integer, Offer>();

    static {
        for (int i = 0; i < 10; i++) {
            Offer offer = new Offer();
            int id = 1 + i;
            offer.setId(id);
            offer.setDescr("Κατάστημα Α -product No " + id);
            offer.setAxia(100 + 4 * i);

            offers.put(id, offer);
        }
    }
    */
    

    private OfferDao offerDao= new OfferDao();
//This method return a single offer in XML format with the id

    @GET
    @Path("/getOfferByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Offer getOfferByIdXML(@PathParam("id") int offerId) {
     //   return offers.get(id);
        return offerDao.getOfferById(offerId);
    }
//This method return a single offer in json format with the id

    @GET
    @Path("/getOfferByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Offer getOfferByIdJSON(@PathParam("id") int offerId) {
     //   return offers.get(id);
        return offerDao.getOfferById(offerId);
    }
//This method return all offers in XML format

    @GET
    @Path("/getAllOffersXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Offer> getAllOffersXML() {
      //  return new ArrayList<Offer>(offers.values());
        return offerDao.getAllOffers();
    }

    //This method return all offers in JSON format
    @GET
    @Path("/getAllOffersJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Offer> getAllOffersJSON() {
       // return new ArrayList<Offer>(offers.values());
        return offerDao.getAllOffers();
    }
    
    @GET
    @Path("/getOffersWithCertainDiscXML/{disc}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Offer> getOffersWithCertainDiscXML(@PathParam("disc") double disc){
        return offerDao.getOffersWithCertainDisc(disc);
    }
    
    @GET
    @Path("/getOffersWithCertainDiscJSON/{disc}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Offer> getOffersWithCertainDiscJSON(@PathParam("disc") double disc){
        return offerDao.getOffersWithCertainDisc(disc);
    }
    
    @GET
    @Path("/getOffersByStoreXML/{compId}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Offer> getOffersByStoreXML(@PathParam("compId") int compId){
        return offerDao.getOffersByStore(compId);
    }
    
    @GET
    @Path("/getOffersByStoreJSON/{compId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Offer> getOffersByStoreJSON(@PathParam("compId") int compId){
        return offerDao.getOffersByStore(compId);
    }
    
    /*
    @GET
    @Path("/getOffersByStoreXML/{displayName}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Offer> getOffersByStoreXML(@PathParam("displayName") String displayName){
        return offerDao.getOffersByStore(displayName);
    }*/
    
    @GET
    @Path("/getOffersByCategoryXML/{catId}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Offer> getOffersByCategoryXML(@PathParam("catId") int catId){
        return offerDao.getOffersByCategory(catId);
    }
    
    @GET
    @Path("/getOffersByCategoryJSON/{catId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Offer> getOffersByCategoryJSON(@PathParam("catId") int catId){
        return offerDao.getOffersByCategory(catId);
    }
    
    @GET
    @Path("/getOffersByCityXML/{city}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Offer> getOffersByCityXML(@PathParam("city") String city){
        return offerDao.getOffersByCity(city);
    }
    
    @GET
    @Path("/getOffersByCityJSON/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Offer> getOffersByCityJSON(@PathParam("city") String city){
        return offerDao.getOffersByCity(city);
    }
    

}
