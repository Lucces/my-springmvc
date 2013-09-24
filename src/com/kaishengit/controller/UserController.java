package com.kaishengit.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kaishengit.entity.User;
import com.kaishengit.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Inject
	private UserService userService;

	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String newUser() {
		return "user/new";
	}
	
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public String save(User user,String zipcode,RedirectAttributes redirectAttributes) {
		userService.save(user);
		System.out.println("zipcode:" + zipcode);
		redirectAttributes.addFlashAttribute("message", "Ìí¼Ó³É¹¦");
		return "redirect:/home";
	}
	
	@RequestMapping(value="/{id:\\d+}",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public User getUser(@PathVariable("id") int userId,Model model) {
		return userService.findById(userId);
	}
	
	
	/*@RequestMapping({"/page","/page/{p:\\d+}"})
	public String page(@PathVariable int p) {
		System.out.println("PageNum:" + p);
		return "user/new";
	}*/
	
	
	//@RequestMapping(value="/page")
	/*public String page(@RequestParam(value="p",required=false,defaultValue="1") int p) {
		System.out.println("PageNum:" + p);
		return "user/new";
	}*/
	
	
	
}
