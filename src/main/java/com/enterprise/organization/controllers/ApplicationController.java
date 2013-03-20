package com.enterprise.organization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.enterprise.organization.dal.idal.IUserDAO;
import com.enterprise.organization.entities.User;

@Controller
public class ApplicationController {

	@Autowired
	private IUserDAO userdao;

	@RequestMapping(value = "/myprofile", method = RequestMethod.POST)
	public String start(@ModelAttribute User user) {

		if (userdao.checkCredantials(user)) {
			return "myprofile";
		} else {
			return "redirect:loginError";
		}
	}

	@ModelAttribute("user")
	public User populateUser() {
		return new User();
	}
}
