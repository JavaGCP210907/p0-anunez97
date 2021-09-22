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
		
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=pokedex_p0";
		String username = "postgres";
		String password = "t4coss1212";
		
		// return the database connection object
		return DriverManager.getConnection(url, username, password);
	}
}
