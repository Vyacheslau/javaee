package com.enterprise.organization.dal.idal;

import com.enterprise.organization.entities.Employee;

public interface IEmployeeDAO extends IDAO {

	void createEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void getEmployee(Long id);

	void deleteEmployee(Employee employee);
	
}
