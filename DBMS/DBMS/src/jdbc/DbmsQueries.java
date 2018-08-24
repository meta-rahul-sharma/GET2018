package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Used for different queries of dbms and execute them on database
 * @author RAHUL SHARMA
 * CREATION DATE: 21/08/2018
 */
public class DbmsQueries {
	
	/**
	 * Given the id of a user(Email), fetch all orders (Id, Order Date, Order Total)
	 * of that user which are in shipped state. Orders should be sorted by order
	 * date column in chronological order.
	 */
	public List<Order> fetchAllOrders(String userId) {
		List<Order> orderDetails = new ArrayList<Order>();
		String query = "SELECT order_details.order_id as Id, date_of_order as OrderDate, SUM(price) as OrderTotal "
				+ "FROM order_details "
				+ "INNER JOIN items_ordered "
				+ "ON order_details.order_id = items_ordered.order_id "
				+ "WHERE email = ? "
				+ "AND order_status = 'shipped' "
				+ "GROUP BY order_details.order_id "
				+ "ORDER BY date_of_order;";
		try (
				Connection connection = DatabaseConnect.getConnection();
				// In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"

				// Allocate a 'Statement' object in the Connection
				PreparedStatement stmt = connection.prepareStatement(query);) {
			stmt.setString(1, userId);
			ResultSet resultset = stmt.executeQuery();

			// Move the cursor to the next row, return false if no more row
			while (resultset.next()) {
				orderDetails.add(new Order(resultset.getInt("Id"), resultset
						.getDate("OrderDate"), resultset.getInt("OrderTotal")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderDetails;
	}
	
	/**
	 *Insert five or more images of a product using batch insert technique.
	 */
	public void insertImages(List<Image> images) {
		String query = "INSERT INTO IMAGES(product_id, image_url) VALUES (?, ?);";
		try (
				Connection connection = DatabaseConnect.getConnection();
				// In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"

				// Allocate a 'Statement' object in the Connection
				PreparedStatement stmt = connection.prepareStatement(query);) {
			try{
				connection.setAutoCommit(false);
				for(Image image: images) {
					stmt.setInt(1, image.getProductId());
					stmt.setString(2, image.getImageUrl());
					stmt.executeUpdate();
				}
				connection.commit();
			} catch(SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Update Inactive all those products which were not ordered by any Shopper in last 1 year. 
	 * Return the number of products updated.
	 */
	public int updateProduct() {
		int updatedProducts = 0;
		String updateProduct = "UPDATE products " +
					   "SET product_state = 'I' " +
					   "WHERE product_id " +
					   "NOT IN( SELECT * FROM(SELECT products.product_id " +
					   "FROM products " +
					   "INNER JOIN items_ordered ON products.product_id = items_ordered.product_id " +
					   "INNER JOIN order_details ON items_ordered.order_id = order_details.order_id " +
					   "WHERE date_of_order BETWEEN DATE_SUB(NOW(), INTERVAL 1 YEAR) AND NOW()) temp);";
		try (
				Connection connection = DatabaseConnect.getConnection();
				// In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"

				// Allocate a 'Statement' object in the Connection
				PreparedStatement stmt = connection.prepareStatement(updateProduct);) {
			try{
				updatedProducts = stmt.executeUpdate();
			} catch(SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedProducts;
	}
	
	/**
	 * Select and display the category title of all top parent categories sorted
	 * alphabetically and the count of their child categories.
	 */
	public List<Category> categoryWithChildCount() {
		List<Category> categoryWithChildCount = new ArrayList<Category>();
        
        String getCategoryWithChildCount = "SELECT category_name AS name, count_children(category_id) AS child_count "
                + "FROM categories "
                + "WHERE parent_id IS NULL "
                + "ORDER BY category_name;";
        try
        (
        	// In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
            Connection con = DatabaseConnect.getConnection();
        		
        	// Allocate a 'Statement' object in the Connection
            PreparedStatement stmt2 = con.prepareStatement(getCategoryWithChildCount);
        )
        {
            ResultSet result = stmt2.executeQuery();
            
            while(result.next())
            {                
                categoryWithChildCount.add(new Category(result.getString("name"), result.getInt("child_count")));
            }
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return categoryWithChildCount;
	}
}
