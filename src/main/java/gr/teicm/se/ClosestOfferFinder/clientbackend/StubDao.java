/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.se.ClosestOfferFinder.clientbackend;

import gr.teicm.se.ClosestOfferFinder.clientbackend.interfaces.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giannis
 */
public class StubDao implements IDao {
    
    private List<IRequest> feed = new ArrayList<>();
    private int id;
    private String storeName, address, prodName, category, disc;
    private double latitude, longitude, discPrice;
    
    public StubDao (int id, String storeName, String address, double latitude,
            double longitude, String prodName, String category, String disc,
            double discPrice){
        this.feed.add(id);
        this.feed.add(storeName);
     //   this.feed.add(address);
        this.feed.add(latitude);
        this.feed.add(longitude);
        this.feed.add(prodName);
    //    this.feed.add(category);
    //    this.feed.add(disc);
    //    this.feed.add(discPrice);
    }
    
    @Override
    public String toString(){
        return "/n" + id + ", " + storeName + ", " + address + ", " + latitude + ", " +
                longitude + ", " + prodName + ", " + category + ", " + disc + ", " 
                + discPrice ;
    }
    
    @Override
    public IRequest getClientData(){
        return feed;
    }

    
}


