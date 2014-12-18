/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.dao;

import gr.myoffers.ws.wsoffer.model.Company;
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
public class CompanyDao implements ICompanyDao {
           SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       
   @Override
    public Company getCompanyById(int id) {
        Company company = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            company = (Company)session.createQuery("from  Company c where c.id=:id").setParameter("id",id).uniqueResult();
            Hibernate.initialize(company.getStores());
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
    
  //  returns all Companies
    @Override
     public List<Company> getAllCompanies() {
        List<Company> companies = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            companies = session.createQuery("select c from Company as c").list();
            for (Iterator iter = companies.iterator();iter.hasNext();) {
                Company company = (Company) iter.next();
             //   log.debug(company);
                
                Hibernate.initialize(company.getStores());
            }
 
             session.getTransaction().commit();
         //   Hibernate.initialize();
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
