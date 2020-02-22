package com.cg.movie.bean;

import java.time.LocalDate;

public class Admin {// Admin class with public modifier in bean package
	private int adminId;
	private String adminName;// creating private fields/variables
	private String adminPassword;
	private LocalDate dateOfBirth;
	private String adminContact;

//  parameterized  constructor
	public Admin(int adminId, String adminName, String adminPassword, LocalDate dateOfBirth, String adminContact) {
		super();// if we define or not it will always be super constructor
		this.adminId = adminId;
		this.adminName = adminName;// assigning values to fields in constructor
		this.adminPassword = adminPassword;
		this.dateOfBirth = dateOfBirth;
		this.adminContact = adminContact;
	}

	public Admin() {// default constructor
		super();
	}

	public int getAdminId() {//getters and setters for fields/paramters
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

}
