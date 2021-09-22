package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Menu;
import com.revature.utils.ConnectionUtil;

public class Launcher {

	public static void main(String[] args) {

		System.out.println("Attempting to connect to database ...");
		// attempt to connect to the database
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("Connection successful!");
		}
		catch (SQLException e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		}

		Menu menu = new Menu();
		
		menu.displayMenu();
	}

}
