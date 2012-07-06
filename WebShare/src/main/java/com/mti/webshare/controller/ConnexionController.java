/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mti.webshare.controller;

import com.mti.webshare.dao.UserDAO;
import com.mti.webshare.model.User;
import com.mti.webshare.utilitaire.Encryptor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author yoan
 * EPITA MTI 2013
 *
 */

@Controller
@RequestMapping("/index")
public class ConnexionController 
{
    @Autowired
    private UserDAO userDao;
    
    @RequestMapping(value="/connexion.htm", method= RequestMethod.GET)
    public ModelAndView log_get ()
    {
            return new ModelAndView("Connexion");
    }
    
    @RequestMapping(value="/connexion.htm", method= RequestMethod.POST)
    public ModelAndView log_post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        User user = userDao.get(login);
        
        if (user != null)
        {
            if (user.getPassword().equals(Encryptor.getEncodedPassword(password)))
            {
                request.getSession().setAttribute("user", user.getEmail());
                request.getRequestDispatcher("/File/navigator.htm").forward(request, response);
            }
            else
            {
                return new ModelAndView("addShop", "message", "Fail");
            }
        }
        return new ModelAndView("Connexion");
    }

    
}
