package com.revature.jason.getforme;

import com.revature.jason.getforme.entity.Admin;
import com.revature.jason.getforme.entity.User;

import java.io.FileNotFoundException;

import org.junit.*;


public class AppTest{
    
	@Test
	public void canUserLogin() throws FileNotFoundException {
		User user = new User();
		user.loginToAccount();
	}
//	
//	@Test
//	public void canAdminLoginToViewUsersAccounts() {
//		Admin admin = new Admin();
//		admin.viewUsersAccounts();
//	}
//	
//	@Test
//	public void canUserAddGiftsToTheRegistery() {
//		User user = new User();
//		user.addGiftToRegistery();
//	}
//	
//	@Test
//	public void canUserLoginToAccount() {
//		User user = new User();
//		user.loginToAccount();
//	}
//	
//	@Test
//	public void canAdminDeleteUserAccount() {
//		Admin admin = new Admin();
//		admin.deleteUsersAccount();
//	}
//	
//	@Test
//	public void canAdminDeleteUsersGifts() {
//		Admin admin = new Admin();
//		admin.deleteUsersGifts();
//	}
//	
//	@Test
//	public void canUsersAccountsHaveMultipleUsers() {
//		User user = new User();
//		user.allowMultipleUsersToOneAccount();
//	}
//	
//	@Test
//	public void canAdminDenyAUserAnAccount() {
//		Admin admin = new Admin();
//		admin.denyAUserAccount();
//	}
//	
//	@Test
//	public void canAdminApproveUserAccount() {
//		Admin admin = new Admin();
//		admin.approveUserAccount();
//	}
//	
//	@Test 
//	public void canAdminViewUsersAccountInformation() {
//		Admin admin = new Admin();
//		admin.viewUsersAccountInformation();
//	}
//	
//	@Test
//	public void canUsersTransferGiftsBetweenAccounts() {
//		User user = new User();
//		user.transferGiftsBetweenAccounts();
//	}
//	
//	@Test
//	public void canUserAddAnEmptyGiftToTheRegistery() {
//		User user = new User();
//		user.cannotAddAnEmptyGiftToTheRegistery();
//	}
//	
//	@Test
//	public void canUserDeleteAGiftThatIsNotInTheAccount() {
//		User user = new User();
//		user.cannotDeleteAGiftNotInTheAccount();
//	}
//	
//	@Test
//	public void canUserNameAccount() {
//		User user = new User();
//		user.giveAccountAName();
//	}
//	
//	@Test 
//	public void isUserANewUser() {
//		User user = new User();
//		user.isUserANewUser();
//	}
//
//}
//
//
}