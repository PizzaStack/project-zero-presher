package com.cliff.manager.getEmployees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cliffco.connections.MakeConnection;

public class GetManagersNameImpl implements GetManagersNameDAO {
		static Connection conn;
		static PreparedStatement ps;

		@Override
		public ManagersInfo getManagerInfo(String username) {
			String name = null;
			
			
			ManagersInfo mi = new ManagersInfo(name);

			try {
				conn = MakeConnection.getConnection();

				ps = conn.prepareStatement ("SELECT manager_username FROM managerelogin " + 
						"RIGHT JOIN employees ON employeelogin.emploginid = employees.employee_id WHERE employee_username = ?");
				
				ps.setString(1, username);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					mi.setName(rs.getString("employee_fname"));
				}
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mi;
		}
}
		
