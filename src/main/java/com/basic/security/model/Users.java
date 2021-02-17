package com.basic.security.model;

public class Users {

	String userName;
	String userPassword;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String toString() {
		return "User Name:- "+userName+" User Password:- "+userPassword;
	}
}
