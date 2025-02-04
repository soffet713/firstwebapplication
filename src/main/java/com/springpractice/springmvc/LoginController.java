package com.springpractice.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.springpractice.login.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	//@ResponseBody
	public String showLoginPage() {
		//return "Hello World";
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	//@ResponseBody
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(!service.validateUser(name,password)) {
			model.put("errorMessage", "Invalid Credentials! Please try again.");
			return "login";
		}
		
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}
}
