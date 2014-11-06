/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.se.ClosestOfferFinder.clientbackend;

/**
 *
 * @author user
 */
public class Starter {
    static Controller myController;
    public Starter() {

    }
    

    public static void main(String[] args) {
        myController= new Controller();
        myController.start();
        System.out.println("sdasfdasdfc");
    }
}
