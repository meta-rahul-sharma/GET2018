package com.metacube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.entity.Category;

/**
 * 
 * @author RAHUL SHARMA
 * Creation DATE: 02/08/2018
 */
public class CategoryDao {
	
	private static CategoryDao categoryDao = new CategoryDao();
	
	/**
	 * @return Singleton object of category
	 */
	public static CategoryDao getInstance() {
		return categoryDao;
	}

	/**
	 * To create category
	 * @param category
	 */
	public boolean createCategory(Category category) {
        boolean created = false;
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.CREATE_CATEGORY);
        ){
            stmt.setString(1, category.getName());
            
            if(stmt.executeUpdate() == 1) {
            	created = true;
            }     
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        return created;
    }

	/**
	 * @return List of categories
	 */
    public List<Category> getCategories() {
        
        List<Category> categories = new ArrayList<Category>();
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_CATEGORIES);
        ){
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next())
            {
                int id = result.getInt("category_id");
                String categoryName = result.getString("category_name");
                categories.add(new Category(id, categoryName));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return categories;
    }

    /**
	 * To check if category with given id exist or not
	 * @param advertisementId
	 */
    public boolean isCategoryExist(int categoryId) {
        boolean exists = false;
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_CATEGORY_NAME);
        ){
            preparedStatement.setInt(1, categoryId);
            ResultSet result = preparedStatement.executeQuery();
            
            result.next();
            if(result.getString("category_name") != null)
                exists = true;
            
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return exists;
    }
    
    /**
     * To update Category with new details
     * @param category
     */
    public boolean updateCategoryName(Category category) {
		boolean updated = false;
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.UPDATE_CATEGORY_NAME);
        ){
            stmt.setString(1, category.getName());
            stmt.setInt(2, category.getId());
            
            if(stmt.executeUpdate() == 1) {
            	updated = true;
            }   
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		return updated;
	}
}
