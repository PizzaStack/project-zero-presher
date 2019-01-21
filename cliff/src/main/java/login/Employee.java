package login;

public class Employee {
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public String setUserName(String userName) {
		return this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		return this.password = password;
	}
	
	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", password=" + password + "]";
	}
	public Employee(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


}
