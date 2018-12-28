package com.revature.jason.getforme.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class newDbconn {
	
	private String username;
	private String host;
	private String pw;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
 
	public newDbconn() {}
	
	public Connection newNewDbconn() throws SQLException {
		 this.username = "afuceoec";
		 this.host = "jdbc:postgresql://echo.db.elephantsql.com:5432/afuceoec";
		 this.pw = "snyOOQuMBiiPHd_6j0-8ezGRuGpx8WbO";
		 Connection conn = DriverManager.getConnection(this.host, this.username, this.pw);
		 return conn;
	}

}
