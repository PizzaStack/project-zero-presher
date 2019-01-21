package com.cliff.manager.getEmployees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cliffco.connections.MakeConnection;

public class UpdateStatusDAOImpl {

	static Connection conn;
	static PreparedStatement ps;
	int id = 0;
	
	public String status(String statusUpdate, String Name) {
		try
		{
			conn = MakeConnection.getConnection();
			
			ps = conn.prepareStatement("SELECT employee_id FROM employees WHERE employee_fname = ?");
			
			ps.setString(1, Name);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt("employee_id");
			}
			
//			
			ps = conn.prepareStatement("UPDATE employeeimbursementrequests SET employee_ibmrs_status = ? " + 
					"FROM employees WHERE employeeimbursementrequests.empibmrsid = ?");
			
			ps.setString(1, statusUpdate);
			ps.setLong(2, id);
			
			ps.executeUpdate();
		}catch(
		Exception e)
		{

		}
		return null;
	
	}
}