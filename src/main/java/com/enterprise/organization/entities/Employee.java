package com.enterprise.organization.entities;

public class Employee {
	
	private long emploeeID;
	private long managerID;
	private long departmentID;
	private long passportID;
	private String jobTittle;
	private int salary;
		
	public Employee() {
		super();
	}
	
	public long getEmploeeID() {
		return emploeeID;
	}
	public void setEmploeeID(long emploeeID) {
		this.emploeeID = emploeeID;
	}
	public long getManagerID() {
		return managerID;
	}
	public void setManagerID(long managerID) {
		this.managerID = managerID;
	}
	public long getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}
		
	public long getPassportID() {
		return passportID;
	}

	public void setPassportID(long passportID) {
		this.passportID = passportID;
	}

	public String getJobTittle() {
		return jobTittle;
	}
	public void setJobTittle(String jobTittle) {
		this.jobTittle = jobTittle;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
