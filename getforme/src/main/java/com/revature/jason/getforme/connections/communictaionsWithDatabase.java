package com.revature.jason.getforme.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.jason.getforme.App;
import com.revature.jason.getforme.admin.AccountsPending;
import com.revature.jason.getforme.admin.Admin;
import com.revature.jason.getforme.admin.AdminLogin;
import com.revature.jason.getforme.control.dbConn;
import com.revature.jason.getforme.control.newDbconn;
import com.revature.jason.getforme.entity.Login;
import com.revature.jason.getforme.entity.ShowUsersAccount;
import com.revature.jason.getforme.entity.User;

public class communictaionsWithDatabase {
	public Logger logger = Logger.getLogger(communictaionsWithDatabase.class);
		
	dbConn dbconn = new dbConn();
	newDbconn newConn = new newDbconn();
	Scanner sc = new Scanner(System.in);

	public communictaionsWithDatabase() {
	}

	public void insertNewUserToDatabase(String Address, String gifts, String Name, Integer Account, String RegistryName,
			String Phone, String UserName, String UserPwd) throws SQLException {
		// User user = new User();

		String returnedUserName = getUserNameFromRegistry(UserName);
		if (returnedUserName != null) {
			System.out.println("User Name already exists. Press any key to continue.");
			sc.next();
			new Login(sc);
		} else {
			String host = dbconn.getHost();
			String username = dbconn.getUsername();
			String pw = dbconn.getPw();
			Connection conn = DriverManager.getConnection(host, username, pw);

			PreparedStatement preAddCustomer = null;
			String addCustomer = "INSERT INTO customers(name, address, phone, gifts, userName, pass, registryName, accountNumber, accountStatus) VALUES (?,?,?,?,?,?,?,?,?)";
			preAddCustomer = conn.prepareStatement(addCustomer);
			preAddCustomer.setString(1, Name);
			preAddCustomer.setString(2, Address);
			preAddCustomer.setString(3, Phone);
			preAddCustomer.setString(4, gifts);
			preAddCustomer.setString(5, UserName);
			preAddCustomer.setString(6, UserPwd);
			preAddCustomer.setString(7, RegistryName);
			preAddCustomer.setInt(8, Account);
			preAddCustomer.setInt(9, 0);
			preAddCustomer.executeUpdate();// .executeUpdate for update statements .executeQuery for SELECT statements
			conn.close();
			// getUserFromRegistry(Name);
			logger.info("New User Added Succesfully");
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

		while (name.next()) {
			dbname = name.getString(1); // parameter equals number of rows to return

		}
		while (gift.next()) {
			dbgift = gift.getString(1);

		}
		conn.close();

		if (dbgift == null) {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" 
					+ "\n\t\t\t" + dbname
					+ "\n\tThere are no gifts in your registry. " 
					+ "\n\t\tYou can add one now."
					+ "\n\t\tPress the any key to continue"
					+ "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			new ShowUsersAccount().UsersAccount(UserName, dbname, dbgift);
			sc.close();
		} else
			new ShowUsersAccount().UsersAccount(UserName, dbname, dbgift);

	}

	public void getUserLoginInfoFromDatabse(String inpUser, String inpPass) throws SQLException {
		
		String host = dbconn.getHost();
		String username = dbconn.getUsername();
		String pw = dbconn.getPw();
		String dbpw;
		int userAccountStatus;
		Connection conn = DriverManager.getConnection(host, username, pw);

		String getCustomerPW = "SELECT pass FROM customers WHERE username = '" + inpUser + "'";
		String getAccountStatus = "SELECT accountStatus FROM customers WHERE username = '" + inpUser + "'";

		PreparedStatement preGetCustomer = conn.prepareStatement(getCustomerPW);
		PreparedStatement preGetAccountStatus = conn.prepareStatement(getAccountStatus);

		ResultSet resultSet = preGetCustomer.executeQuery();
		ResultSet accountStatus = preGetAccountStatus.executeQuery();

		dbpw = null;
		userAccountStatus = 0;

		while (resultSet.next()) {
			dbpw = resultSet.getString(1);
		}
		while (accountStatus.next()) {
			userAccountStatus = accountStatus.getInt(1);
		}

		if (!inpPass.equals(dbpw)) {
			logger.warn("WARNING! Passowrd Does Not Exist Attempt Made");
			System.out.println("#################################################" 
					+ "\n\tYour Account does not exist. "
					+ "\n\tPlease try again or sign up for an accout" 
					+ "\n\t1 to return to login screen"
					+ "\n\t2 to sign up for an account" 
					+ "\n\t3 exit to main screen"
					+ "\n#################################################");

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
		} else if (inpPass.equals(dbpw)) {

			if (userAccountStatus == 0) {
				logger.info("Account Restricted Access Attempt");
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"
						+ "\n\tYou Do Not Have Access At This Time" + "\n\tPress any ket to continue"
						+ "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				conn.close();
				sc.next();
				new Login(sc).askForLogin(sc);

			} else {
				logger.info("Login Attempt Succesful");
				System.out.println("#########################################" + "\n\tYou have Successfully Logged in"
						+ "\n\tPress any key to continue" + "\n########################################");
				sc.nextLine();
				conn.close();
				getUserFromRegistry(inpUser);
			}
		}
//	    }else if(userAccountStatus == 0) {
//	    	 
//	    	System.out.println(
//	    			  "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"
//	    			+ "\n\tYou Do Not Have Access At This Time"
//	    			+ "\n\tPress any ket to continue"
//	    			+ "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//	    	 conn.close();
//	    	sc.next();
//	    	new Login(sc).askForLogin(sc);
//	    	
//	    	
//	}	
		else {
			conn.close();
			logger.warn("WARNING! Password or User Name Failed Attempt");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" 
					+ "\n\tPassword or Username incorrect."
					+ "\n\tPress any key to continue." 
					+ "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			sc.nextLine();
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
		while (rsun.next()) {
			dbun = rsun.getString(1); // parameter equals number of rows to return
		}
		conn.close();
		return dbun;
	}

	public void removeGiftFromRegistry(String UN, String Gifts) throws SQLException {
		String host = dbconn.getHost();
		String username = dbconn.getUsername();
		String pw = dbconn.getPw();
		// String dbun;
		Connection conn = DriverManager.getConnection(host, username, pw);
		// getUserNameFromRegistry();

		// UPDATE customers SET gifts = '' WHERE gifts = 'Marbles' AND username =
		// 'john';
		String removeCustomerGift = "UPDATE customers SET gifts = null WHERE gifts  = '" + Gifts + "' And '" + UN + "'";

		// PreparedStatement preRemoveCustomerGift =
		conn.prepareStatement(removeCustomerGift);

		conn.close();
	}

	public String[] updateRegistryGift(String UN, String Gift, String Gifts) throws SQLException {
		String host = dbconn.getHost();
		String username = dbconn.getUsername();
		String pw = dbconn.getPw();

		Connection conn = DriverManager.getConnection(host, username, pw);

		PreparedStatement preUpdateCustomerGift = null;
		String updateCustomerGift = "UPDATE customers SET gifts = '" + Gift + "' WHERE gifts  = '" + Gift
				+ "' And username = '" + UN + "'";
		preUpdateCustomerGift = conn.prepareStatement(updateCustomerGift);
		String[] newGift = getGiftFromRegistry(UN);
		preUpdateCustomerGift.executeQuery();

		conn.close();
		return newGift;
	}

	public String[] getGiftFromRegistry(String UN) throws SQLException {
		String host = dbconn.getHost();
		String username = dbconn.getUsername();
		String pw = dbconn.getPw();
		String dbgift;
		String dbname;
		Connection conn = DriverManager.getConnection(host, username, pw);

		String getCustomerGift = "SELECT gifts FROM customers WHERE username = '" + UN + "'";
		PreparedStatement preGetCustomerGift = conn.prepareStatement(getCustomerGift);
		ResultSet rsgift = preGetCustomerGift.executeQuery();
		dbgift = null;
		while (rsgift.next()) {
			dbgift = rsgift.getString(1); // parameter equals number of rows to return
		}
		String getCustomerName = "SELECT name FROM customers WHERE username = '" + UN + "'";
		PreparedStatement preGetCustomerName = conn.prepareStatement(getCustomerName);
		ResultSet rsname = preGetCustomerName.executeQuery();
		dbname = null;
		while (rsname.next()) {
			dbname = rsname.getString(1); // parameter equals number of rows to return
		}

		String[] getCustomerNameGift = new String[2];

		getCustomerNameGift[0] = dbgift;
		getCustomerNameGift[1] = dbname;

		conn.prepareStatement(getCustomerGift);
		// UPDATE customers SET gifts = 'Bike' WHERE username =
		// (SELECT username FROM customers WHERE username = 'jason');
		conn.close();
		return getCustomerNameGift;
	}

	public String[] addRegistryGift(String UN, String Gift) throws SQLException {

		String host = dbconn.getHost();
		String username = dbconn.getUsername();
		String pw = dbconn.getPw();
		// String dbgift;
		// String dbname;
		Connection conn = DriverManager.getConnection(host, username, pw);

		PreparedStatement preAddCustomerGift = null;
		String addCustomerGift = "UPDATE customers SET gifts = '" + Gift + "' WHERE username = '" + UN + "'";
		preAddCustomerGift = conn.prepareStatement(addCustomerGift);

		preAddCustomerGift.executeUpdate();
		conn.close();
		return getGiftFromRegistry(UN);

	}

	/*
	 * Admin database connections
	 */

	public void getAdminLoginInfoFromDatabse(String adminUser, String adminPass) throws SQLException {

		String host = dbconn.getHost();
		String username = dbconn.getUsername();
		String pw = dbconn.getPw();
		String dbpw;
		Connection conn = DriverManager.getConnection(host, username, pw);

		String getAdminPW = "SELECT password FROM admin WHERE username = '" + adminUser + "'";

		PreparedStatement preGetAdmin = conn.prepareStatement(getAdminPW);

		ResultSet rsadmin = preGetAdmin.executeQuery();

		dbpw = null;

		while (rsadmin.next()) {
			dbpw = rsadmin.getString(1);
		}

		conn.close();

		if (dbpw == null) {
			System.out.println("#################################################" + "\n\tYour Account does not exist. "
					+ "\n\tPlease try again" + "\n\t1 to return to login screen" + "\n\t3 exit to main screen"
					+ "\n#################################################");

			int select = sc.nextInt();

			switch (select) {

			case 1:
				new AdminLogin().login(sc);
				break;
			case 3:
				exit();
				break;
			default:
				System.out.println("In valid selection please try again");
				new AdminLogin().login(sc);
				break;
			}
		} else if (adminPass.equals(dbpw)) {
			System.out
					.println("#################################################" + "\n\tYou have Successfully Logged in"
							+ "\n\tPress any key to continue" + "\n################################################");
			sc.nextLine();
			new Admin(sc).actionOnAccounts(sc);
		} else {
			System.out
					.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + "\n\tPassword or Username incorrect."
							+ "\n\tPress any key to continue." + "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			sc.nextLine();
			new AdminLogin().login(sc);
		}
	}

	public int doesAccountExist(int ID) throws SQLException {
		String host = dbconn.getHost();
		String username = dbconn.getUsername();
		String pw = dbconn.getPw();
		int dbid;
		Connection conn = DriverManager.getConnection(host, username, pw);

		String getCustomerID = "SELECT id FROM customers WHERE id = '" + ID + "'";
		PreparedStatement preGetCustomerInfo = conn.prepareStatement(getCustomerID);
		ResultSet rsid = preGetCustomerInfo.executeQuery();
		dbid = 0;

		while (rsid.next()) {
			dbid = rsid.getInt(1);
		}

		return dbid;
	}

	public ArrayList<String> viewAccounts(int id) throws SQLException {
		// Connection conn = (Connection) new dbConn();

		String host = dbconn.getHost();
		String username = dbconn.getUsername();
		String pw = dbconn.getPw();
		String dbname;
		String dbgifts;
		String dbusername;

		// String dbname;
		Connection conn = DriverManager.getConnection(host, username, pw);

		String getCustomerInfo = "SELECT name, gifts, username FROM customers WHERE id = '" + id + "'";
		PreparedStatement preGetCustomerInfo = conn.prepareStatement(getCustomerInfo);
		ResultSet rsinfo = preGetCustomerInfo.executeQuery();
		dbname = null;
		dbgifts = null;
		dbusername = null;
		ArrayList<String> customerInfo = new ArrayList<String>();
		while (rsinfo.next()) {
			dbname = rsinfo.getString(1);
			dbgifts = rsinfo.getString(2);
			dbusername = rsinfo.getString(3);

			customerInfo.add(dbname);
			customerInfo.add(dbgifts);
			customerInfo.add(dbusername);

//	    	   for(int i = 0; i <= dbinfo.length(); i++) {	    		   
//	    		   
//	    	   }
			// parameter equals number of rows to return

		}
		conn.close();
		return customerInfo;
	}

	public String removeUsersGift(int id) throws SQLException {
//		String host = dbconn.getHost();
//		String username = dbconn.getUsername();
//		String pw = dbconn.getPw();	
		Connection conn = new newDbconn().newNewDbconn();

		// DriverManager.getConnection(host, username, pw);

		PreparedStatement preUpdateCustomerGift = null;
		String updateCustomerGift = "UPDATE customers SET gift = null WHERE id = '" + id + "'";
		preUpdateCustomerGift = conn.prepareStatement(updateCustomerGift);

		preUpdateCustomerGift.executeUpdate();

		String deletedGift = getUsersGiftFromRegistry(id, conn);
		conn.close();
		return deletedGift;
	}

	public String getUsersGiftFromRegistry(int id, Connection conn) throws SQLException {

		String dbgifts;

		String getCustomerInfo = "SELECT gifts FROM customers WHERE id = '" + id + "'";
		PreparedStatement preGetCustomerInfo = conn.prepareStatement(getCustomerInfo);
		ResultSet rsgift = preGetCustomerInfo.executeQuery();

		dbgifts = null;

		while (rsgift.next()) {
			dbgifts = rsgift.getString(1);
		}

		return dbgifts;
	}

	public String removeUsersAccount(int id) throws SQLException {

		Connection conn = new newDbconn().newNewDbconn();

		int affectedRows = 0;

		String removeCustomerInfo = "DELETE FROM customers WHERE id = '" + id + "'";
		PreparedStatement preRemoveCustomerInfo = conn.prepareStatement(removeCustomerInfo);
		affectedRows = preRemoveCustomerInfo.executeUpdate();

		String wasUserIdDeleted;

		if (affectedRows != 0) {
			wasUserIdDeleted = id + " was deleted";
		} else {
			wasUserIdDeleted = id + " was not deleted";
		}
		return wasUserIdDeleted;
	}

	public void denyUserAccessToAccount(int id) throws SQLException {
		Connection conn = new newDbconn().newNewDbconn();

		String denyUserAccessToAccount = "UPDATE customers accountstatus = 0 WHERE id = '" + id + "'";
		PreparedStatement predenyUserAccessToAccount = conn.prepareStatement(denyUserAccessToAccount);

		predenyUserAccessToAccount.executeUpdate();

		conn.close();
	}

	public void restoreUserAccessToAccount(int id) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = new newDbconn().newNewDbconn();

		int whatIsAccountStatus;
		String restoreUserAccessToAccount = "UPDATE customers SET accountstatus = 1 WHERE id = '" + id + "'";
		PreparedStatement preRestoreUserAccessToAccount = conn.prepareStatement(restoreUserAccessToAccount);
		preRestoreUserAccessToAccount.executeUpdate();
		String getAccountStatusForUser = "SELECT accountstatus FROM customers WHERE id = '" + id + "'";

		PreparedStatement preGetAccountStatusForUser = conn.prepareStatement(getAccountStatusForUser);

		ResultSet accountStatus = preGetAccountStatusForUser.executeQuery();
		whatIsAccountStatus = 0;
		while (accountStatus.next()) {
			whatIsAccountStatus = accountStatus.getInt(1);
		}

		if (whatIsAccountStatus == 0) {
			System.out
					.println("Account Status not Updated. Try again" + "\nPress any key to return to previous screen");

			sc.next();
			new Admin(sc).restoreAccessToUsersAccount(sc);
		} else {
			System.out.println("ID: " + id + " account status was updated" + "\nPress enter for Main Menu");
			sc.nextLine();

		}

		conn.close();

	}

	public void viewPendingAccounts() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = new newDbconn().newNewDbconn();
		String Name = null;
		String ID = null;
		String userName = null;
		String accountStatus = null;

		String getPendingAccounts = "SELECT id, name, username, accountstatus FROM customers WHERE accountstatus = 0";

		PreparedStatement preGetPendingAccounts = conn.prepareStatement(getPendingAccounts);

		ResultSet pendingAccounts = preGetPendingAccounts.executeQuery();
		// ArrayList<String> pending = new ArrayList<String>();
		AccountsPending row = new AccountsPending();
		while (pendingAccounts.next()) {

			// for (int i = 1; i <= pendingAccounts.; i++) {
			ID = row.setID(pendingAccounts.getString("id"));
			Name = row.setName(pendingAccounts.getString("name"));
			userName = row.setUserName(pendingAccounts.getString("username"));
			accountStatus = row.setAccountStatus(pendingAccounts.getString("accountstatus"));
		}
		conn.close();

		if (accountStatus == null) {
			System.out.println("There are no pending accounts at this time" + "\nPress Enter for Main Menu");
			new Admin(sc).actionOnAccounts(sc);
		} else
			System.out.print("ID: " + ID + " Name: " + Name + " username: " + userName + " Pending Account" + "\n");

		makeSelection();
	}

	private void makeSelection() throws SQLException {

		System.out.println("###########################################" + "\n\tWhat would you like to do now?"
				+ "\n\t1 Main Menu" + "\n\t2 Approve an account" + "\n\t3 LogOut"
				+ "\n###########################################");
		int selection = sc.nextInt();

		switch (selection) {

		case 1:
			new Admin(sc).actionOnAccounts(sc);
			break;
		case 2:
			new Admin(sc).restoreAccessToUsersAccount(sc);
		case 3:
			new App();
			break;
		default:
			System.out.println("Invalid Selection");
		}
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
