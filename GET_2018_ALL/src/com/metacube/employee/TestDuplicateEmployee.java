package com.metacube.employee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Used for Testing purpose of the Collection of Employee Class
 * @author Rahul Sharma
 * Creation Date: 8/8/2018
 */
public class TestDuplicateEmployee {

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
	public void employeeExistException() throws EmployeeException {
		employee.addEmployee(2, "Rahul", "Jaipur");
		ex.expect(EmployeeException.class);
		ex.expectMessage("Already contains employee");
		employee.addEmployee(2, "sharma", "Jaipur");
		assertEquals(true, false);
	}

}
