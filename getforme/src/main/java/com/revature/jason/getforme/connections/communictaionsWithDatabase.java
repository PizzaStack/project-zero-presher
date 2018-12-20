package com.revature.jason.getforme.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.jason.getforme.App;
import com.revature.jason.getforme.control.dbConn;
import com.revature.jason.getforme.entity.Login;
import com.revature.jason.getforme.entity.ShowUsersAccount;
import com.revature.jason.getforme.entity.User;



public class communictaionsWithDatabase {
	dbConn dbconn = new dbConn();
	Scanner sc = new Scanner(System.in);
	
	public void insertNewUserToDatabase(String Address, String gifts, String Name, Integer Account, 
			String RegistryName, String Phone, String UserName, String UserPwd) throws SQLException {
		//User user = new User();
		
		String returnedUserName = getUserNameFromRegistry(UserName);
		if(returnedUserName != null) {
			System.out.println("User Name already exists. Press any key to continue.");
			sc.next();
			new Login(sc);
		}else {
			String host = dbconn.getHost();
			String username = dbconn.getUsername();
			String pw = dbconn.getPw();		
			Connection conn = DriverManager.getConnection(host, username, pw);
			
		 PreparedStatement preAddCustomer = null;
         String addCustomer = "INSERT INTO customers(name, address, phone, gifts, userName, pass, registryName, accountNumber) VALUES (?,?,?,?,?,?,?,?)";
         preAddCustomer = conn.prepareStatement(addCustomer);
         preAddCustomer.setString(1,Name);
         preAddCustomer.setString(2,Address);
         preAddCustomer.setString(3,Phone);         
		   preAddCustomer.setString(4,gifts);
		   preAddCustomer.setString(5,UserName);
		   preAddCustomer.setString(6,UserPwd);
		   preAddCustomer.setString(7,RegistryName);
		   preAddCustomer.setInt(8,Account);
         preAddCustomer.executeUpdate();//.executeUpdate for update statements .executeQuery for SELECT statements
         conn.close();
        // getUserFromRegistry(Name);
         new Login(sc).askForLogin(sc);
		}
//		
}
	public void getUserFromRegistry(String UserName) throws SQLException {
		String host = dbconn.getHost();
		String username = dbconn.getUsername();
		String pw = dbconn.getPw();			
		String dbname;
		String dbgift;
		Connection conn = DriverManager.getConnection(host, username, pw);
		
		String getCustomerName = "SELECT name FROM customers WHERE username = '" + UserName + "'";
		String getCustomerGift = "SELECT gifts FROM customers WHERE username = '" + UserName + "'";
		
		 PreparedStatement preGetCustomerName = conn.prepareStatement(getCustomerName);
		 PreparedStatement preGetCustomerGift = conn.prepareStatement(getCustomerGift);
	      
	       ResultSet name = preGetCustomerName.executeQuery();
	       ResultSet gift = preGetCustomerGift.executeQuery();
	  
	       dbname = null;
	       dbgift = null;
	       
	       while(name.next()) {
	    	   dbname = name.getString(1); //parameter equals number of rows to return
	    	   System.out.println(dbname);
	       }
	       while(gift.next()) {
	    	   dbgift = gift.getString(1);
	    	   
	       }
		conn.close();
		
		if(dbgift == null) {
			System.out.println("There are no gifts in your registry. You can add on now.");
		}else
		new ShowUsersAccount().UsersAccount(dbname, dbgift);
	}
	
	
	
	public void getUserLoginInfoFromDatabse(String inpUser, String inpPass) throws SQLException {
		
		String host = dbconn.getHost();
		String username = dbconn.getUsername();
		String pw = dbconn.getPw();	
		String dbpw;
		Connection conn = DriverManager.getConnection(host, username, pw);
		
		 //PreparedStatement preGetCustomer = null;
	      String getCustomerPW = "SELECT pass FROM customers WHERE username = '" + inpUser + "'";
	      
		 PreparedStatement preGetCustomer = conn.prepareStatement(getCustomerPW);
      // String getCustomerUN = "SELECT pass FROM customers WHERE userName = '" + inpUser + "'";
      // String getCustomerPW = "SELECT pass FROM customers WHERE username = '\" + inpUser + \"' , pass = '\" + inpPass + \"'";
       ResultSet resultSet = preGetCustomer.executeQuery();
  
       dbpw = null;
       
       while(resultSet.next()) {
    	   dbpw = resultSet.getString(1); 
       }
      
      
       conn.close();
	
		if(dbpw == null) {
			System.out.println("Your Account does not exist. Please try again or sign up for an accout"
					+ "1 to return to login screen"
					+ "2 to sign up for an account"
					+ "3 exit to main screen");
			
			int select = sc.nextInt();
			
			switch (select) {
			
			case 1:
				returnToLogin(null);
				break;
			case 2:
				signUp();
				break;
			case 3:
				exit();
				break;
			default:
				System.out.println("In valid selection please try again");
				break;
			}
		} 
		else if(inpPass.equals(dbpw)) {
		
	        System.out.println("You have Successfully Logged in, Press any key to continue");
	        sc.nextLine();
	        getUserFromRegistry(inpUser);
	    }else  {
	        System.out.println("Password or Username incorrect. Press any key to continue.");
	        sc.next();
	        new Login(sc);
	    }
}

	public String getUserNameFromRegistry(String UserName) throws SQLException {
		String host = dbconn.getHost();
		String username = dbconn.getUsername();
		String pw = dbconn.getPw();	
		String dbun;
		Connection conn = DriverManager.getConnection(host, username, pw);
		
		String getCustomerName = "SELECT username FROM customers WHERE username = '" + UserName + "'";		
		 PreparedStatement preGetCustomerName = conn.prepareStatement(getCustomerName);	 
	       ResultSet rsun = preGetCustomerName.executeQuery();
	       dbun = null;
	       while(rsun.next()) {
	    	   dbun = rsun.getString(1); //parameter equals number of rows to return	    	   
	       }
	       conn.close();
		return dbun;
	}

	private void exit() {
		// TODO Auto-generated method stub
		new App();
	}


	private void signUp() {
		// TODO Auto-generated method stub
		new User();
	}


	private void returnToLogin(Login login) {
		// TODO Auto-generated method stub
		new Login(sc);
	}
	
	
}

