package com.cliff.manager.getEmployees;

public class Managers {
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public String setUserName(String userName) {
		return this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		return this.password = password;
	}
	public Managers(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Managers [userName=" + userName + ", password=" + password + "]";
	}
	
	

}
