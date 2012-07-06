/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author damiensoulard
 */

@WebService
public interface IWebService 
{   
    
    @WebMethod
    @GET
    @Path("/adduser/{lastname}/{firstname}/{email}/{password}")
    @Produces("text/plain")
    public String addUser(@WebParam(name="lastname") @PathParam("lastname")  String lastName, @WebParam(name="firstname") @PathParam("firstname") String firstName,
            @WebParam(name="email") @PathParam("email") String email,@WebParam(name="password") @PathParam("password") String password);
    
    @WebMethod
    @GET
    @Path("/getEvents/{email}")
    @Produces("application/json")
    public String getEvents(@WebParam(name="email") @PathParam("email") String email);

    @WebMethod
    @GET
    @Path("/getUser/{id}")
    @Produces("text/plain")
    public String getUser(@WebParam(name="id") @PathParam("id") int id);
    
    @WebMethod
    @GET
    @Path("/getFile/{id}")
    @Produces("text/plain")
    public String getFile(@WebParam(name="id") @PathParam("id") int id);
    
    
}
