package jdbc;

/**
 * POJO For Category title and number of child count of category
 * @author RAHUL SHARMA
 * CREATION DATE: 21/08/2018
 */
public class Category {
	private String title;
	private int numberOfChildCategories;
	
	public Category(String title, int numberOfChildCategories) {
		this.title = title;
		this.numberOfChildCategories = numberOfChildCategories;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumberOfChildCategories() {
		return numberOfChildCategories;
	}
	public void setNumberOfChildCategories(int numberOfChildCategories) {
		this.numberOfChildCategories = numberOfChildCategories;
	}
}
