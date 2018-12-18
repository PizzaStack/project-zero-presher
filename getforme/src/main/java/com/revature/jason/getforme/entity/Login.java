package com.revature.jason.getforme.entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.jason.getforme.App;

public class Login {
	public Login() throws FileNotFoundException {
		//String content = new Scanner(new File("filename")).useDelimiter("\\Z").next();
	    
		Scanner un = new Scanner (new File("C:\\Users\\jason\\jason-workspace\\getforme\\src\\main\\java\\com\\revature\\jason\\getforme\\entity\\userName.txt"));
	    Scanner pw = new Scanner(new File("C:\\Users\\jason\\jason-workspace\\getforme\\src\\main\\java\\com\\revature\\jason\\getforme\\entity\\password.txt"));
		Scanner keyboard = new Scanner (System.in);
	    String user = un.useDelimiter("\\Z ").nextLine();
	    String pass = pw.useDelimiter("\\Z ").nextLine(); // looks at selected file in scan
	    String inpUser;
	    String inpPass;
	   
	    System.out.println(user + pass);
	    System.out.println("+++++++++++++++++++++++++++++++++++"
	    		+ "\nWelcome to The Registry Please Login"
	    		+ "\n-----------------------------------");
	    System.out.println("What is your Username?");
	    inpUser = keyboard.nextLine();
	    System.out.println("What is you password?");
	    inpPass = keyboard.nextLine(); // gets input from user
	    
//	    List<String> userUN = new ArrayList<String>();
//	    List<String> userPass = new ArrayList<String>();
//	    String user;
//	    String pass;
//	    while(user = un.nextLine() != null) {
////	        userUN.add(user);
//	        System.out.println(user);
//	    }
//	    while((pass=pw.nextLine()) != null) {
//	    	userPass.add(pass);
//	        System.out.println(pass);
//	    }
	    if(inpUser.equals(user) && inpPass.equals(pass)) {
	        System.out.print("You have Successfully Logged in");
	        un.close();
	        pw.close();
		    keyboard.close();
		    
	    }else  {
	        System.out.print("Password or Username incorrect. Press any key to continue.");
	        keyboard.nextLine();
	        new Login();
	    }
	   
	}

	private Object String(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public Login() {
//		
//	}
		
}

