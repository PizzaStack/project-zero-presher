package com.revature.jason.getforme.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConn {
	{
		try {
		Class.forName("org.postgresql.Driver");//use jdbc to make connections
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
    //--------------------------------------------------
    try {
		Connection connection = DriverManager.getConnection("jdbc:postgresql://echo.db.elephantsql.com:5432/afuceoec", "afuceoec", "snyOOQuMBiiPHd_6j0-8ezGRuGpx8WbO");
		
		Statement statement = connection.createStatement();
		//ResultSet resultSet = statement.executeQuery("INSERT INTO pizza values(1, 'Cheese')");//queries go here
		//ResultSet resultSet1 = statement.executeQuery("SELECT * FROM pizza");
		//resultSet to get the values from a database table
		
//		while(resultSet.next()) {
//			System.out.println(resultSet.getString("type"));
//			System.out.println(resultSet.getInt("id"));
//		}
//		while (resultSet1.next()){
//			System.out.println(resultSet1.getInt("id"));
//			System.out.println(resultSet1.getString("type"));
//		}
//		resultSet1.close();
//		statement.close();
//		connection.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
}

