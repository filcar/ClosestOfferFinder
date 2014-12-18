/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.dao;

import gr.myoffers.ws.wsoffer.model.Store;
import gr.myoffers.ws.wsoffer.util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author fil
 */
public class StoreDao implements IStoreDao{
    
       SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       
   @Override
    public Store getStoreById(int storeId) {
        Store store = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            store = (Store)session.createQuery("from  Store s where s.storeId=:id").setParameter("id",storeId).uniqueResult();
//            Hibernate.initialize(store.getOffers());
            session.getTransaction().commit();

        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return store;

    }
    
    //returns all Companies
    @Override
     public List<Store> getAllStores() {
        List<Store> stores = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            stores = session.createQuery("from Store c order by c.storeName").list();
//            for (Iterator iter = stores.iterator();iter.hasNext();) {
//                Store store = (Store)iter.next();
//             //   log.debug(store);
//                Hibernate.initialize(store.getOffers());
//            }
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return stores;

    }
     

    @Override
     public List<Store> getStoresByRadius( double lat,  double lon, double r) {
        List<Store> stores = null;
        Session session = null;
        try {
           // double dist =r/111; 
            session = sessionFactory.openSession();
            session.beginTransaction();
            String hgl="from Store c where (pow((c.latitude-:lat),2) +  pow((c.longitude-:lon),2))<pow((:r),2)";
            stores= session.createQuery(hgl)
                    .setParameter("lon", lon)
                    .setParameter("lat", lat)
                    .setParameter("r", r/111)
                    .list();
            //         
//            for (Iterator iter = stores.iterator();iter.hasNext();) {
//                Store store = (Store)iter.next();
//             //   log.debug(store);
//                Hibernate.initialize(store.getOffers());}            
                session.getTransaction().commit(); 
        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return stores;
  
}
}