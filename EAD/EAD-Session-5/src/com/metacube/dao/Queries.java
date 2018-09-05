package com.metacube.dao;

/**
 * Queries needed for advertisement and category table data access
 * @author RAHUL SHARMA
 * Creation DATE: 02/08/2018
 */
public class Queries {

    public static final String CREATE_CATEGORY = "INSERT INTO category(category_name) "
                                                + "VALUES(?);";
    
    public static final String GET_CATEGORIES = "SELECT * "
                                                + "FROM category;";
    
    public static final String GET_CATEGORY_NAME = "SELECT * "
                                                + "FROM category "
                                                + "WHERE category_id = ?;";
    
    public static final String CREATE_ADVERTISEMENT = "INSERT INTO advertisement(title, description, category_id) "
                                                + "VALUES(?, ?, ?);";
    
    public static final String GET_ADVERTISEMENTS = "SELECT * "
                                                + "FROM advertisement;";
    
    public static final String GET_ADVERTISEMENTS_BY_CATEGORY = "SELECT * "
									            + "FROM advertisement "
									            + "WHERE category_id = ?";
    
    public static final String GET_ADVERTISEMENT_TITLE = "SELECT title "
									            + "FROM advertisement "
									            + "WHERE adv_id = ?";
    
    public static final String UPDATE_ADVERTISEMENT_NAME = "UPDATE advertisement "
    											+ "SET title = ? "
    											+ "WHERE adv_id = ?";
    
    public static final String UPDATE_CATEGORY_NAME = "UPDATE category "
												+ "SET category_name = ? "
												+ "WHERE category_id = ?";
    
    public static final String DELETE_ADVERTISEMENT = "DELETE FROM advertisement "
    											+ "WHERE adv_id = ?";
}
