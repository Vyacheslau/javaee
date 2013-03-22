package com.enterprise.organization.dal;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enterprise.organization.dal.idal.IDepartmentDAO;
import com.enterprise.organization.entities.Department;

@Component
@Repository
@Transactional
public class DepartmentDAO extends DAO implements IDepartmentDAO {

	@Override
	public void createDepartment(Department department) {
		getSession().save(department);
	}

	@Override
	public void updateDepartment(Department department) {
		getSession().update(department);
	}

	@Override
	public Department getDepartment(Long id) {
		return (Department) getSession().get(Department.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentList() {
		return getSession().createCriteria(Department.class).list();
	}

	@Override
	public void deleteDepartment(Department department) {
		getSession().delete(department);
	}
}
