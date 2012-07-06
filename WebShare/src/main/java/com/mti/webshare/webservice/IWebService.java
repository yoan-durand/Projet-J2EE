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
<<<<<<< HEAD
    @Consumes("application/x-www-form-urlencoded")
    public String addUser(@WebParam(name="lastname") @FormParam("lastname")  String lastname, @WebParam(name="firstname") @FormParam("firstname") String firstname,
            @WebParam(name="email") @FormParam("email") String email,@WebParam(name="password") @FormParam("password") String password);

=======
    public String addUser(@WebParam(name="lastname") @PathParam("lastname")  String lastName, @WebParam(name="firstname") @PathParam("firstname") String firstName,
            @WebParam(name="email") @PathParam("email") String email,@WebParam(name="password") @PathParam("password") String password);
    
>>>>>>> 88481cf14db0241ad8328116c07d0332cf8957f6
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
<<<<<<< HEAD
  
    /*
    @WebMethod
    @GET
    @Path("/addFile/{name}/{public}/{path}/{isdir}/{isdeleted}/{parent}")
    @Produces("text/plain");
    public String addFile (@WebParam(name="name") @PathParam("name") String filename, @WebParam(name="public") @PathParam("public") boolean isPublic,
           @WebParam(name="path") @PathParam("path") String path, @WebParam(name="isdir") @PathParam("isdir") boolean isDir,
           @WebParam(name="isdeleted") @PathParam("isdeleted") boolean isdeleted,@WebParam(name="parent") @PathParam("parent") String parent );
*/
=======
    
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
>>>>>>> 88481cf14db0241ad8328116c07d0332cf8957f6
}
