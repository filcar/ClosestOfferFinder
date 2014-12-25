/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.model;
import java.nio.charset.Charset;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author fil
 */
  
   @XmlRootElement
   @XmlType(propOrder={"id","status","message"})
public class Response {
    private int id;
    private String status;
    private String message;

    //@XmlAttribute
    @XmlElement
    public int getId() {
      //  return (new Date()).getTime();
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getStatus() {
        
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement
    public String getMessage() {
       
        return message;
    }



    public void setMessage(String message) {
        this.message = message;
    }
}
    

