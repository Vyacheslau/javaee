package com.enterprise.organization.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Department extends AbstractEntity {

	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="department_manager_id")
	private long departmentManagerID;
	
	@OneToMany(mappedBy = "department")
	private List<Employee> employees;
	
	public Department() {
		super();
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public long getDepartmentManagerID() {
		return departmentManagerID;
	}

	public void setDepartmentManagerID(long departmentManagerID) {
		this.departmentManagerID = departmentManagerID;
	}
}
