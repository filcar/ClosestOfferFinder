/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offerfinderalpha;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alext_000
 */
public class Helper {
    
    Session session = null;

    public Helper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public Stores getStoreByID(int id){

        Stores store = new Stores();

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Stores as stores where stores.id=" + id);
            store = (Stores) q.uniqueResult();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return store;
    }
    
}
