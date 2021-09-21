package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class Launcher {

	public static void main(String[] args) {

		// attempt to connect to the database
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("Connection to database successful!");
		}
		catch (SQLException e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		}

	}

}
