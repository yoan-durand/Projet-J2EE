/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.webservice;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
/**
 *
 * @author damiensoulard
 */

@javax.jws.WebService(
  endpointInterface = "com.mti.webshare.webservice.IWebService",
  serviceName = "WebService")
public class WebService implements IWebService{
    
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
}
