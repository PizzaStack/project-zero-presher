package com.revature.jason.getforme;

import java.util.Scanner;

import com.revature.jason.getforme.entity.Login;
import com.revature.jason.getforme.entity.User;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner sc = new Scanner(System.in);
    public static void main( String[] args ){
    	
        
    	System.out.println( 
        		"Welcome to The Gift Registry. Please Select an Option "
        		+ "\n--------------------------------------------------- "
        		+ "\n1. to Create an Account"
        		+ "\n3. to Login as a User"
        		+ "\n5. Login as an Administrator"
        		+ "\n----------------------------------------------------" );
        
        
        
        int selection = sc.nextInt();
        
        switch(selection) {
        
        case 1:
        	createAccount();
        	break;
        case 3:
        	userLogin();
        	break;
        case 5:
        	adminLogin();
        	break;
        	default:
        		System.out.println("Invalid Selection. Please Try Again");
        	
        }
        
        
    }
	private static void adminLogin() {
		// TODO Auto-generated method stub
		System.out.println("Admin Login");
	}

	private static void userLogin() {
		// TODO Auto-generated method stub
		
		new Login(sc).askForLogin(sc);
	}

	private static void createAccount() {
		// TODO Auto-generated method stub
		new User().userIsANewUser(sc);
	}
    
}
