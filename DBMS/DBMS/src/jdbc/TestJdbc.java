package jdbc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * To Test all DBMSQueries
 * @author RAHUL SHARMA
 * CREATION DATE: 21/08/2018
 */
public class TestJdbc {

	DbmsQueries queries = null;
	@Before
	public void initialize() {
		queries = new DbmsQueries();
	}

	@Test
	public void fechAllOrders_underGivenUserId_showOrders() {
		List<Order> order = queries.fetchAllOrders("rsbhatra98@gmail.com");
		for(Order iterator: order) {
			System.out.println(iterator.getId() + " "
					+ iterator.getOrderDate() + " "
					+ iterator.getOrderTotal());
		}
	}
	
   @Test
	public void insertImages_noDuplicates_insertInImageTable() {
		DbmsQueries queries = new DbmsQueries();
		List<Image> images = new ArrayList<Image>();
		images.add(new Image(1, "product1.image"));
		images.add(new Image(2, "product2.image1"));
		images.add(new Image(3, "product3.image1"));
		images.add(new Image(3, "product3.image2"));
		images.add(new Image(2, "product2.image2"));
		queries.insertImages(images);
	}

	@Test
	public void updateProduct_inactiveNotOrderedFor1YearProduct_updateProductState() {
		DbmsQueries queries = new DbmsQueries();
		int updatedRows = queries.updateProduct();
		assertEquals(4, updatedRows);
	}
	
	@Test
	public void categoryWithChildCount_categoryWhichAreParent_generateCountOfParentCategory() {
		DbmsQueries queries = new DbmsQueries();
		List<Category> categoryWithChildCount = queries.categoryWithChildCount();
		for(Category category : categoryWithChildCount) {
			System.out.println(category.getTitle() + " " + category.getNumberOfChildCategories());
		}
	}
}
