package com.enterprise.organization.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.enterprise.organization.dal.idal.IEmployeeDAO;
import com.enterprise.organization.dal.idal.IUserDAO;
import com.enterprise.organization.entities.Employee;
import com.enterprise.organization.entities.User;

@Controller
@RequestMapping(value = "/app")
public class ApplicationController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IEmployeeDAO employeeDAO;
	
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public String start(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		Employee employee = employeeDAO.getEmployee(user.getEmployee().getId());
		
		model.addAttribute("employee", employee);

		return "myprofile";
	}
	
	@RequestMapping(value = "/myprofile/update", method = RequestMethod.GET)
	public String updateEmployee(@ModelAttribute Employee employee, HttpServletRequest request) {
				
		//model.addAttribute("employee", employee);

		return "myprofile";
	}

	@ModelAttribute("user")
	public User populateUser() {
		return new User();
	}
	
	@ModelAttribute("employee")
	public Employee populateEmployee() {
		return new Employee();
	}
}
