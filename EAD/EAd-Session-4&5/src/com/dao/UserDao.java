package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Authentication;
import com.model.User;
import com.model.UserFriend;

public class UserDao {

	private static UserDao userDao = new UserDao();

	public static UserDao getInstance() {
		return userDao;
	}

	public Authentication authenticate(String email) throws SQLException,
			ClassNotFoundException {
		Authentication authenticate = null;
		User user = getUser(email);
		authenticate = new Authentication(user.getId(), user.getPassword());
		return authenticate;
	}

	public User getUser(String email) throws SQLException,
			ClassNotFoundException {
		User user = null;
		try (Connection connectionToDB = JdbcConnection.getConnection();
				PreparedStatement statement = connectionToDB
						.prepareStatement(Queries.getUserDetail);) {
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				user = new User(result.getInt(1), result.getString(2),
						result.getString(3), result.getDate(4),
						result.getString(5), result.getString(6),
						result.getString(7), result.getString(8));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean createUser(String firstName, String lastName, Date dob,
			String contact, String email, String password, String organization)
			throws ClassNotFoundException, SQLException {
		boolean created = false;
		try (Connection connectionToDB = JdbcConnection.getConnection();
				PreparedStatement statement = connectionToDB
						.prepareStatement(Queries.saveUserDetail);) {
			try {

				connectionToDB.setAutoCommit(false);
				statement.setString(1, firstName);
				statement.setString(2, lastName);
				statement.setDate(3, (Date) dob);
				statement.setString(4, contact);
				statement.setString(5, email);
				statement.setString(6, password);
				statement.setString(7, organization);

				if (statement.executeUpdate() > 0) {
					created = true;
				}

				connectionToDB.commit();
			} catch (SQLException e) {
				connectionToDB.rollback();
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return created;
	}

	public UserFriend getUserFriend(User user) throws ClassNotFoundException,
			SQLException {
		Connection connectionToDB = JdbcConnection.getConnection();
		UserFriend userFriends = new UserFriend(user);
		PreparedStatement statement = connectionToDB
				.prepareStatement(Queries.getOrganization);
		statement.setInt(1, user.getId());
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			User friend = new User(result.getInt(1), result.getString(2),
					result.getString(3), result.getDate(4),
					result.getString(5), result.getString(6),
					result.getString(7), result.getString(8));
			userFriends.addFriends(friend);
		}
		return userFriends;
	}

	public boolean updateUser(String firstName, String lastName, Date dob,
			String contact, User user) throws ClassNotFoundException,
			SQLException {
		boolean updated = false;
		Connection connectionToDB = JdbcConnection.getConnection();
		PreparedStatement statement = connectionToDB
				.prepareStatement(Queries.updateDetails);
		statement.setString(1, firstName);
		statement.setString(2, lastName);
		statement.setDate(3, dob);
		statement.setString(4, contact);
		statement.setInt(5, user.getId());
		if (statement.executeUpdate() > 0) {
			updated = true;
		}
		return updated;
	}
}