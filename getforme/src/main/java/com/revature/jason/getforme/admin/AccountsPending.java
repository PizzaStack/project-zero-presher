package com.revature.jason.getforme.admin;

public class AccountsPending {

	private String ID;
	private String name;
	private String userName;
	private String accountStatus;
	
	public AccountsPending() {}
	
	public String getID() {
		return ID;
	}
	public String setID(String string) {
		return ID = string;
	}
	public String getName() {
		return name;
	}
	public String setName(String name) {
		return this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public String setUserName(String userName) {
		return this.userName = userName;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public String setAccountStatus(String string) {
		return this.accountStatus = string;
	}
}
