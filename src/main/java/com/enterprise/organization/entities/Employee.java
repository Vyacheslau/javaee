package com.enterprise.organization.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table
public class Employee extends AbstractEntity {

	@Column(name = "manager_id")
	private Long managerID;

	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	private Department department;

	@OneToOne
	@JoinColumn(columnDefinition = "passport_id", referencedColumnName = "id")
	private Passport passport;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "salary")
	private Integer salary;

	public Employee() {
		super();
	}

	public Long getManagerID() {
		return managerID;
	}

	public void setManagerID(Long managerID) {
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

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}
