package com.cliff.manager.getEmployees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.cliffco.connections.MakeConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import employeeInfo.EmployeeInfo;

public class GetEmployeeData {
	
	public GetEmployeeData() {}
	
	static Connection conn;
	static PreparedStatement ps;
	
	public JSONObject employees(){
		
		String fname = null;
		String lname = null;
		String email = null;
		String imbursementStatus = null;
		
		JSONObject employeess = new JSONObject();
		EmployeeInfo ei = new EmployeeInfo(fname, lname, email, imbursementStatus);
		List<String> employees = new ArrayList<String>();
		try {
			conn = MakeConnection.getConnection();

			ps = conn.prepareStatement ("SELECT * FROM employees " + 
					"LEFT JOIN employeeimbursementrequests ON employees.employee_reimbursement_status "
					+ "= employeeimbursementrequests.employee_ibmrs_id");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				 ei.setFname(rs.getString("employee_fname"));
				
				ei.setLname(rs.getString("employee_lname"));
				
				ei.setEmail(rs.getString("employee_email"));
				
				ei.setReimbursementStatus(rs.getString("employee_ibmrs_status"));
				
//				String firstName = employeess.put("first name", ei.getFname()).toString();
//				String lastName = employeess.put("last name", ei.getLname()).toString();
//				String Email = employeess.put("email", ei.getEmail()).toString();
//				String reimbursement = employeess.put("ri", ei.getReimbursementStatus()).toString();
				
				employeess.put("firstName", employees.add(ei.getFname()));
				employeess.put("lastName", employees.add(ei.getLname()));
				employeess.put("Email", employees.add(ei.getEmail()));
				employeess.put("status", employees.add(ei.getReimbursementStatus()));
				
				
			}
			
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//employeess.put("firstName", employees.)
		//String jsonFromJavaArrayList = gsonBuilder.toJson(employees);
		System.out.println(employeess.get(fname));
		return employeess;
		
	}

}
