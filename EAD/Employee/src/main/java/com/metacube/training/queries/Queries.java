package com.metacube.training.Query;

public class Queries {
    public static final String ADD_EMPLOYEE = "INSERT INTO Employee(first_name, middle_name, last_name, "
            + "dob, gender, email, contact, skype_id, profile_picture, skills) "
            + "VALUES "
            + "(?,?,?,?,?,?,?,?,?,?)";
    
    public static final String GET_ALL_EMPLOYEES = "SELECT * from employee WHERE enabled = 'true'";
    
    public static final String GET_EMPLOYEE_BY_CODE = "SELECT * from employee "
            + "WHERE code = ?";
    
    public static final String UPDATE_EMPLOYEE = "UPDATE Employee set first_name = ?, middle_name = ?, "
            + "last_name = ?, dob = ?, gender = ?, email = ?, contact = ?, skype_id = ?,"
            + "profile_picture = ? , skills = ? "
            + "WHERE code = ?";
    
    public static final String DELETE_EMPLOYEE = "UPDATE employee "
            + "SET enabled = 'false' " 
            + "WHERE code = ?";
}
