package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.Authentication;
import com.model.User;

public class UserDao {
	
	private static UserDao userDao = new UserDao();

	public static UserDao getInstance() {
		return userDao;
	}

	public Authentication getUser(String email) throws SQLException, ClassNotFoundException {
		Authentication authenticate = null;
		Connection connectionToDB = JdbcConnection.getConnection();
		PreparedStatement statement = connectionToDB.prepareStatement(Queries.getUserDetail);
		statement.setString(1, email);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			authenticate = new Authentication(email, result.getString(1));
		}
		return authenticate;
	}

	public boolean createUser(String firstName, String lastName, Date dob, int contact, String email,
			String password, String organization) throws ClassNotFoundException, SQLException {
		Connection connectionToDB = ConnectionToDB.getConnection();
		PreparedStatement statement = connectionToDB.prepareStatement(EmployeeQueries.getQueryTwo());
		statement.setString(1, firstName);
		statement.setString(2, lastName);
		statement.setDate(3, dob);
		statement.setInt(4, contact);
		statement.setString(5, email);
		statement.setString(6, password);
		statement.setString(7, organization);
		int i = statement.executeUpdate();
		if (i > 0) {
			return true;
		}
		return false;
	}

	public List<UserInfoPojo> getUser(int id) throws ClassNotFoundException, SQLException {
		Connection connectionToDB = ConnectionToDB.getConnection();
		List<UserInfoPojo> usersList = new ArrayList<UserInfoPojo>();
		PreparedStatement statement = connectionToDB.prepareStatement(EmployeeQueries.getQueryThree());
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			usersList.add(new UserInfoPojo(result.getString(2), result.getString(3), result.getDate(4),
					result.getInt(5), result.getString(6), result.getString(8)));
		}
		return usersList;
	}

	public boolean updateUser(String firstName, String lastName, Date dateOfBirth, int contactNo, int id)
			throws ClassNotFoundException, SQLException {
		Connection connectionToDB = ConnectionToDB.getConnection();
		PreparedStatement statement = connectionToDB.prepareStatement(EmployeeQueries.getQueryFour());
		statement.setString(1, firstName);
		statement.setString(2, lastName);
		statement.setDate(3, dateOfBirth);
		statement.setInt(4, contactNo);
		statement.setInt(5, id);
		int i = statement.executeUpdate();
		if (i > 0) {
			return true;
		}
		return false;
	}

	public List<FriendInfoPojo> getFriends(int id) throws SQLException, ClassNotFoundException {
		Connection connectionToDB = ConnectionToDB.getConnection();
		List<FriendInfoPojo> friendsList = new ArrayList<FriendInfoPojo>();
		PreparedStatement statement = connectionToDB.prepareStatement(EmployeeQueries.getQueryFive());
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			if (result.getInt(1) != id) {
				friendsList.add(new FriendInfoPojo(result.getInt(1), result.getString(2), result.getString(3)));
			}
		}
		return friendsList;
	}

}