package com.enterprise.organization.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Employee extends AbstractEntity {

	@Column
	private long managerID;
	
	@ManyToOne
	@JoinTable(name = "EMPLOYEE_DEPARTMENT", joinColumns = { @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID") })
	private Department department;
	
	@OneToOne
	@JoinColumn(columnDefinition = "PASSPORT_ID", referencedColumnName = "ID")
	private Passport passport;
	
	@Column
	private String jobTittle;
	
	@Column
	private int salary;

	public Employee() {
		super();
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
