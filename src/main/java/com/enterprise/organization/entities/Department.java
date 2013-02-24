package com.enterprise.organization.entities;

public class Department {

	private long departmentID;
	private String departmentName;
	private long departmentManagerID;
	
	public Department() {
		super();
	}

	public long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
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
