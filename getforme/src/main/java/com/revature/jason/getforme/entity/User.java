package com.revature.jason.getforme.entity;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.revature.jason.getforme.connections.communictaionsWithDatabase;

public class User{
	
	//private String UserType;
    private String Name;
    private Integer ID = 1;
    private String Address;
    private String Phone;
    private String RegistryName;
    private String UserName;
    private String UserPwd;
    //private Scanner sc;
    private Integer Account;
    private String gifts;
    
   // Scanner sco = new Scanner((Readable) System.out);
    
    
    public User(){}
    	
  
//		System.out.println(
//				"Are you a Current Member?"
//				+ "\n---------------------------"
//				+ "\nEnter 1 for New Member"
//				+ "\nEnter 2 for Current Member."
//				+ "\n---------------------------");
//		sc = new Scanner(System.in);
//		int userType = sc.nextInt();
//		switch(userType) {
//		case 1:
//			isUserANewUser();
//			break;
//		case 2:
//			isUserACurrentUser();
//			break;
//		default:
//			System.out.println("That is not a valid value");
//		}
		
		// TODO Auto-generated method stub
		
		
	

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
	
	
    public Integer getAccount() {
		return Account;
	}

	public void setAccount(Integer account) {
		Account = account;
	}
	
	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getRegisteryName() {
		return RegistryName;
	}

	public void setRegisteryName(String registeryName) {
		RegistryName = registeryName;
	}
	
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPwd() {
		return UserPwd;
	}

	public void setUserPwd(String userPwd) {
		UserPwd = userPwd;
	}

	public void setID(Integer iD) {
		ID = iD;
	}


	public void addGiftToRegistery() {
		// TODO Auto-generated method stub
		
	}

	
	public String getGifts() {
		return gifts;
	}

	public void setGifts(String gifts) {
		this.gifts = gifts;
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

	public Integer randomAccountNumber() {
		Scanner sc = new Scanner(System.in);
		 int max = 100;
		 int min = 5;
		 Random rn = new Random();
		 this.Account = rn.nextInt( max - min + 1) + min;
		 
		return Account;
	}

	public void userIsANewUser(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------"
				+ "\nPlease Enter Your Account Information"
				+ "\n-------------------------------------------");
		do {
		System.out.println("What is your first name?");
			while(!sc.hasNext()){
				System.out.println("You have not input your name");
				sc.next();
			}
			//Name = sc.next();
		}while(sc.hasNext());
			Name = sc.next();
		
		System.out.println("What is your city?");	
			if(sc.next() == null) 
				System.out.println("You have not input a City please try again");
			else
				Address = sc.next();			
			
		System.out.println("What is your phone number?");
			if(sc.next() == null) 
				System.out.println("You have not input a Phone Number please try again");
			else
				Phone = sc.next();
		
		System.out.println("Give your registry a two word name");
			if(sc.next() == null) 
				System.out.println("You have not given your Registry a two word name try again");
			else
				RegistryName = sc.next() + sc.nextLine();
				
		System.out.println("What gift would you like to add to the registry");
			if(sc.next() == null) 
				System.out.println("You have not add a Gift please try again");
			else
				gifts = sc.next();
			
		System.out.println("Choose your username");
			if(sc.next() == null) 
				System.out.println("You have not input a User Name please try again");
			else
				UserName = sc.next();
				
		System.out.println("Choose a password");
			if(sc.next() == null) 
				System.out.println("You have not input a Password please try again");
			else
		 		UserPwd = sc.next();		
		 
		randomAccountNumber();	 
		 loginInToRegistry();
	}
	
	public void loginInToRegistry() {
	    
	    communictaionsWithDatabase getUser = new communictaionsWithDatabase();
	    try {
			getUser.insertNewUserToDatabase(this.Address, this.gifts, this.Name, this.Account, 
					this.RegistryName, this.Phone, this.UserName, this.UserPwd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//		File username = new File("userName.txt");
//		FileWriter un = null;
//		BufferedWriter brUN = null;
//		String dataUserName = UserName;
//		try {
//			un = new FileWriter(username, true);
//			brUN = new BufferedWriter(un);
//			brUN.write(dataUserName);
//			brUN.close();
//			un.close();
//		}catch(Exception e) {
//			e.getMessage();
//		}
//		System.out.println("Provide a Password");
//		sc.nextLine();
//		File password = new File("password.txt");
//		sc.nextLine();
//		FileWriter pw = null;
//		BufferedWriter brPW = null;
//		String dataPassword = UserPwd;
//		try {
//			pw = new FileWriter(password, true);
//			brPW = new BufferedWriter(pw);
//			brPW.write(dataPassword);
//			brPW.close();
//			pw.close();
//		}catch(Exception e) {
//			e.getMessage();
//		}
//		File file = new File("Accounts.txt");
//		FileWriter fr = null;
//		BufferedWriter br = null;
//		String dataNewLine = "Name: " + Name + System.lineSeparator() + "Phone: " + Phone + System.lineSeparator() + "Address: " + Address + System.lineSeparator()
//		+ "RegisteryName: " + RegisteryName + System.lineSeparator() + "User Name: " + UserName + System.lineSeparator();
//		String Address = Address +System.lineSeparator();
//		String Phone = Phone + System.lineSeparator();
//		String RegisteryName = RegisteryName + System.lineSeparator();
//		String UserName = UserName + System.lineSeparator();
//		try {
//			fr = new FileWriter(file, true);
//			br = new BufferedWriter(fr);
//			br.write(dataNewLine);
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
//			br.close();
//			fr.close();
//			System.out.println("File Saved Successfully");
//			isUserACurrentUser();
//			//PrintWriter pw = new PrintWriter(BOS);
//		}catch (IOException e){
//			e.printStackTrace();
//			System.out.println("File did not save");
//		}
//		}
	
	
	
	
}