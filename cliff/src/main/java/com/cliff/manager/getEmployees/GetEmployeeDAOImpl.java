package com.cliff.manager.getEmployees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONObject;

import com.cliffco.connections.MakeConnection;

public class GetEmployeeDAOImpl {

	static Connection conn;
	static PreparedStatement ps;

	public JSONObject employee(String selectedEmployee) {
System.out.println("Here I am ");
		JSONObject employee = new JSONObject();
		try {

			conn = MakeConnection.getConnection();

			ps = conn.prepareStatement("SELECT * FROM employees "
					+ "LEFT JOIN employeeimbursementrequests ON employees.employee_reimbursement_status "
					+ "= employeeimbursementrequests.employee_ibmrs_id WHERE employee_fname = ?");

			ps.setString(1, selectedEmployee);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employee.put("First_Name", rs.getString("employee_fname"));
				employee.put("Last_Name", rs.getString("employee_lname"));
				employee.put("Email", rs.getString("employee_email"));
				employee.put("RI", rs.getString("employee_ibmrs_status"));
			}
			conn.close();

			return employee;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
