package com.metacube.employee;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Used for Testing purpose of the Collection of Employee Class
 * @author Rahul Sharma
 * Creation Date: 8/8/2018
 */
public class TestSortByName {
	
	CollectionOfEmployee employee = new CollectionOfEmployee();
	
	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void initialize() throws EmployeeException {
		employee.addEmployee(3, "jangid", "Mount abu");
		employee.addEmployee(5, "nirma", "Jodhpur");
		employee.addEmployee(19, "mohan das", "porbandar");
	}

	@Test
	public void employeeSortByName() throws EmployeeException {
		employee.addEmployee(2, "Rahul", "Jaipur");
		employee.addEmployee(4, "sharma", "Jaipur");
		List<Employee> result = employee.sortEmployeeByName();
		List<Employee> expected = new ArrayList<Employee>();
		//getEmployee using Employee Employee id as parameter
		expected.add(employee.getEmployee(3));
		expected.add(employee.getEmployee(19));
		expected.add(employee.getEmployee(5));
		expected.add(employee.getEmployee(2));
		expected.add(employee.getEmployee(4));
		assertEquals(expected, result);
	}
}