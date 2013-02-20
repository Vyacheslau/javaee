package com.enterprise.organization.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.enterprise.organization.dal.idal.IEmployeeDAO;
import com.enterprise.organization.entities.Department;
import com.enterprise.organization.entities.Employee;

@Controller
@RequestMapping(value = "/app")
public class EmployeeController extends AbstractController {

	@Autowired
	private IEmployeeDAO employeeDao;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String employees(Model model) {
		model.addAttribute("employeeList", employeeDao.getEmployeeList());

		return "employees";
	}

	@RequestMapping(value = "/employeeDetails", method = RequestMethod.GET)
	public String employeeDetails(@RequestParam long employeeID, Model model,
			HttpServletRequest request) {
		Employee employee = employeeDao.getEmployee(employeeID);
		model.addAttribute("employee", employee);

		if (getUserFromSession(request).getId().equals(employeeID)) {
			return "forward:/app/myprofile";
		} else {
			return "employeeDetails";
		}
	}

	@RequestMapping(value = "/employeeDetails/update", method = RequestMethod.POST)
	public String updateEmployeeDetails(@ModelAttribute Employee employee,
			@RequestParam long employeeID) {
		Department department = employee.getDepartment();
		if (department.getId() == null) {
			employee.setDepartment(null);
		} else {
			employee.setManagerID(department.getDepartmentManagerID());
		}
		employeeDao.updateEmployee(employee);
		
		return "employeeDetails";
	}
	
	@RequestMapping(value = "/hireNew", method = RequestMethod.POST)
	public String getHireNewForm() {
		return "hireNewEmployee";
	}
	
}
