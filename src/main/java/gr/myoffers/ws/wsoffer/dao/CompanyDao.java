/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.dao;

import gr.myoffers.ws.wsoffer.model.Company;
import gr.myoffers.ws.wsoffer.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author fil
 */
public class CompanyDao {
           SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       
  // @Override
    public Company getCompanyById(int id) {
        Company company = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            company = (Company)session.createQuery("from  Company c where c.id=:id").setParameter("id",id).uniqueResult();
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

        return company;

    }
    
    //returns all Companies
 //   @Override
//     public List<Store> getAllStores() {
//        List<Store> stores = null;
//        Session session = null;
//
//        try {
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            stores = session.createQuery("from Store c order by c.storeName").list();
//            session.getTransaction().commit();
//
//        } catch (Exception ex) {
//            if (session != null) {
//                session.getTransaction().rollback();
//            }
//
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return stores;
//        
// 
//        
//        
//
//    }
    
}
