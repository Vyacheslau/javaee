package com.enterprise.organization.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.enterprise.organization.entities.Department;
import com.enterprise.organization.entities.Employee;
import com.enterprise.organization.entities.User;

@Controller
@RequestMapping(value = "/app")
public class MyProfileController extends AbstractController {

	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public String start(Model model, HttpServletRequest request) {
		Employee employee = getUserFromSession(request).getEmployee();

		List<Department> departmentList = departmaentDAO.getDepartmentList();
		model.addAttribute("employee", employee);
		model.addAttribute("departmentList", departmentList);

		return "myprofile";
	}

	@RequestMapping(value = "/myprofile/update", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute Employee employee,
			HttpServletRequest request) {
		Department department = employee.getDepartment();
		if (department.getId() == null) {
			employee.setDepartment(null);
		}

		User user = getUserFromSession(request);
		user.setEmployee(employee);
		user.setPassword(employee.getUser().getPassword());

		userDAO.updateUser(user);
		user = userDAO.getUser(user.getId());
		setUserToSession(request, user);
		return "redirect:../myprofile";
	}
}
