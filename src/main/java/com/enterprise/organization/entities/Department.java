package com.enterprise.organization.entities;

import java.util.List;

import javax.persistence.CascadeType;
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
	
	@Column
	private String description;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
