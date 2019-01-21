package com.cliff.manager.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cliffco.connections.MakeConnection;

import employeeInfo.EmployeeInfo;

/**
 * Servlet implementation class GetAllEmployees
 */
public class GetAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Connection conn;
	static PreparedStatement ps;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = null;
		String lname = null;
		String email = null;
		String imbursementStatus = null;
		JSONArray employeesArray = new JSONArray();
		EmployeeInfo ei = new EmployeeInfo(fname, lname, email, imbursementStatus);

		try {
			
			conn = MakeConnection.getConnection();

			ps = conn.prepareStatement("SELECT * FROM employees "
					+ "LEFT JOIN employeeimbursementrequests ON employees.employee_reimbursement_status "
					+ "= employeeimbursementrequests.employee_ibmrs_id");

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				JSONObject employeess = new JSONObject();
				ei.setFname(rs.getString("employee_fname"));
				ei.setLname(rs.getString("employee_lname"));
				ei.setEmail(rs.getString("employee_email"));
				ei.setReimbursementStatus(rs.getString("employee_ibmrs_status"));

				employeess.put("First_Name", ei.getFname());
				employeess.put("Last_Name", ei.getLname());
				employeess.put("Email", ei.getEmail());
				employeess.put("RI", ei.getReimbursementStatus());

				employeesArray.put(employeess);
			}
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().print(employeesArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);

	}

}
