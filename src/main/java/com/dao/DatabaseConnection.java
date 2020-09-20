package com.dao;
import java.sql.*; 

public class DatabaseConnection {
	Connection con; 
	Statement st; 
	ResultSet rs; 
	
	public String url = "jdbc:mysql://localhost:3306/";
	public String dbName = "QuizApp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String driver = "com.mysql.jdbc.Driver";
	public String userName = "root";
	public String password = "Luongbong95";

	public Connection loadDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Connected to the database");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
