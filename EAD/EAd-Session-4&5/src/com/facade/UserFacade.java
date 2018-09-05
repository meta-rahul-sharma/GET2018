package com.facade;

import java.sql.SQLException;
import java.util.Date;
import com.dao.UserDao;
import com.model.Authentication;
import com.model.User;
import com.model.UserFriend;

public class UserFacade {

    private static UserFacade userFacade = new UserFacade();
	private UserDao dao = UserDao.getInstance();

	public static UserFacade getInstance() {
		return userFacade;
	}

	public boolean authenticateUser(String email, String password) throws ClassNotFoundException, SQLException {
		boolean authenticate = false;
		Authentication authenticateUser = dao.authenticate(email);
		if (authenticateUser.getPassword().equals(password)) {
			authenticate = true;
		}
		return authenticate;
	}

	public boolean registerUser(String firstName, String lastName, Date dob, String contact, String email,
			String password, String organization) throws ClassNotFoundException, SQLException {
		boolean register = false;
		if (dao.createUser(firstName, lastName, (java.sql.Date) dob, contact, email, password, organization)) {
			register = true;
		}
		return register;
	}

	public UserFriend getUserFriends(User user) throws ClassNotFoundException, SQLException {
		return dao.getUserFriend(user);
	}

	public boolean updateUserInfo(String firstName, String lastName, Date dob, String contact, User user)
			throws ClassNotFoundException, SQLException {
		dao.updateUser(firstName, lastName, (java.sql.Date) dob, contact, user);
		return true;
	}
	
	public User getUser(String email) throws ClassNotFoundException, SQLException {
		return dao.getUser(email);
		
	}
}