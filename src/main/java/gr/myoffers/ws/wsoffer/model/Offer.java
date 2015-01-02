/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *1
 * @author fil
 */
@Entity
@Table(name="OFFER")
@XmlRootElement(name = "offer")
@XmlType(propOrder={"offerId","offerName","descr","disc","price","startdate","enddate","category"})

public class Offer implements Serializable {

//    public Offer(int offerId, String offerName, String descr, double disc, double price, Date enddate, Date startdate, Category category) {
//        this.offerId = offerId;
//        this.offerName = offerName;
//        this.descr = descr;
//        this.disc = disc;
//        this.price = price;
//        this.enddate = enddate;
//        this.startdate = startdate;
//        this.category = category;
//    }
//    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int offerId;
    @Column(name="offer_name")
    private String offerName;
    @Column(name="offer_descr")
    private String descr;
    @Column(name="discount")
    private double disc;
    @Column(name="price")
    private double price;
    @Temporal(TemporalType.DATE)
    @Column (name="end_date")
    private Date enddate;
    @Temporal(TemporalType.DATE)
    @Column (name="start_date")
    private Date startdate;
    
  @XmlElement
    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }
    
    @XmlElement    
    public String getOfferName(){
        return offerName;
    }

    public void setOfferName(String offerName){
        this.offerName = offerName;
    }
    
    
    @XmlElement
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @XmlElement
    public double getDisc(){
        return disc;
    }
    
    public void setDisc(double disc){
        this.disc = disc;
    }

    @XmlElement
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @XmlElement
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
    @XmlElement
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }
   
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="cat_id", referencedColumnName="id", nullable=true)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
    
    @Override
    public String toString(){
        return offerName;
    }
    
}
