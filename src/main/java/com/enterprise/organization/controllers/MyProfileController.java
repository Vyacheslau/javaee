package com.enterprise.organization.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.enterprise.organization.dal.idal.IDepartmentDAO;
import com.enterprise.organization.dal.idal.IEmployeeDAO;
import com.enterprise.organization.dal.idal.IUserDAO;
import com.enterprise.organization.entities.Department;
import com.enterprise.organization.entities.Employee;

@Controller
@RequestMapping(value = "/app")
public class MyProfileController extends AbstractController {
	
	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IEmployeeDAO employeeDAO;
	
	@Autowired
	private IDepartmentDAO departmaentDAO;
		
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public String start(Model model, HttpServletRequest request) {
		Employee employee = employeeDAO.getEmployee(getUserFromSession(request).getEmployee().getId());
		List <Department> departmentList = departmaentDAO.getDepartmentList();
		model.addAttribute("employee", employee);
		model.addAttribute("departmentList", departmentList);

		return "myprofile";
	}
	
	@RequestMapping(value = "/myprofile/update", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute Employee employee, HttpServletRequest request) {
		employee.setId(getUserFromSession(request).getEmployee().getId());
		Department department = employee.getDepartment();
		if (department.getId() == null) {
			employee.setDepartment(null);
		} else {
			employee.setManagerID(department.getDepartmentManagerID());
		}		
		employeeDAO.updateEmployee(employee);
		return "redirect:../myprofile";
	}
}
