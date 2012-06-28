/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@RequestMapping("/test")
public class TestController 
{

    @RequestMapping("/index.htm")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {

        String now = (new Date()).toString();

        return new ModelAndView("Inscription", "now", now);
    }
    
    @RequestMapping("/other.htm")
    public ModelAndView other() 
    {
        return new ModelAndView("addShop", "message", "Remove method called");
    }

}