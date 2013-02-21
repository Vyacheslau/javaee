package com.enterprise.organization.dal.idal;

import java.util.List;

import com.enterprise.organization.entities.Department;

public interface IDepartmentDAO extends IDAO {
	
	long createDepartment(Department department);

	void updateDepartment(Department department);
	
	boolean isExist(Department department);

	Department getDepartment(Long id);
	
	List<Department> getDepartmentList();

	void deleteDepartment(Department department);

}
