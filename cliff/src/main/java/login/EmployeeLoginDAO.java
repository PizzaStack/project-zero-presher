package login;

public interface EmployeeLoginDAO{
	
	//public int insertEmployee(Employee em);
	public Employee getEmployee(String userName,String password);

}
