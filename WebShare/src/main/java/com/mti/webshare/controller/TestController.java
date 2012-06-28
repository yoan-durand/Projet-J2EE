/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.webshare.controller;

import com.mti.webshare.daoImpl.UserDAOImpl;
import com.mti.webshare.model.User;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@RequestMapping("/test")
public class TestController 
{

    protected final Log logger = LogFactory.getLog(getClass());

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

    @RequestMapping(value="/inscription.htm", method=RequestMethod.POST)
    public ModelAndView inscription (HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model = new ModelAndView();
        
        User user = new User();
        UserDAOImpl impl = new UserDAOImpl();
        
        user.setDeleted(Boolean.FALSE);
        user.setEmail(request.getParameter("email"));
        user.setFisrtName(request.getParameter("firstname"));
        user.setLastName(request.getParameter("lastname"));
        user.setPassword(request.getParameter("password"));
        
        if (impl.create(user)) 
            return new ModelAndView("index");
        else
            return new ModelAndView("addShop", "message", "Erreur lors de la creation du compte veuillez reessayer");
    }
}