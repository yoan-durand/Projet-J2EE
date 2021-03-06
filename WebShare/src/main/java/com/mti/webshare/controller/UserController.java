package com.mti.webshare.controller;


import com.mti.webshare.dao.EventDAO;
import com.mti.webshare.dao.FileDAO;
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
        @Autowired
        private EventDAO eventDAO;
        @Autowired
        private FileDAO fileDAO;
        
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
            String lastname = request.getParameter("lastname");
            String firstname = request.getParameter("firstname");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String password2 = request.getParameter("confpass");

            if (!lastname.isEmpty() && !firstname.isEmpty() && !password.isEmpty() 
                                    && !email.isEmpty() && !password2.isEmpty())
            {
                if (!password.contentEquals(password2)){
                   return new ModelAndView("addShop", "message", "Different passwords"); 
                }
                if (userDAO.create(lastname, firstname, password, email))
                {
                    try
                    {
                        boolean isCreated = new java.io.File(request.getSession().getServletContext().getInitParameter("serverLocation")+email).mkdir();
                        if (isCreated)
                        {
                            fileDAO.create(email, false, request.getSession().getServletContext().getInitParameter("serverLocation")+email, true, userDAO.get(email), Boolean.TRUE, null);
                            return new ModelAndView("addShop", "message", "SUCCESS");
                        }
                    }
                    catch (Exception e)
                    {
                        return new ModelAndView("addShop", "message", e.getMessage());
                    }
                }
                return new ModelAndView("addShop", "message", "FAIL");
            }
            return new ModelAndView("Inscription");
	}
}
