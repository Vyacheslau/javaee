package com.enterprise.organization;

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
public class LoginController {
	
	@Autowired
	private IUserDAO userdao;
	
	//private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
		
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		createAdmin();

		return "login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String slash() {				
		return "redirect:login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String start(@ModelAttribute User user) {
		
		/*if(userdao.checkLogin(user)) {
			return "home";
		} else {
			return "login";
		}	*/
		
		return "home";
	}
	
	@ModelAttribute("user")
	public User populateUser() {
		return new User();
	}
	
	private void createAdmin() {
		User user = new User();
		user.setLogin("admin");
		user.setPassword("admin");
		
		userdao.createUser(user);
	}
	
}
