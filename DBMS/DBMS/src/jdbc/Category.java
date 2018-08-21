package jdbc;

public class Category {
	String title;
	int numberOfChildCategories;
	
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
