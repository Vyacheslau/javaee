package com.enterprise.organization.dal.idal;

import com.enterprise.organization.entities.Department;

public interface IDepartmentDAO extends IDAO {
	
	void createDepartment(Department department);

	void updateDepartment(Department department);

	Department getDepartment(Long id);

	void deleteDepartment(Department department);

}
