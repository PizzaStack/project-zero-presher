package com.revature.jason.getforme;

import java.sql.SQLException;
import java.util.Scanner;

//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.revature.jason.getforme.admin.AdminLogin;
import com.revature.jason.getforme.entity.Login;
import com.revature.jason.getforme.entity.User;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner sc = new Scanner(System.in);
	static final Logger logger = Logger.getLogger(App.class.getName());
	
    public static void main( String[] args ) throws SQLException{
    	
    	//Configure logger
    	
    	       // BasicConfigurator.configure();
    	
    	            	
    	logger.info("App Started");
    	
    	
    	System.out.println( 
        		"Welcome to The Gift Registry. Please Select an Option "
        		+ "\n----------------------------------------"
        		+ "\n\t1. to Create an Account"
        		+ "\n\t3. to Login as a User"
        		+ "\n\t5. Login as an Administrator"
        		+ "\n------------------------------------------" );
        
        
        
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
	private static void adminLogin() throws SQLException {
		// TODO Auto-generated method stub
		new AdminLogin().login(sc);
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
