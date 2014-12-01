/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.dao;

import gr.myoffers.ws.wsoffer.model.Company;
import gr.myoffers.ws.wsoffer.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author fil
 */
public class CompanyDao {
    
       SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       
  // @Override
    public Company getCompanyById(int companyId) {
        Company company = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            company = (Company)session.createQuery("from  Company c where c.companyId=:id").setParameter("id",companyId).uniqueResult();
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
   // @Override
     public List<Company> getAllCompanies() {
        List<Company> companies = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            companies = session.createQuery("from Company c order by c.compName").list();
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
        return companies;
        
 
        
        

    }
     
   //select *  from company where (pow((`latitude`-38.7212),2) +  pow((`longitude`-51.8912),2))<(1/111)
         //returns all Companies
   // @Override
     public List<Company> getCompaniesByRadius( double lat,  double lon, double r) {
        List<Company> companies = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            String hgl="from Company c where (pow((c.latitude-:lat),2) +  pow((c.longitude-42.2225),2))<pow((1/111),2)";
            Query query = session.createQuery(hgl);
            query.setParameter("lat", lat);
        //   query.setParameter("lon", lon);
   //         query.setParameter("r", r);
            companies = query.list();
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
        return companies;
  
}
}