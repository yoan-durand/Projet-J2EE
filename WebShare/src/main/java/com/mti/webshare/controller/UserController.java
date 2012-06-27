package com.mti.webshare.controller;

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

		return model;
	}
        
         @RequestMapping(value="/newuser", method = RequestMethod.POST)
         public ModelAndView addUser()
         {
             ModelAndView model = new ModelAndView("addUser");
             User user = new User();
             
             Map<String, Object> map = model.getModel();
             user.setDeleted(false);
             user.setEmail(map.get("email").toString());             
             user.setFisrtName(map.get("firstname").toString());
             user.setLastName(map.get("lastname").toString());
             user.setPassword(map.get("password").toString());
             
             return model;
         }
}
