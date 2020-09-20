package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.User;

public class UserDao {
	DatabaseConnection connection = new DatabaseConnection(); 
	//private int countID = 1; 
	private String type = "not admin"; 
	
	private static final String INSERT_USER = "INSERT INTO User "
			+ "(user_name, user_email , user_password, user_dob, "
			+ "user_phone, user_type) VALUES (?,?,?,?,?,?);";
	
	private static final String SELECT_USER_BY_ID = "select * from User where user_name =?";
	//private static final String SELECT_ALL_USERS = "Select * from User"; 
	
	
	Connection con = connection.loadDB();
	
	//insert record in database
	public void insertUser(User user ) {
		try {
			PreparedStatement prep = con.prepareStatement(INSERT_USER); 
			prep.setString(1, user.getName()); 
			prep.setString(2, user.getEmail());
			prep.setString(3, user.getPass());
			prep.setString(4, user.getDob());
			prep.setString(5, user.getPhone());
			prep.setString(6, type );
			
			prep.executeUpdate(); 
		}
		catch(Exception e) {
			e.printStackTrace();
			//System.out.println("Error in inserting user in database.USER DAO");
		}
	}
	//select user by ib
	public User selectUser(int id) {
		User user = new User(); 
		try {
			PreparedStatement prep  = con.prepareStatement(SELECT_USER_BY_ID); 
			prep.setInt(1,id);
			ResultSet result = prep.executeQuery();
			result.next(); 
			
			String name = result.getString("name"); 
			user.setName(name);
			
			
		}
		catch(Exception e) {
			
		}
		return user; 
	}
}
