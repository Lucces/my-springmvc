package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

	
	public String home(Model model) {
		model.addAttribute("msg", "Hello,MVC!");
		return "home";
	}
	@RequestMapping
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("msg", "ModelAndView");
		return mav;
	}
	
	
	
	
	
	
	
	
}
