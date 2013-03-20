package com.enterprise.organization.controllers;

import org.apache.log4j.Logger;
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

	private static final Logger logger = Logger
			.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String slash() {
		return "redirect:login";
	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError() {
		return "loginError";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "login";
	}
	
	@ModelAttribute("user")
	public User populateUser() {
		return new User();
	}
}
