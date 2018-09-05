package com.dao;

public class Queries {
	public static String saveUserDetail = "INSERT INTO user_details(first_name, last_name, dob, contact, email, password, organization) VALUES(?, ?, ?, ?, ?, ?, ?);";

	public static String getUserDetail = "SELECT * FROM user_details WHERE email = ?;";

	public static String updateDetails = "UPDATE user_details SET first_name=?, last_name=?, dob=?, contact=? WHERE id = ?;";

	public static String getOrganization = "SELECT id, first_name, last_name, dob, contact, email, password, organization FROM user_details WHERE organization IN (SELECT organization "
			+ "FROM user_details WHERE id = ?);";
}
