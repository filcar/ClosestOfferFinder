/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fil
 */
@Entity
@Table(name="COMPANY")
@XmlRootElement(name = "company")
public class Company implements Serializable {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
@XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
@XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
//@OneToMany(fetch = FetchType.LAZY, mappedBy = "Company")
//    private List<Store> stores;  
//    public List<Store> getStores() {
//        return stores;
//    }
//
//    public void setStores(List<Store> stores) {
//        this.stores = stores;
//    }

    
}
