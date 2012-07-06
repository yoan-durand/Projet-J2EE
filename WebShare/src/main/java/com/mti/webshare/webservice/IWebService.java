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
import org.codehaus.jettison.json.JSONObject;

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
    @Path("/add/{a}/{b}")
    @Produces("text/plain")
    public int add(@WebParam(name="a") @PathParam("a") int a, @WebParam(name="b") @PathParam("b") int b);
    
    @WebMethod
    @GET
    @Path("/getUser/{id}")
    @Produces("text/plain")
    public String getUser(@WebParam(name="id") @PathParam("id") int id);
  
    /*
    @WebMethod
    @GET
    @Path("/addFile/{name}/{public}/{path}/{isdir}/{isdeleted}/{parent}")
    @Produces("text/plain");
    public String addFile (@WebParam(name="name") @PathParam("name") String filename, @WebParam(name="public") @PathParam("public") boolean isPublic,
           @WebParam(name="path") @PathParam("path") String path, @WebParam(name="isdir") @PathParam("isdir") boolean isDir,
           @WebParam(name="isdeleted") @PathParam("isdeleted") boolean isdeleted,@WebParam(name="parent") @PathParam("parent") String parent );
*/
}
