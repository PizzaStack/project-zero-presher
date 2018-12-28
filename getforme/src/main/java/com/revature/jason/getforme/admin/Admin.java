package com.revature.jason.getforme.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.jason.getforme.App;
import com.revature.jason.getforme.connections.communictaionsWithDatabase;


public class Admin {
	
	private String UserName;
	private String Pwd;
	
	
	public Admin(Scanner sc) {}
	
	public void actionOnAccounts(Scanner sc) throws SQLException {
		System.out.println(
				  "###########################################"
				+ "\n\tChosse an account option"
				+ "\n###########################################"
				+ "\n\t1 To check if an account exists by id"
				+ "\n\t2 View a users account information by id"
				+ "\n\t3 Deny access to an acounnt by id"
				+ "\n\t4 Delete a users Gift by id"
				+ "\n\t5 To View Pending Accounts"
				+ "\n\t0 Delete an account by id"
				+ "\n\t9 Restore Access to users account by id"
				+ "\n\t6 To log out"
				+ "\n#############################################");
		
		int action = sc.nextInt();
		
		switch (action) {
		
		case 1:
			doesAccountExist(sc);
			break;
		case 2:
			viewUsersAccount(sc);
			break;
		case 3:
			denyAccessToAccount(sc);
			break;
		case 4:
			deleteUsersGifts(sc);
			break;
		case 5:
			viewPendingAccounts(sc);
			break;
		case 0:
			deleteUsersAccount(sc);
			break;
		case 9:
			restoreAccessToUsersAccount(sc);
			break;
		case 6:
			logout();
			break;
			default:
				System.out.println("Invalid Selection");
		}
	}	

	
	private void logout() {
		// TODO Auto-generated method stub
		new App();
		
	}

	public void viewPendingAccounts(Scanner sc) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(
				  "##########################################################"
				+ "\n\tEnter to view pending accounts"
				+ "\n##########################################################");
		
		sc.nextLine();
		
		new communictaionsWithDatabase().viewPendingAccounts();
		
		
//				
//		while(usersInfo.addAll(usersInfo))
//		{
//			
//			System.out.println("Pending Accounts"
//					+ "\nid: " + usersInfo.get(0) + ", name: " + usersInfo.get(1)  + ", username: " + usersInfo.get(2) + ", account status: Pending Approval");
//			
//		} 
	}

	private void doesAccountExist(Scanner sc) throws SQLException {
		
		System.out.println(
				  "##########################################################"
				+ "\n\tEnter the id of the account you wish to view"
				+ "\n\tThen press enter"
				+ "\n##########################################################");
		
		int usersId = sc.nextInt();
		
		int usersInfo = new communictaionsWithDatabase().doesAccountExist(usersId);
		
		if(usersInfo == 0) {
			System.out.println(usersInfo + " ID does not exist");
		}else if (usersInfo == 1) {
			System.out.println( usersInfo + " ID exists in the databse");
		}
		
	}
	
	public void restoreAccessToUsersAccount(Scanner sc) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("Input the Id of the account you wish to give access");
		
		int id = sc.nextInt();
		new communictaionsWithDatabase().restoreUserAccessToAccount(id);
		
	}

	private void denyAccessToAccount(Scanner sc) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("Input the ID of the account to deny access to");
		
		int id = sc.nextInt();
		new communictaionsWithDatabase().denyUserAccessToAccount(id);
		
	}
	
//	private void doesAccountExist(Scanner sc) {
//		System.out.println("Input the ID to check");
//		int ID = sc.nextInt();
//		int isID = new communictaionsWithDatabase().doesAccountExist(ID));
//		
//		if(ID == 0) {
//			System.out.println(ID + " does not exist");
//			actionOnAccounts(sc);
//		}else {
//			System.out.println(ID + " does exist");
//			actionOnAccounts(sc);
//		}
//	}

	private void viewUsersAccount(Scanner sc) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Input the ID of an account");
				
		int id = sc.nextInt();
		ArrayList<String> data = new communictaionsWithDatabase().viewAccounts(id);
		
		System.out.println("The account for " + id + " is  name " + data.get(0) + " gifts" + data.get(1) +" username " + data.get(2));
		
		System.out.println("Press the any key to continue");
		
		sc.next();
		actionOnAccounts(sc);
	}

	public void viewUsersAccount(Scanner sc, int id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUsersAccount(Scanner sc) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Input the id of the account to remove");
		int userId = sc.nextInt();
		String wasUserRemoved = new communictaionsWithDatabase().removeUsersAccount(userId);
		
		System.out.println(wasUserRemoved);
		
	}

	public void deleteUsersGifts(Scanner sc) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println(
				  "...................................................."
				+ "\n\tDo you wish to remove the users gift?"
				+ "\n\t1 to remove the gift"
				+ "\n\t2 to return to previous screen"
				+ "\n....................................................");
		
		int option = sc.nextInt();
		
		switch(option) {
		
		case 1:
			System.out.println("Input users id and press enter.");
			int id = sc.nextInt();			
			String gift = new communictaionsWithDatabase().removeUsersGift(id);
			String newGift = " ";
			if(gift == null) {
				newGift = "No gift in registry";
			}
			System.out.println("The users gift has been removed" + newGift);
			break;
		case 2: 
			
			new Admin(sc).actionOnAccounts(sc);
			break;
			
			default:
				System.out.println("Incorrect option. Please try again");
		}
		
		
	}

	public void denyAUserAccount() {
		// TODO Auto-generated method stub
		
	}

	public void approveUserAccount() {
		// TODO Auto-generated method stub
		
	}

	public void viewUsersAccountInformation() {
		// TODO Auto-generated method stub
		
	}

}
