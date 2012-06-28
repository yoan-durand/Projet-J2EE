package com.mti.webshare.controller;

import com.mti.webshare.dao.UserDAO;
import com.mti.webshare.model.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController
{
        @Autowired
        private UserDAO userDAO;
        
        @RequestMapping(value="/Utilisateurs.htm", method = RequestMethod.GET)
	public ModelAndView utilisateurs()
        {
            List<User> users =  userDAO.getList();
            return new ModelAndView("addShop", "users", users);
	}
	
        @RequestMapping(value="/Inscription.htm", method = RequestMethod.GET)
	public ModelAndView inscription_get()
        {
            return new ModelAndView("Inscription");
	}
    
	@RequestMapping(value="/Inscription.htm", method = RequestMethod.POST)
	public ModelAndView inscription_post(HttpServletRequest request, HttpServletResponse response)
        {
            String nom = request.getParameter("lastname");
            String prenom = request.getParameter("firstname");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            if (!nom.isEmpty() && !prenom.isEmpty() && !password.isEmpty()&& !email.isEmpty())
            {
                if (userDAO.create(nom, prenom, password, email))
                {
                    return new ModelAndView("addShop", "message", "SUCCESS");
                }
                else
                {
                    return new ModelAndView("addShop", "message", "FAIL");
                }

            }

            return new ModelAndView("Inscription");
	}
        
         
}
