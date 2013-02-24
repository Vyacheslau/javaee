package com.enterprise.organization.entities;

import java.util.Date;

public class Passport {
	
	private long passportID;
	private String firstName;
	private String lastName;
	private Date birthDate;
	
	public Passport() {
		super();
	}

	public long getPassportID() {
		return passportID;
	}

	public void setPassportID(long passportID) {
		this.passportID = passportID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
