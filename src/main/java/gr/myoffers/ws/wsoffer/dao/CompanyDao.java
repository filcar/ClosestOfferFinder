/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.dao;

import gr.myoffers.ws.wsoffer.model.Company;
import gr.myoffers.ws.wsoffer.util.HibernateUtil;
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
    
    
}
