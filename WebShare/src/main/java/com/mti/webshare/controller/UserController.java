package com.mti.webshare.controller;

import com.mti.webshare.daoImpl.UserDAOImpl;
import com.mti.webshare.model.User;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/controller")
public class UserController
{
	
	@RequestMapping(value="/newshop", method = RequestMethod.GET)
	public ModelAndView shopAdd()
        {
		ModelAndView model = new ModelAndView("addShop");
		model.addObject("msg", "Bienvenue sur webshare");
                  UserDAOImpl user = new UserDAOImpl();
                  user.getUserByEmail("toto");
                  
		return model;
	}
        
         
}
