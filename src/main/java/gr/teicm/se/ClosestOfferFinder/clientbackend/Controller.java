/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gr.teicm.se.ClosestOfferFinder.clientbackend;
import gr.teicm.se.ClosestOfferFinder.clientbackend.interfaces.*;
/**
 *
 * @author user
 */
public class Controller  {
    IDao dao;
    public Controller() {
        System.out.println("Intializing Controller Constructor");
        dao = new StubDao(1, "1Shop", "", 41.0921009, 23.5472392, "Car", "", "", 0);
    }
    
    public void getOffer(int id, String storeName, double latitude, double longtitude, String ProductName) {
//        id = (int) (dao.getRequest()).get(0);
//        storeName = (String) (dao.getRequest()).get(1);
//        latitude = (double) (dao.getRequest()).get(2);
//        longtitude = (double) (dao.getRequest()).get(3);
//        ProductName = (String) (dao.getRequest()).get(4);
    }
    public void start() {
        int id=0;
        String storeName="",  ProductName="";
        double latitude=0, longtitude=0;
        this.getOffer(id, storeName, latitude, longtitude, ProductName);
        System.out.println("id = "+ id);
        System.out.println("storeName = "+storeName);
        System.out.println("latitude = "+ latitude);
        System.out.println("longtitude = "+ longtitude);
        System.out.println("ProductName" + ProductName);
    }
//    public static void main(String[] args) {
//       
//        
//    }

}
