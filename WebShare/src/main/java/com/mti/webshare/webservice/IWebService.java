/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.webservice;

import com.mti.webshare.model.User;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author damiensoulard
 */

@WebService
public interface IWebService {
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
}
