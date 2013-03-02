package com.enterprise.organization;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.enterprise.organization.entities.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	//private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
		
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {				
		return "login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String slash() {				
		return "redirect:login";
	}
	
	@RequestMapping(value = "/login/check", method = RequestMethod.POST)
	public String start(@ModelAttribute User user) {
		
		return "home";
		
	}
	
	@ModelAttribute("user")
	public User populateUser() {
		return new User();
	}
	
}
