/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.se.ClosestOfferFinder.clientbackend.interfaces;

/**
 *
 * @author user
 */
public interface IRequest {
    double getLatitude();
    double getLongtitude();
    double getRadius();
    
}
