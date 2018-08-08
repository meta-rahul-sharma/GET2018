package com.metacube.employee;

/**
 * Creating Employee and its properties getter setter method
 * Implementing Comparable interface for natural sorting of Employee
 * @author Rahul Sharma
 * Creation Date: 8/8/2018
 */
public class Employee implements Comparable <Employee>{
	private int id;
	private String name;
	private String address;
	
	public Employee(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}

	@Override
	public int compareTo(Employee other) {
		return id - other.getId();
	}
}
