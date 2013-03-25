package com.enterprise.organization.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.enterprise.organization.entities.Department;
import com.enterprise.organization.entities.Employee;

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
		model.addAttribute("department", department);

		return "departmentDetails";
	}

	@RequestMapping(value = "/departmentDetails/update", method = RequestMethod.POST)
	public String updateEmployeeDetails(@ModelAttribute Department department,
			@RequestParam long departmentID) {
		departmaentDAO.updateDepartment(department);
		return "departmentDetails";
	}

	@RequestMapping(value = "/actions/addNew", method = RequestMethod.GET)
	public String addNewDepartment(Model model) {
		model.addAttribute("department", new Department());

		return "addNewDepartment";

	}

	@RequestMapping(value = "actions/addNewDepartment", method = RequestMethod.POST)
	public String insertNewDepartment(@ModelAttribute Department department,
			Model model) {
		if (!(departmaentDAO.isExist(department))) {
			Long id = departmaentDAO.createDepartment(department);
			return "redirect:/app/departmentDetails/?departmentID=" + id;
		} else {
			model.addAttribute("department", department);
			return "addNewDepartmentError";
		}
	}

	@RequestMapping(value = "actions/deleteDepartment", method = RequestMethod.GET)
	public String deleteEmployee(@ModelAttribute Employee employee,
			@RequestParam long departmentID) {

		Department department = departmaentDAO.getDepartment(departmentID);
		departmaentDAO.deleteDepartment(department);

		return "redirect:/app/departments";
	}
}
