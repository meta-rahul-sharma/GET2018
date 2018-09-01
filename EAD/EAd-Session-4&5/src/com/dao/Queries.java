package com.dao;

public class Queries {
	public static String saveUserDetail = "INSERT INTO user_details(first_name, last_name, dob, contact, email, password, organization) VAFLUES(?, ?, ?, ?, ?, ?, ?);)";
	
	public static String getUserDetail = "SELECT password FROM user_details WHERE email = ?;";

	public static String updateDetails = "UPDATE user SET first_name=?, last_name=?, dob=? contact_no=? WHERE email = ?;";

	public static String getOrganization = "SELECT email, first_name, last_name FROM user WHERE organization IN (SELECT organization "
				+ "FROM user WHERE email = ?);";
}
