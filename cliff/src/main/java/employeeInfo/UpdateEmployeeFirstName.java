package employeeInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONObject;

import com.cliffco.connections.MakeConnection;

public class UpdateEmployeeFirstName {
	
	static Connection conn;
	static PreparedStatement ps;
	int id = 0;
	String employeeNewName = null;
	
	public  void updateEmployeefname(String username, String fname) {
		try
		{
			System.out.println(fname + "databse name");
			conn = MakeConnection.getConnection();
			
			ps = conn.prepareStatement("SELECT employee_id " + 
					"FROM employees RIGHT JOIN employeelogin ON employees.employee_id = employeelogin.employee_login_id WHERE employee_username = ?");
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 id = rs.getInt("employee_id");
			}
			System.out.println(id);
			
			ps = conn.prepareStatement("UPDATE employees SET employee_fname = ? WHERE employee_id = ?");
			
			ps.setString(1, fname);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
//			ps = conn.prepareStatement("SELECT * FROM employees LEFT JOIN employeeimbursementrequests ON employees.employee_reimbursement_status = employeeimbursementrequests.employee_ibmrs_id WHERE employee_id = ?");			
//			ps.setInt(1, id);
//			
//			ResultSet rss = ps.executeQuery();
//			JSONObject obj = new JSONObject();
//			while(rs.next()) {
//				
//				obj.put("First_Name", rss.getString("employee_fname"));
//				obj.put("Last_Name", rss.getString("employee_lname"));
//				obj.put("Email", rss.getString("employee_email"));
//				obj.put("RI", rss.getString("employee_reimbursement_status"));
//			}
//			System.out.println(obj + "new name");
//			return obj;
		}catch(
		Exception e)
		{

		}
		
		
		
	}

}
