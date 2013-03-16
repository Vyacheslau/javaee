package com.enterprise.organization.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class User extends AbstractEntity {
	
	@Column(name="login", unique=true)
	private String login;
	
	@Column(name="password")
	private String password;
	
	@OneToOne
	@JoinColumn(columnDefinition = "employee_id", referencedColumnName = "ID")
	private Employee employee;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
