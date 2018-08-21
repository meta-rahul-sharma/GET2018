package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	public static Connection getConnection() {
		Connection connection = null;
		try
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	      String host = "jdbc:mysql://localhost:3306/";
	      String dbName = "storefront";
	      String url = host + dbName;
	      connection = DriverManager.getConnection(url, "root", "12345");
	    }
	    catch (ClassNotFoundException e)
	    {
	      e.printStackTrace();
	      System.exit(1);
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      System.exit(2);
	    }
		return connection;	
	}
}
