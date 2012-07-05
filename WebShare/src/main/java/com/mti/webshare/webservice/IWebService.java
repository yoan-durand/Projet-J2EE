/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author damiensoulard
 */

@WebService
public interface IWebService 
{
    @WebMethod
    public int add(@WebParam(name="a") int a, @WebParam(name="b") int b);
    
    @WebMethod
    public String addUser(@WebParam(name="lastname") String lastName, @WebParam(name="firstname") String firstName, @WebParam(name="email") String email,
    @WebParam(name="password")String password);
}
