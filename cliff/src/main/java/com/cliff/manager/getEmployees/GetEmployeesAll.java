package com.cliff.manager.getEmployees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cliffco.connections.MakeConnection;

import employeeInfo.EmployeeInfo;

public class GetEmployeesAll {
	
	static Connection conn;
	static PreparedStatement ps;

	public EmployeesAll getEmployees() {
		
		EmployeesAll ea = new EmployeesAll(conn, ps);
		return ea;
				
	}
}
