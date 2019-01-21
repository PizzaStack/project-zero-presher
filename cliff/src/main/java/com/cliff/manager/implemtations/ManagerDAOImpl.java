package com.cliff.manager.implemtations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cliff.manager.getEmployees.Managers;
import com.cliff.manager.interfaces.ManagerLoginDAO;
import com.cliffco.connections.MakeConnection;

import login.Employee;

public class ManagerDAOImpl implements ManagerLoginDAO {
	
	static Connection conn;
	static PreparedStatement ps;

	@Override
	public Managers getManagers(String userName, String password) {
		

			Managers em = new Managers(null, null);
					
			try {
				conn = MakeConnection.getConnection();
			
				ps = conn.prepareStatement("SELECT * FROM managerlogin WHERE manager_username = ? AND manager_password = ?");
				ps.setString(1, userName);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					  em.setUserName(rs.getString("manager_username"));
				      em.setPassword(rs.getString("manager_password"));
				      
				}
				conn.close();
				if(userName.equals(em.getUserName()) && password.equals(em.getPassword())) {
					return em;
				}
				
		}catch(Exception e)	{
			e.printStackTrace();
		}
		
			return null;
		}
	

	}


