package com.enterprise.organization.services;

import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.organization.dal.idal.IUserDAO;
import com.enterprise.organization.entities.Employee;
import com.enterprise.organization.entities.User;
import com.enterprise.organization.enums.UserRole;

@Service
public class CreateAdminService {

	private static final Logger logger = Logger
			.getLogger(CreateAdminService.class);
	
	@Autowired
	private IUserDAO userDAO;

	@PostConstruct
	public void createAdmin() {
		User user = new User();
		user.setLogin(ResourceBundle.getBundle("configuration").getString("admin.login"));
		user.setPassword(ResourceBundle.getBundle("configuration").getString("admin.password"));
		user.setUserRole(String.valueOf(UserRole.ADMIN));

		Employee employee = new Employee();

		user.setEmployee(employee);
		//employee.setUser(user);
		
		if(!(userDAO.isExist(user))) {
			userDAO.createUser(user);
		} else {
			logger.info("User admin exists");
		}
	}
}
