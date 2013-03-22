package com.enterprise.organization.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.enterprise.organization.entities.User;

@Controller
public abstract class AbstractController {
	
	protected User getUserFromSession(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		return user;		
	}

}
