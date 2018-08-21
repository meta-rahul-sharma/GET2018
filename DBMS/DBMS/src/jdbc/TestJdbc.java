package jdbc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestJdbc {

	DbmsQueries queries = null;
	@Before
	public void initialize() {
		queries = new DbmsQueries();
	}
	
	@Test
	public void test() {
		List<Order> order = queries.fetchAllOrders("rsbhatra98@gmail.com");
		for(Order iterator: order) {
			System.out.println(iterator.getId() + " "
					+ iterator.getOrderDate() + " "
					+ iterator.getOrderTotal());
		}
	}
	
   @Test
	public void test1() {
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
	public void test2() {
		DbmsQueries queries = new DbmsQueries();
		int updatedRows = queries.updateProduct();
		System.out.println(updatedRows);
	}
	
	@Test
	public void test3() {
		DbmsQueries queries = new DbmsQueries();
		List<Category> categoryWithChildCount = queries.categoryWithChildCount();
	}

}
