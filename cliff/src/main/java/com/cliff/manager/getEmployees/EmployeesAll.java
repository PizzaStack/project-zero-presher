package com.cliff.manager.getEmployees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cliffco.connections.MakeConnection;

import employeeInfo.EmployeeInfo;

public class EmployeesAll {
	
	public EmployeesAll(Connection conn, PreparedStatement ps) {
		// TODO Auto-generated constructor stub
	}

	public JSONArray EmployeesAll(Connection conn, PreparedStatement ps) {

	String fname = null;
	String lname = null;
	String email = null;
	String imbursementStatus = null;

	EmployeeInfo ei = new EmployeeInfo(fname, lname, email, imbursementStatus);
	try {
		JSONArray employeesArray = new JSONArray();
		conn = MakeConnection.getConnection();

		ps = conn.prepareStatement("SELECT * FROM employees "
				+ "LEFT JOIN employeeimbursementrequests ON employees.employee_reimbursement_status "
				+ "= employeeimbursementrequests.employee_ibmrs_id");

		ResultSet rs = ps.executeQuery();
		conn.close();
		while (rs.next()) {
			JSONObject employeess = new JSONObject();
			ei.setFname(rs.getString("employee_fname"));
			ei.setLname(rs.getString("employee_lname"));
			ei.setEmail(rs.getString("employee_email"));
			ei.setReimbursementStatus(rs.getString("employee_ibmrs_status"));

			employeess.put("First_Name", ei.getFname());
			employeess.put("Last_Name",  ei.getLname());
			employeess.put("Email", ei.getEmail());
			employeess.put("RI", ei.getReimbursementStatus());

			employeesArray.put(employeess);
		}
		
		return employeesArray;
//			employeess.put("lastName", employees.get(1));
//			employeess.put("Email", employees.get(2));
//			employeess.put("status", employees.get(3));
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}
}
