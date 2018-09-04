package com.metacube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.entity.Advertisement;

public class AdvertisementDao {
	
	private static AdvertisementDao advertisementDao = new AdvertisementDao();
	
	public static AdvertisementDao getInstance() {
		return advertisementDao;
	}
	    
    public boolean isAdvertisementExist(int advertisementId)
    {
    	boolean exists = false;
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_ADVERTISEMENT_TITLE);
        ){
            preparedStatement.setInt(1, advertisementId);
            ResultSet result = preparedStatement.executeQuery();
            
            result.next();
            if(result.getString("title") != null)
                exists = true;
            
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return exists;
    }

    public boolean createAdvertisement(Advertisement advertisement) {
        boolean created = false;
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.CREATE_ADVERTISEMENT);
        ){
            stmt.setString(1, advertisement.getTitle());
            stmt.setString(2, advertisement.getDescription());
            stmt.setInt(3, advertisement.getCategoryId());
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

    public List<Advertisement> getAdvertisements() {
        
        List<Advertisement> advertisements = new ArrayList<Advertisement>();
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_ADVERTISEMENTS);
        ){
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next())
            {
                int id = result.getInt("adv_id");
                String title = result.getString("title");
                String description = result.getString("description");
                int categoryId = result.getInt("category_id");
                advertisements.add(new Advertisement(id, title, description, categoryId));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return advertisements;
        
    }

    public List<Advertisement> getAdvertisementsByCategory(int categoryId) {
        
        List<Advertisement> advertisements = new ArrayList<Advertisement>();
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_ADVERTISEMENTS_BY_CATEGORY);
        ){
            preparedStatement.setInt(1, categoryId);
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next())
            {
                int id = result.getInt("adv_id");
                String title = result.getString("title");
                String description = result.getString("description");
                advertisements.add(new Advertisement(id, title, description, categoryId));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return advertisements;
    }

	public boolean updateAdvertisementName(Advertisement advertisement) {
		boolean updated = false;
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.UPDATE_ADVERTISEMENT_NAME);
        ){
            stmt.setString(1, advertisement.getTitle());
            stmt.setInt(2, advertisement.getId());
            
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

	public boolean deleteAdvertisement(int advertisementId) {
		boolean deleted = false;
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Queries.DELETE_ADVERTISEMENT);
        ) {
			stmt.setInt(1, advertisementId);
            
			if(stmt.executeUpdate() >= 1) {
				deleted = true;
			}     
        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		return deleted;
	}
}
