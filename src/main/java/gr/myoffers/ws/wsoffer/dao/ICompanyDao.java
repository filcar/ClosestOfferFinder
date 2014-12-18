/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.dao;

import gr.myoffers.ws.wsoffer.model.Company;
import java.util.List;

/**
 *
 * @author fil
 */
public interface ICompanyDao {
    public Company getCompanyById(int id);
    public List<Company> getAllCompanies();
    
}
