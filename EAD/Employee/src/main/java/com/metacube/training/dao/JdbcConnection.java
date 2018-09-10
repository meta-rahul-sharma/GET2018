package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    /**
     * method to create a connection with the database
     * @return connection 
     */
    public static Connection getConnection()
    {
        Connection connection = null;
        String driverClass = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/employee_portal";
        String username = "root";
        String password = "12345";
        
        try
        {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, username, password);
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
            System.exit(1);
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
            System.exit(2);
        }
        
        return connection;
    }
    
}
