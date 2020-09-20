package com.controller;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.DatabaseConnection;



public class Validation {
	static DatabaseConnection db = new DatabaseConnection(); 
	static Connection con = db.loadDB();
	
	 public static boolean checkUser(String name,String pass) 
	    {
	        boolean st =false;
	        try {

	    
	            PreparedStatement ps = con.prepareStatement("select * from User where user_name=? and user_password=?");
	            ps.setString(1, name);
	            ps.setString(2, pass);
	            ResultSet rs =ps.executeQuery();
	            st = rs.next();

	        }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
	        return st;                 
	    }   
	 public static boolean checkValidRegister(String name, String email , String password, String dob, String phone) {
		 return true; 
	 }
	
}
