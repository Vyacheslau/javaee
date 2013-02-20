package com.enterprise.organization.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.enterprise.organization.dal.idal.IUserDAO;
import com.enterprise.organization.entities.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController extends AbstractController {
	
	@Autowired
	private IUserDAO userDAO;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String slash() {
		return "redirect:login";
	}
	
	@RequestMapping(value = "/login/check", method = RequestMethod.POST)
	public String start(@ModelAttribute User user, HttpServletRequest request) {

		if (userDAO.checkCredantials(user)) {
			user = userDAO.getUserByLogin(user.getLogin());
			request.getSession().setAttribute("user", user);
			
			return "redirect:../app/myprofile";
		} else {
			return "redirect:error";
		}
	}

	@RequestMapping(value = "/login/error", method = RequestMethod.GET)
	public String loginError() {
		return "loginError";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		req.getSession().removeAttribute("userID");
		return "redirect:login";
	}
	
	@ModelAttribute("user")
	public User populateUser() {
		return new User();
	}
}
