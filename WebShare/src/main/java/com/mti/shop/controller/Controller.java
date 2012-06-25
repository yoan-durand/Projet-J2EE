package com.mti.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@org.springframework.stereotype.Controller
public class Controller 
{
	
	@RequestMapping(value="/newshop", method = RequestMethod.GET)
	public ModelAndView shopAdd()
        {
		ModelAndView model = new ModelAndView("addShop");
		model.addObject("msg", "hello world");

		return model;
	}
}
