/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Giannis
 */

@Entity
@Table(name="STORE")
@XmlRootElement(name = "STORE")
@XmlType(propOrder={"storeId","storeName","director","address","city","latitude","longitude","offers"})

public class Store implements Serializable {

//    public Store(int storeId, String storeName, String director, String address, String city, Double latitude, Double longitude, List<Offer> offers) {
//        this.storeId = storeId;
//        this.storeName = storeName;
//        this.director = director;
//        this.address = address;
//        this.city = city;
//        this.latitude = latitude;
//        this.longitude = longitude;
//        this.offers = offers;
//    }
//    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int storeId;
    @Column(name="store_name")
    private String storeName;
    @Column(name="director")
    private String director;
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;
    @Column (name="latitude")
    private Double latitude;
    @Column (name="longitude")
    private Double longitude;    


    @XmlElement
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    
    @XmlElement
    public String getStoreName(){
        return storeName;
    }
    
    public void setStoreName(String storeName){
        this.storeName = storeName;
    }
    
    @XmlElement
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    @XmlElement
    public String getAddress(){
        return address;
    }

    
    public void setAddress(String address){
        this.address = address;
    }
    
    @XmlElement
    public String getCity(){
        return city;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    @XmlElement
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    @XmlElement
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="store_id", nullable=true)
    private List<Offer> offers;
    
    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
 //   @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "comp_id",referencedColumnName="id",nullable=false,unique=true)
//    private Company company;
//    
//    public Company getCompany() {
//        return company;
//    }
//
//    public void setCompany(Company company) {
//        this.company = company;
//    }

   
    
    @Override
    public String toString(){
        return storeName;
    }
    
}


