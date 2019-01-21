package employeeInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONObject;

import com.cliffco.connections.MakeConnection;


public class GetEmployeeInfoFromDatabaseImpl {
	static Connection conn;
	static PreparedStatement ps;

	public JSONObject getEmployeeInfo(String username) {
System.out.println(username + "here");
		
		String fname = null;
		String lname = null;
		String email = null;
		String imbursementStatus = null;
		JSONObject people = new JSONObject();
		EmployeeInfo ei = new EmployeeInfo(fname, lname, email, imbursementStatus);

		try {
			conn = MakeConnection.getConnection();

			ps = conn.prepareStatement ("SELECT employee_fname, employee_lname, employee_email, employee_ibmrs_status FROM employees JOIN employeeimbursementrequests ON employees.employee_id = employeeimbursementrequests.empibmrsid JOIN employeelogin ON employeelogin.employee_login_id\r\n" + 
					"= employees.employee_id WHERE employeelogin.employee_username = ?");
			
			
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				people.put("fname", rs.getString("employee_fname"));
				people.put("lname", rs.getString("employee_lname"));
				people.put("email", rs.getString("employee_email"));
				people.put("ri", rs.getString("employee_ibmrs_status"));
//				ei.setFname(rs.getString("employee_fname"));
//				ei.setLname(rs.getString("employee_lname"));
//				ei.setEmail(rs.getString("employee_email"));
//				ei.setReimbursementStatus(rs.getString("employee_ibmrs_status"));

			}
			conn.close();
			return people;
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
