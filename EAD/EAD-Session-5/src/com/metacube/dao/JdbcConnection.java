package com.metacube.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author RAHUL SHARMA
 * Creation DATE: 02/08/2018
 */
public class JdbcConnection {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String host = "jdbc:mysql://localhost:3306/";
			String dbName = "web";
			String url = host + dbName;
			connection = DriverManager.getConnection(url, "root", "12345");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(2);
		}
		return connection;
	}
}
