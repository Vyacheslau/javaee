package com.enterprise.organization.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/app")
public class SummaryController extends AbstractController {
	
	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public String summary(Model model) {
		//model.addAttribute("employeeList", employeeDAO.getEmployeeList());
		model.addAttribute("departmentList", departmaentDAO.getDepartmentList());
		
		return "summary";	
	}
}
