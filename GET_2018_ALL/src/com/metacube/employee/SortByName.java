package com.metacube.employee;

import java.util.Comparator;

/**
 * Implementing Comparator interface for custom sorting of Employee
 * by name
 * @author Rahul Sharma
 * Creation Date: 8/8/2018
 */
public class SortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		return employee1.getName().compareToIgnoreCase(employee2.getName());
	}
}
