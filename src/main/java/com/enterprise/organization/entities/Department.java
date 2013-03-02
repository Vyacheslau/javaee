package com.enterprise.organization.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Department extends AbstractEntity {

	@Column
	private String departmentName;
	
	@Column
	private long departmentManagerID;
	
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
