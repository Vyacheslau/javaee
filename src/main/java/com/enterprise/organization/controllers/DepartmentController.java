package com.enterprise.organization.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.enterprise.organization.entities.Department;

@Controller
@RequestMapping(value = "/app")
public class DepartmentController extends AbstractController {

	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public String departments(Model model) {
		List<Department> departmentList = departmaentDAO.getDepartmentList();
		model.addAttribute("departmentList", departmentList);

		return "departments";
	}

	@RequestMapping(value = "/departmentDetails", method = RequestMethod.GET)
	public String getDepartmentDetails(Model model,
			@RequestParam long departmentID) {
		Department department = departmaentDAO.getDepartment(departmentID);
		model.addAttribute("employeeList", employeeDAO.getEmployeeList());
		model.addAttribute("department", department);
		return "departmentDetails";
	}

	@RequestMapping(value = "/departmentDetails/update", method = RequestMethod.POST)
	public String updateEmployeeDetails(@ModelAttribute Department department,
			@RequestParam long departmentID) {
		checkManager(department);
		
		departmaentDAO.updateDepartment(department);
		return "redirect:/app/departmentDetails/?departmentID=" + departmentID;
	}

	@RequestMapping(value = "/actions/addNew", method = RequestMethod.GET)
	public String addNewDepartment(Model model) {
		model.addAttribute("department", new Department());
		model.addAttribute("employeeList", employeeDAO.getEmployeeList());

		return "addNewDepartment";

	}

	@RequestMapping(value = "actions/addNewDepartment", method = RequestMethod.POST)
	public String insertNewDepartment(@ModelAttribute Department department,
			Model model) {
		checkManager(department);

		if (!(departmaentDAO.isExist(department))) {
			Long id = departmaentDAO.createDepartment(department);
			return "redirect:/app/departmentDetails/?departmentID=" + id;
		} else {
			model.addAttribute("employeeList", employeeDAO.getEmployeeList());
			model.addAttribute("department", department);
			return "addNewDepartmentError";
		}
	}

	@RequestMapping(value = "actions/deleteDepartment", method = RequestMethod.GET)
	public String deleteEmployee(Model model, @RequestParam long departmentID,
			HttpServletRequest request) {

		Department department = departmaentDAO.getDepartment(departmentID);
		try {
			departmaentDAO.deleteDepartment(department);
		} catch (InvalidDataAccessApiUsageException e) {
			logger.warn("User " + getUserFromSession(request).getLogin()
					+ " tries to delete Department with id [" + departmentID
					+ "] which has mapped employees.");

			List<Department> departmentList = departmaentDAO
					.getDepartmentList();
			model.addAttribute("departmentList", departmentList);
			model.addAttribute("departmentWithEmployees", department);
			return "departmentsError";
		}

		return "redirect:/app/departments";
	}

	private void checkManager(Department department) {
		if (department.getManager().getId().equals(1L)) {
			department.setManager(null);
		} /*else {
			User user = department.getManager().getUser();
			user.setUserRole(String.valueOf(UserRole.MANAGER));
			userDAO.updateUser(user);
		}*/
	}
}
