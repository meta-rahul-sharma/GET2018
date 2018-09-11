package com.metacube.training.service;

/**
 * @author Rahul Sharma
 *
 */
public class AdminServiceImpl implements AdminService {

	private static AdminServiceImpl adminServiceObject = new AdminServiceImpl();
	
	public static AdminServiceImpl getInstance() {
		
		return adminServiceObject;
	}
	
	
	@Override
	public boolean isValidLogin(String username, String password) {
		
		boolean valid = false;
		
		if("admin".equals(username) && "admin".equals(password))
			valid = true;
		
		return valid;
	}

}
