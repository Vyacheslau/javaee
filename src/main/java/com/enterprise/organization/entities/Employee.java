package com.enterprise.organization.entities;

public class Employee {

	private long emploeeID;
	private long managerID;
	private Department department;
	private Passport passport;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
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
