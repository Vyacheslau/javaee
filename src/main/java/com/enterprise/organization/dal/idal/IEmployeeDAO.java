package com.enterprise.organization.dal.idal;

import java.util.List;

import com.enterprise.organization.entities.Employee;

public interface IEmployeeDAO extends IDAO {

	void createEmployee(Employee employee);

	void updateEmployee(Employee employee);

	Employee getEmployee(Long id);
	
	List<Employee> getEmployeeList();
		
	void deleteEmployee(Employee employee);
	
}
