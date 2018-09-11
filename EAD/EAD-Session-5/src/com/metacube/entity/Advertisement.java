package com.metacube.entity;

/**
 * Advertisement Pojo
 * @author RAHUL SHARMA
 * Creation DATE: 02/08/2018
 */
public class Advertisement {
	private int id;
	private String title;
	private String description;
	private int categoryId;
	
	public Advertisement() {
		
	}
	
	public Advertisement(int id, String title, String description,
			int categoryId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
}
