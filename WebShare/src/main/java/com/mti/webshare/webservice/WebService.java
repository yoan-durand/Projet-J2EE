/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.webservice;

import com.mti.webshare.dao.UserDAO;
import com.mti.webshare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author damiensoulard
 */

@javax.jws.WebService(
  endpointInterface = "com.mti.webshare.webservice.IWebService",
  serviceName = "WebService")
public class WebService implements IWebService{
    
    @Autowired
    private UserDAO userDAO;

    public WebService()
    {
    }
    
    @Override
    public String addUser(String lastName, String firstName, String email, String password)
    {
        String str = " ";

       if(userDAO.create(lastName, firstName, password, email))
            str = lastName +" "+firstName+" "+email+" "+password;  
        
       return (str);   
    }

    @Override
    public String getEvents(String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String getUser(int id){
        User u = userDAO.get(id);
        return userDAO.toJson(u);
    }
}
