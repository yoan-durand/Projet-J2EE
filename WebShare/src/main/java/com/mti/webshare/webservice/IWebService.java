/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.webservice;

import com.mti.webshare.model.User;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author damiensoulard
 */

@WebService
public interface IWebService 
{   
    
    @WebMethod
    @POST
    @Path("/addUser")
    @Produces("text/plain")
    @Consumes("application/x-www-form-urlencoded")
    public String addUser(@WebParam(name="lastname") @FormParam("lastname")  String lastname, @WebParam(name="firstname") @FormParam("firstname") String firstname,
            @WebParam(name="email") @FormParam("email") String email,@WebParam(name="password") @FormParam("password") String password);

    @WebMethod
    @GET
    @Path("/getEvents/{email}")
    @Produces("text/plain")
    public String getEvents(@WebParam(name="email") @PathParam("email") String email);

    @WebMethod
    @GET
    @Path("/getUser/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public String getUser(@WebParam(name="id") @PathParam("id") int id);

    
    @WebMethod
    @GET
    @Path("/getFile/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public String getFile(@WebParam(name="id") @PathParam("id") int id);
    
    @WebMethod
    @GET
    @Path("/getUserList/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public String getUserList();

    @WebMethod
    @GET   
    @Path("/getFolderContent/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getFolderContent (@WebParam(name="id") @PathParam("id") int id);
}
