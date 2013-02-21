package com.enterprise.organization.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.enterprise.organization.entities.Department;
import com.enterprise.organization.entities.Employee;
import com.enterprise.organization.entities.User;
import com.enterprise.organization.enums.UserRole;
import com.enterprise.organization.utils.Config;

@Controller
@RequestMapping(value = "/app")
public class EmployeeController extends AbstractController {

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String employees(Model model) {
		model.addAttribute("employeeList", employeeDAO.getEmployeeList());

		return "employees";
	}

	@RequestMapping(value = "/employeeDetails", method = RequestMethod.GET)
	public String employeeDetails(@RequestParam long employeeID, Model model,
			HttpServletRequest request) {
		Employee employee = employeeDAO.getEmployee(employeeID);
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
		
		employeeDAO.updateEmployee(employee);
		return "employeeDetails";
	}

	@RequestMapping(value = "actions/hireNew", method = RequestMethod.GET)
	public String getHireNewForm(Model model) {
		List<Department> departmentList = departmaentDAO.getDepartmentList();
		model.addAttribute("employee", new Employee());
		model.addAttribute("departmentList", departmentList);

		return "hireNewEmployee";
	}

	@RequestMapping(value = "actions/addNewEmployee", method = RequestMethod.POST)
	public String insertNewEmployee(@ModelAttribute Employee employee, Model model) {
		User user = new User();
		user.setLogin(employee.getFirstName() + "_" + employee.getLastName());		
		user.setPassword(Config.getValue("def.password"));
		user.setUserRole(String.valueOf(UserRole.EMPLOYEE));
		user.setEmployee(employee);

		Department department = employee.getDepartment();
		if (department.getId() == null) {
			employee.setDepartment(null);
		} else {
			employee.setManagerID(department.getDepartmentManagerID());
		}

		if (!(userDAO.isExist(user))) {
			Long id = userDAO.createUser(user);
			user = userDAO.getUser(id);
			return "redirect:/app/employeeDetails/?employeeID=" + user.getEmployee().getId();
		} else {
			model.addAttribute("employee", employee);
			return "hireNewEmployeeError";
		}
	}

	@RequestMapping(value = "actions/dismiss")
	public String deleteEmployee(@ModelAttribute Employee employee,
			@RequestParam long employeeID) {
		User user = userDAO.getUser(employeeID);
		userDAO.deleteUser(user);
		
		return "redirect:/app/employees";
	}
}
