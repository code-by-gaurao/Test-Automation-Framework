package com.ui.pojo;

public class User {
	private String emailAddress;
	private String password;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}
//Created for CSV reader utility
	public User(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//optional
	@Override
	public String toString() {
		return "User [emailAddress=" + emailAddress + ", password=" + password + "]";
	}

}
