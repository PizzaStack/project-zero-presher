package com.revature.jason.getforme.entity;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.jason.getforme.App;
import com.revature.jason.getforme.connections.communictaionsWithDatabase;

public class ShowUsersAccount {
	Scanner sc = new Scanner(System.in);
	
	public ShowUsersAccount() {}
	
	public void UsersAccount(String UN, String Name, String Gifts) throws SQLException {
		
		if(Gifts == null) {
			System.out.println(
					  "????????????????????????????????????????"
					+ "\n\t" + Name.toUpperCase() + " You have no Gifts"
					+ "\n\tPlease add one now"
					+ "\n???????????????????????????????????????");
			System.out.println(
					  "++++++++++++++++++++++++++++++++++"
					+ "\n\tAdd Your Gift now?"
					+ "\n\t2 to add a gift"
					+ "\n\t9 to log out"
					+ "\n++++++++++++++++++++++++++++++++++");
		}else {
		System.out.println("***********************************"
				+ "\n\tHello " + Name.toUpperCase()
				+ "\n\tYour gift is " + Gifts.toUpperCase()
				+"\n*********************************************");
		
		System.out.println(
				  "++++++++++++++++++++++++++++++++++++++++"
				+ "\n\tWhat would you like to do now?"
				+ "\n\t1 to change the gift"
				+ "\n\t0 to delete your gift"
				+ "\n\t9 to log out"
				+ "\n++++++++++++++++++++++++++++++++++++++++");
		}
		int Selection = sc.nextInt();
		
		switch(Selection) {
			
		case 1:
			updateRegistryGift(UN, Gifts);
			break;
		case 2:
			addRegistryGift(UN);
			break;
		case 0:
			removeRegistryGift(UN, Gifts);
			break;
		case 9:
			logout();
			break;
			
			default:
				System.out.println(
						  "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
						+ "\n\tYou have made an invalid selection"
						+ "\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		}
	}

	private void addRegistryGift(String UN) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("What gift would you like to add");
		String Gift = sc.next();
		
		String[] newGift = new communictaionsWithDatabase().addRegistryGift(UN, Gift);
		
		String Name = newGift[1];
		String giftGift = newGift[0];
		
		new ShowUsersAccount().UsersAccount(UN, Name, giftGift);
		
	}

	private void logout() {
		// TODO Auto-generated method stub
		new Login(sc).askForLogin(sc);
	}

	private void removeRegistryGift(String UN, String Gifts) throws SQLException {
		// TODO Auto-generated method stub
		new communictaionsWithDatabase().removeGiftFromRegistry(UN, Gifts);
	}

	private void updateRegistryGift(String UN, String Gifts) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("What gift would you like to add");
		String Gift = sc.next();
		
		String[] newGift = new communictaionsWithDatabase().updateRegistryGift(UN, Gift, Gifts);
		
		String Name = newGift[1];
		String giftGift = newGift[0];
		
		new ShowUsersAccount().UsersAccount(UN, Name, giftGift);
		
	}
}
