package com.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Employee;

public class Dao {
	public void AddEmployeeDetail(String firstName, String lastName,
			String email, int age) {
		String query = "INSERT INTO employee_details(first_name, last_name, email, age) VALUES (?, ?, ?, ?);";
		try (
				// In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
				Connection connection = getConnection();

				// Allocate a 'Statement' object in the Connection
				PreparedStatement stmt = connection.prepareStatement(query);) {
			try{
				connection.setAutoCommit(false);
				
				stmt.setString(1, firstName);
				stmt.setString(2, lastName);
				stmt.setString(3, email);
				stmt.setInt(4, age);
				
				stmt.executeUpdate();
				connection.commit();
			} catch(SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Employee searchEmployee(String firstName, String lastName) {
		Employee employee = null;
		String query = "SELECT first_name, last_name, email, age FROM employee_details WHERE first_name = ? AND last_name = ?;";
		try (
					// In MySQL: "jdbc:mysql://hostname:port/databaseName", "username",
					// "password"
					Connection connection = getConnection();

						// Allocate a 'Statement' object in the Connection
						PreparedStatement stmt = connection.prepareStatement(query);) {
					stmt.setString(1, firstName);
					stmt.setString(2, lastName);
					System.out.println("here");
					ResultSet resultset = stmt.executeQuery();

					// Move the cursor to the next row, return false if no more row
					while (resultset.next()) {
						employee = new Employee(
								resultset.getString("first_name"), resultset
										.getString("last_name"), resultset
										.getString("email"), resultset.getInt("age"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return employee;
	}
	
	public void updateEmployeeDetail(String firstName, String lastName,
			String email, int age) {
		String query = "UPDATE employee_details SET first_name = ?, last_name = ?, age = ? WHERE email = ?;";
		try (
				// In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
				Connection connection = getConnection();

				// Allocate a 'Statement' object in the Connection
				PreparedStatement stmt = connection.prepareStatement(query);) {
			try{
				connection.setAutoCommit(false);
				
				stmt.setString(1, firstName);
				stmt.setString(2, lastName);
				stmt.setInt(3, age);
				stmt.setString(4, email);
				
				stmt.executeUpdate();
				connection.commit();
			} catch(SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public List<Employee> showAllEmployee() {
		List<Employee> employees = new ArrayList<Employee>();
		String query = "SELECT first_name, last_name, email, age FROM employee_details;";
		
		try (
		// In MySQL: "jdbc:mysql://hostname:port/databaseName", "username",
		// "password"
		Connection connection = getConnection();

				// Allocate a 'Statement' object in the Connection
				PreparedStatement stmt = connection.prepareStatement(query);) {

			ResultSet resultset = stmt.executeQuery();

			// Move the cursor to the next row, return false if no more row
			while (resultset.next()) {
				employees.add(new Employee(
						resultset.getString("first_name"), resultset
								.getString("last_name"), resultset
								.getString("email"), resultset.getInt("age")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String host = "jdbc:mysql://localhost:3306/";
			String dbName = "employee";
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
