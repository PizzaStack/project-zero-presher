package com.revature.jason.getforme.entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.jason.getforme.App;
import com.revature.jason.getforme.connections.communictaionsWithDatabase;

public class Login {
	static final Logger logger = Logger.getLogger(Login.class.getName());
	
	private String inpUser;
    private String inpPass;
    
    
	
	public String getInpUser() {
		return inpUser;
	}

	public void setInpUser(String inpUser) {
		this.inpUser = inpUser;
	}

	public String getInpPass() {
		return inpPass;
	}

	public void setInpPass(String inpPass) {
		this.inpPass = inpPass;
	}

	public Login(Scanner sc){}
	
		public void askForLogin(Scanner sc) {
		//Scanner keyboard = new Scanner(System.in);
		System.out.println(
				  "++++++++++++++++++++++++++++++++++++++++++++"
	    		+ "\n\tWelcome to The Registry Please Login"
	    		+ "\n-------------------------------------------");
		
	    System.out.println("\tWhat is your Username?");
	    logger.info("User Name Login Attempt");
	    inpUser = sc.next();
	    System.out.println("\tWhat is you password?");
	    logger.info("Password Login Attempt");
	    inpPass = sc.next(); // gets input from user  
	    
	     loginInToRegistry();
	}
	  
	
	public void loginInToRegistry() {
					    
	    communictaionsWithDatabase getUser = new communictaionsWithDatabase();
	    try {
			getUser.getUserLoginInfoFromDatabse(this.inpUser, this.inpPass);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
	}
}

