package com.revature.jason.getforme.control;

public class dbConn {
	private String username;
	private String host;
	private String pw;
	
	public dbConn() {
	 this.username = "afuceoec";
	 this.host = "jdbc:postgresql://echo.db.elephantsql.com:5432/afuceoec";
	 this.pw = "snyOOQuMBiiPHd_6j0-8ezGRuGpx8WbO";
	
	 }
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
}
//	{
//		try {
//		Class.forName("org.postgresql.Driver");//use jdbc to make connections
//		Connection conn = DriverManager.getConnection(host, username, pw);
//	} catch (ClassNotFoundException e) {
//		
//		e.printStackTrace();
//	}
//    //--------------------------------------------------
//    try {
//		Connection connection = DriverManager.getConnection("jdbc:postgresql://echo.db.elephantsql.com:5432/afuceoec", "afuceoec", "snyOOQuMBiiPHd_6j0-8ezGRuGpx8WbO");
//		
//		Statement statement = connection.createStatement();
		//ResultSet resultSet = statement.executeQuery("INSERT INTO pizza values(1, 'Cheese')");//queries go here
		//ResultSet resultSet1 = statement.executeQuery("SELECT * FROM pizza");
		//resultSet to get the values from a database table
// catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
		
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
//	} catch (SQLException e) {
//		
//		e.printStackTrace();
//	}
