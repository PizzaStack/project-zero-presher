package com.revature.jason.getforme.admin;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.jason.getforme.connections.communictaionsWithDatabase;

public class AdminLogin {
	
	private String adminUserName;
	private String adminPassword;
	
	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public AdminLogin() {}
	
	public void login(Scanner sc) throws SQLException {
		
		System.out.println(
				  "+++++++++++++++++++++++++++++++++++++++++++"
				+ "\n\tWelcome to the Admin Login Portal"
				+ "\n\tPlease Login"
				+ "\n++++++++++++++++++++++++++++++++++++++++++++");
		
		System.out.println("What is your Admin User Name");
		adminUserName = sc.next();
		
		System.out.println("What is your Admin Password");
		adminPassword = sc.next();
		
		new communictaionsWithDatabase().getAdminLoginInfoFromDatabse(getAdminUserName(), getAdminPassword());
	}
}
