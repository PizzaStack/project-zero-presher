package com.revature.jason.getforme;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.revature.jason.getforme.entity.Login;
import com.revature.jason.getforme.entity.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        
    	System.out.println( 
        		"Welcome to The Gift Registry. Please Select an Option "
        		+ "\n--------------------------------------------------- "
        		+ "\n1. to Create an Account"
        		+ "\n3. to Login as a User"
        		+ "\n5. Login as an Administrator"
        		+ "\n----------------------------------------------------" );
        
        Scanner sc = new Scanner(System.in);
        
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

	private static void userLogin() throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("User Login");
		new Login();
	}

	private static void createAccount() throws FileNotFoundException {
		// TODO Auto-generated method stub
		new User();
	}
    
}
