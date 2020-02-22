package com.cg.movie.bean;

public class User {

	private int userId;// declaring fields with private modifier
	private String userName;
	private String password;

	public User(int userId, String userName, String password) {
		super();// parameterized constructor
		this.userId = userId;
		this.userName = userName;// assigning parameter value to fields
		this.password = password;
	}

	public User() {// default construtor
		super();
	}

	public int getUserId() {// getters and setters
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
