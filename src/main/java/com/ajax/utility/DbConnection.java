package com.ajax.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	final static String DB_USER= "root";
	final static String DB_PASS="Nikhil@79";
	final static String DB_URL="jdbc:mysql://localhost:3306/demoapp";
	public static Connection getConnection() {
		Connection con =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}
}	
