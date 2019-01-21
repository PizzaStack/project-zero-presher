package employeeInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cliffco.connections.MakeConnection;

public class AddReimbursementImpl {

	static Connection conn;
	static PreparedStatement ps;
	int id = 0;

	public void addReimbursement(String username, String type) {
		try {
			conn = MakeConnection.getConnection();

			ps = conn.prepareStatement("SELECT employee_id "
					+ "FROM employees RIGHT JOIN employeelogin ON employees.employee_id = employeelogin.employee_login_id WHERE employee_username = ?");
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			rs.next();
			id = rs.getInt("employee_id");

			ps = conn.prepareStatement("Insert into employeeimbursementrequests "
					+ "(empibmrsid, employee_ibmrs_status, employee_ibmrs_type) values (?, PENDING, ?)");

			ps.setInt(1, id);
			ps.setString(2, type);

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {

		}
	}

}
