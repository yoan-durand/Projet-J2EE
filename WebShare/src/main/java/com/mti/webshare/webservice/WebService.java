/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.webservice;



import com.mti.webshare.dao.UserDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    
    @GET
    @Path("/add/{a}/{b}")
    @Produces("text/plain")
    @Override
    public int add(@PathParam("a")int a, @PathParam("b")int b) {
        return a+b;
    }

    @GET
    @Path("/adduser/{lastname}/{firstname}/{email}/{password}")
    @Produces("text/plain")
    @Override
    public String addUser(@PathParam("lastname") String lastName, @PathParam("firstname") String firstName, @PathParam("email") String email,
    @PathParam("password") String password)
    {
        String str = " ";

       if(userDAO.create(lastName, firstName, password, email))
        str = lastName +" "+firstName+" "+email+" "+password;  
        return (str);   
    }

    
}
