package com.simplilearn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private Connection connection;


	
	
	public DBConnection() {
		// STEP 1: Register driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// STEP 2: Gets connection object
			this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/simplilearn", "root", "password");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public void closeConnection() {
		if(this.connection!=null) {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
