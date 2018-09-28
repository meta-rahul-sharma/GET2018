package com.metacube.training.SpringSecurity.service;

/**
 * @author Rahul Sharma
 *
 */
public interface AdminService {

	public boolean isValidLogin(String username, String password);
}
