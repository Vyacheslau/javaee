package com.enterprise.organization.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.organization.dal.idal.IEmployeeDAO;

@Controller
@RequestMapping(value = "/app")
public class EmployeeController {
	
	@Autowired
	private IEmployeeDAO employeeDao;
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	@RequestMapping(value = "/employees")
	public String employees(Model model) {
		model.addAttribute("employeeList", employeeDao.getEmployeeList());
		
		return "employees";
	}
	

}
