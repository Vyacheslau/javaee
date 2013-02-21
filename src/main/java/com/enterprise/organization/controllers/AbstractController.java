package com.enterprise.organization.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import com.enterprise.organization.dal.idal.IDepartmentDAO;
import com.enterprise.organization.dal.idal.IEmployeeDAO;
import com.enterprise.organization.dal.idal.IUserDAO;
import com.enterprise.organization.entities.User;

@Controller
public abstract class AbstractController {
	
	@Autowired
	protected IUserDAO userDAO;
	
	@Autowired
	protected IEmployeeDAO employeeDAO;
	
	@Autowired
	protected IDepartmentDAO departmaentDAO;
				
	protected static final Logger logger = Logger.getLogger(AbstractController.class);
	
	protected User getUserFromSession(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		return user;		
	}

}
