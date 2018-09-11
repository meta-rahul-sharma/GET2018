package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.model.Skill;

/**
 * @author Rahul Sharma
 *
 */
public class SkillDAOImpl implements SkillDAO {

    private static SkillDAOImpl skillDaoObject = new SkillDAOImpl();
    
    private static final String SQL_FIND_SKILL = "SELECT * "
            + "FROM skills "
            + "WHERE skill_name = ?";

    private static final String SQL_GET_ALL = "SELECT * FROM skills";

    private static final String SQL_INSERT_SKILL = "INSERT INTO skills(skill_name) "
            + "VALUES(?)";
    
    
    public static SkillDAOImpl getInstance() {
        
        return skillDaoObject;
    }

    
    @Override
    public List<Skill> getAllSkills() {
        
    	List<Skill> listOfSkills = new ArrayList<>();
    	
    	try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_GET_ALL);
        ){
            ResultSet result = stmt.executeQuery();
            
            while(result.next())
            {
            	Skill skill = new Skill();
            	skill.setId(result.getInt("skill_id"));
            	skill.setName(result.getString("skill_name"));
            	
            	listOfSkills.add(skill);
            }

        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
    	
        return listOfSkills;
    }

    
    @Override
    public boolean createSkill(Skill skill) {
        
        boolean inserted = false;
        
        try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_SKILL);
        ){
            stmt.setString(1, skill.getName());
            
            if(stmt.executeUpdate() > 0)
                inserted = true;

        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
        
        return inserted;
    }

	@Override
	public Skill getSkillByName(String skillName) {
		
		Skill skill = new Skill();
		
		try
        (
            Connection connection = JdbcConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_FIND_SKILL);
        ){
            stmt.setString(1, skillName);
            
            ResultSet result = stmt.executeQuery();
            result.next();
            
            skill.setId(result.getInt("skill_id"));
            skill.setName(skillName);

        }
        catch (SQLException exception) 
        {
            exception.printStackTrace();
        }
		
		return skill;
	}
}
