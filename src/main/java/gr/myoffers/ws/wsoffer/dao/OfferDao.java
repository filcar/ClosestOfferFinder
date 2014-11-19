package gr.myoffers.ws.wsoffer.dao;

import gr.myoffers.ws.wsoffer.model.*;
import gr.myoffers.ws.wsoffer.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 *
 * @author fil
 */
public class OfferDao {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    //returns the offer with the given Id
    public Offer getOfferById(int offerId) {
        Offer offer = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            offer = (Offer)session.createQuery("from  Offer offer where offer.offerId=:id").setParameter("id",offerId).uniqueResult();
            session.getTransaction().commit();

        } 
        catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }

        } 
        finally {
            if (session != null) {
                session.close();
            }
        }

        return offer;

    }
    
    //returns all the offers
     public List<Offer> getAllOffers() {
        List<Offer> offers = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            offers = session.createQuery("from Offer").list();
            session.getTransaction().commit();

        } 
        catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }

        } 
        finally {
            if (session != null) {
                session.close();
            }
        }

        return offers;

    }
     //Returns all the offers that have a discount equal or bigger with the one given
    public List<Offer> getOffersWithCertainDisc(double disc){
        List<Offer> offers = null;
        Session session = null;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            offers = session.createQuery("from Offer offer where offer.disc >= :discount").setParameter("discount", disc).list();
            session.getTransaction().commit();
        }
        catch (Exception ex) {
            if (session !=null){
                session.getTransaction().rollback();
            }            
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        
        return offers;
    }
    
    //Returns all the offers of a given store
    public List<Offer> getOffersByStore(int compId){
        List<Offer> offers = null;
        Session session = null;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            offers = session.createQuery("from Offer offer where offer.compId = :comp_id").setParameter("comp_id", compId).list();
            session.getTransaction().commit();
        }
        catch (Exception ex) {
            if (session !=null){
                session.getTransaction().rollback();
            }            
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        
        return offers;
    }
    
    /*
    public List<Offer> getOffersByStore(String displayName){
        List<Offer> offers = null;
        Session session = null;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            offers = session.createQuery("from Offer offer where offer.compId = (select company.companyId from Company company where company.displayName = :display_name)").setParameter("display_name", displayName).list();
            session.getTransaction().commit();
        }
        catch (Exception ex) {
            if (session !=null){
                session.getTransaction().rollback();
            }            
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        
        return offers;
    }*/
    
    //Returns all the offers of a given category
    public List<Offer> getOffersByCategory(int catId){
        List<Offer> offers = null;
        Session session = null;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            offers = session.createQuery("from Offer offer where offer.catId = :cat_id").setParameter("cat_id", catId).list();
            session.getTransaction().commit();
        }
        catch (Exception ex) {
            if (session !=null){
                session.getTransaction().rollback();
            }            
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        
        return offers;
    }
    
    //Returns all the offers that exist in a given city
    public List<Offer> getOffersByCity(String city){
        List<Offer> offers = null;
        Session session = null;
        
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            offers = session.createQuery("from Offer offer where offer.compId in  (select company.companyId from Company company where company.city = :city)").setParameter("city", city).list();
            session.getTransaction().commit();
        }
        catch (Exception ex) {
            if (session !=null){
                session.getTransaction().rollback();
            }            
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        
        return offers;
    }
    
}


