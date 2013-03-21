package com.enterprise.organization.dal;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enterprise.organization.dal.idal.IEmployeeDAO;
import com.enterprise.organization.entities.Employee;

@Component
@Repository
@Transactional
public class EmployeeDAO extends DAO implements IEmployeeDAO {

	@Override
	public void createEmployee(Employee employee) {
		getSession().save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		getSession().update(employee);
	}

	@Override
	public Employee getEmployee(Long id) {
		return (Employee) getSession().get(Employee.class, id);
	}
		
	@Override
	public void deleteEmployee(Employee employee) {
		getSession().delete(employee);
	}

}
