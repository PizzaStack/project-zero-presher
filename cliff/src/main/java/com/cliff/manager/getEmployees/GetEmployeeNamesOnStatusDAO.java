package com.cliff.manager.getEmployees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cliffco.connections.MakeConnection;

import employeeInfo.EmployeeInfo;

public class GetEmployeeNamesOnStatusDAO {
	
	//public GetEmployeeNamesOnStatusDAO(String status){}
	
	static Connection conn;
	static PreparedStatement ps;
	
	public JSONArray GetStatus(String status) {
	
		String employeeName = null;
		String fname = null;
		String lname = null;
		String email = null;
		String imbursementStatus = null;

		GetEmployeeNameOnStatus es = new GetEmployeeNameOnStatus(employeeName);
		EmployeeInfo ei = new EmployeeInfo(lname, fname, email, imbursementStatus);
	try {
		JSONArray employeePendingStatusArray = new JSONArray();
		conn = MakeConnection.getConnection();
		
				ps = conn.prepareStatement ("SELECT employee_fname, employee_lname, employee_email, employee_ibmrs_status FROM employees JOIN employeeimbursementrequests "
						+ "ON employees.employee_id = employeeimbursementrequests.empibmrsid "
						+ "WHERE employee_ibmrs_status = ?");
		
		ps.setString(1, status);

		ResultSet rs = ps.executeQuery();
		conn.close();
		
		while (rs.next()) {
			JSONObject employeesWithPendingStatus = new JSONObject();
			ei.setFname(rs.getString("employee_fname"));
			ei.setLname(rs.getString("employee_lname"));
			ei.setEmail(rs.getString("employee_email"));
			ei.setReimbursementStatus(rs.getString("employee_ibmrs_status"));

			employeesWithPendingStatus.put("First_Name", ei.getFname());
			employeesWithPendingStatus.put("Last_Name",  ei.getLname());
			employeesWithPendingStatus.put("Email", ei.getEmail());
			employeesWithPendingStatus.put("RI", ei.getReimbursementStatus());

			employeePendingStatusArray.put(employeesWithPendingStatus);
		}
		return employeePendingStatusArray;
		//employeesWithPendingStatus.put("names", employeesNameOnStatus);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
       
}
}
