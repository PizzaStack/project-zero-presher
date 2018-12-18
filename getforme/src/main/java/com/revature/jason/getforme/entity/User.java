package com.revature.jason.getforme.entity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User{
	
	//private String UserType;
    private String Name;
    private Integer ID = 1;
    private String Address;
    private String Phone;
    private String RegisteryName;
    private String UserName;
    private String UserPwd;
    private Scanner sc;
    
   // Scanner sco = new Scanner((Readable) System.out);
    
    public User() throws FileNotFoundException{
    	
  
		System.out.println(
				"Are you a Current Member?"
				+ "\n---------------------------"
				+ "\nEnter 1 for New Member"
				+ "\nEnter 2 for Current Member."
				+ "\n---------------------------");
		sc = new Scanner(System.in);
		int userType = sc.nextInt();
		switch(userType) {
		case 1:
			isUserANewUser();
			break;
		case 2:
			isUserACurrentUser();
			break;
		default:
			System.out.println("That is not a valid value");
		}
		
		// TODO Auto-generated method stub
		
		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	private Integer Account = 1234567890;
    public Integer getAccount() {
		return Account;
	}

	public void setAccount(Integer account) {
		Account = account;
	}
	
//	public String getAddress() {
//		return Address;
//	}
//
//	public void setAddress(String address) {
//		Address = address;
//	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getRegisteryName() {
		return RegisteryName;
	}

	public void setRegisteryName(String registeryName) {
		RegisteryName = registeryName;
	}

	public void addGiftToRegistery() {
		// TODO Auto-generated method stub
		
	}

	public void loginToAccount() throws FileNotFoundException {
		// TODO Auto-generated method stub
		new Login();
	}

	public void allowMultipleUsersToOneAccount() {
		// TODO Auto-generated method stub
		
	}

	public void transferGiftsBetweenAccounts() {
		// TODO Auto-generated method stub
		
	}

	public void cannotAddAnEmptyGiftToTheRegistery() {
		// TODO Auto-generated method stub
		
	}

	public void cannotDeleteAGiftNotInTheAccount() {
		// TODO Auto-generated method stub
		
	}	

	public void giveAccountAName() {
		// TODO Auto-generated method stub
		
	}

	public void isUserANewUser() {
		// TODO Auto-generated method stub
		
		System.out.println("What is your name?");
		this.Name = sc.next();
		
//		System.out.println("What is your address?");
//		
//				this.Address = sc.next(Address);			
			
		System.out.println("What is your phone number?");
		this.Phone = sc.next();
		
		System.out.println("Give your registry a name");
		this.RegisteryName = sc.next();
		sc.nextLine();
		System.out.println("Choose your username");
		this.UserName = sc.next();
		File username = new File("userName.txt");
		FileWriter un = null;
		BufferedWriter brUN = null;
		String dataUserName = UserName;
		try {
			un = new FileWriter(username, true);
			brUN = new BufferedWriter(un);
			brUN.write(dataUserName);
			brUN.close();
			un.close();
		}catch(Exception e) {
			e.getMessage();
		}
		System.out.println("Provide a Password");
		sc.nextLine();
		File password = new File("password.txt");
		sc.nextLine();
		FileWriter pw = null;
		BufferedWriter brPW = null;
		String dataPassword = UserPwd;
		try {
			pw = new FileWriter(password, true);
			brPW = new BufferedWriter(pw);
			brPW.write(dataPassword);
			brPW.close();
			pw.close();
		}catch(Exception e) {
			e.getMessage();
		}
		File file = new File("Accounts.txt");
		FileWriter fr = null;
		BufferedWriter br = null;
		String dataNewLine = "Name: " + Name + System.lineSeparator() + "Phone: " + Phone + System.lineSeparator() + "Address: " + Address + System.lineSeparator()
		+ "RegisteryName: " + RegisteryName + System.lineSeparator() + "User Name: " + UserName + System.lineSeparator();
//		String Address = Address +System.lineSeparator();
//		String Phone = Phone + System.lineSeparator();
//		String RegisteryName = RegisteryName + System.lineSeparator();
//		String UserName = UserName + System.lineSeparator();
		try {
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			br.write(dataNewLine);
//			BufferedOutputStream BOS = new BufferedOutputStream(new FileOutputStream("output.txt"));
//			BOS.write("Users Name".getBytes());
//			BOS.write(Name.getBytes());
//			BOS.write(System.lineSeparator().getBytes());
//			BOS.write("Users Address".getBytes(Address));
//			BOS.write(System.lineSeparator().getBytes());
//			BOS.write("Phone Number".getBytes(Phone));
//			BOS.write(System.lineSeparator().getBytes());
//			BOS.write("Users Registery Name".getBytes(RegisteryName));
//			BOS.write(System.lineSeparator().getBytes());
//			BOS.write("User Name".getBytes(UserName));
//			BOS.write(System.lineSeparator().getBytes());
//			System.out.print("Users Name: " + Name + "Users Address: " + Address + "Users Phone: " + Phone + "Users Registery Name: " 
//					+ RegisteryName + "User Name: " + UserName );			
			br.close();
			fr.close();
			System.out.println("File Saved Successfully");
			isUserACurrentUser();
			//PrintWriter pw = new PrintWriter(BOS);
		}catch (IOException e){
			e.printStackTrace();
			System.out.println("File did not save");
		}
		}
	
	
	public void isUserACurrentUser() throws FileNotFoundException {
		System.out.println("Login");
		Login login = new Login();
	}
}