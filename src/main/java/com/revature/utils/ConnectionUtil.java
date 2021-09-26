package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	// return a Connection object to connect to the database
	
	public static Connection getConnection() throws SQLException {
		
		// register the PostgreSQL driver
		try {
			// searches for the driver that's marked as a dependency
			Class.forName("org.postgresql.Driver"); 
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// return the database connection object
		return DriverManager.getConnection(System.getenv("URL"), System.getenv("USERNAME"), System.getenv("PASSWORD"));
	}
}
