package gr.myoffers.ws.wsoffer.dao;

import gr.myoffers.ws.wsoffer.model.Offer;
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

    public Offer getOfferById(int id) {
        Offer offer = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            String hql = "from  Offer p where p.id=:ID";
            offer = (Offer) session.createQuery(hql).setParameter("ID", id).uniqueResult();
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

        return offer;

    }

    public List<Offer> getAllOffers() {
        List<Offer> offers = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            offers = session.createQuery("from Offer p").list();
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
        return offers;

    }

    public List<Offer> getMaxOffers() {
        List<Offer> offers = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            String hql2 = "FROM Offer p WHERE p.discount = (SELECT max(a.discount) FROM Offer a)";
            offers = session.createQuery(hql2).list();
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
        return offers;
    }
  
      
}
