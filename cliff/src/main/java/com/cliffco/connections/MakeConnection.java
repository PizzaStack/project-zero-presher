package com.cliffco.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MakeConnection implements DatabseConnection {
	
	static Connection conn = null;
	
	public static Connection getConnection() {
	
		try {
	          Class.forName("org.postgresql.Driver");
	      } catch (ClassNotFoundException ex) {

	      }
	
	try {
		conn = DriverManager.getConnection(host, username, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return conn;

}
}