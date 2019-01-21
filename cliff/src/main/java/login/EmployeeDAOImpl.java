package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cliffco.connections.MakeConnection;



public class EmployeeDAOImpl implements EmployeeLoginDAO {

	static Connection conn;
	static PreparedStatement ps;

	public Employee getEmployee(String userName, String password) {

		Employee em = new Employee(null, null);
				
		try {
			conn = MakeConnection.getConnection();
		
			ps = conn.prepareStatement("SELECT * FROM employeelogin WHERE employee_username = ? AND employee_password = ?");
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				  em.setUserName(rs.getString("employee_username"));
			      em.setPassword(rs.getString("employee_password"));
			      
			}
			conn.close();
			if(userName.equals(em.getUserName()) && password.equals(em.getPassword())) {
				return em;
			}
			
	}catch(Exception e)	{
		e.printStackTrace();
	}
		
		return null;
	}
}
