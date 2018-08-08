package com.metacube.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Taking collection of Employee's here and performing
 * sorting by Employee names
 * @author Rahul Sharma
 * Creation Date: 8/8/2018
 */
public class CollectionOfEmployee {
	Set<Integer> ids = new HashSet<Integer>();
	List<Employee> employees = new ArrayList<Employee>();
	
	/**
	 * Inserting Employee in the collection
	 * @param id
	 * @param name
	 * @param address
	 * @throws EmployeeException
	 */
	public void addEmployee(int id, String name, String address) throws EmployeeException {
		if(name == null || address == null) {
			throw new EmployeeException("Wrong Details");
		}
		
		//Checking if already id present in set of ids and if yes stop to add Employee
		if(!ids.contains(id)) {
			ids.add(id);
			employees.add(new Employee(id, name, address));
		} else {
			throw new EmployeeException("Already contains employee");
		}
	}
	
	/**
	 * Sorting collection of Employee by Natural Ordering 
	 * @return collection of sorted employee
	 */
	public List<Employee> sortEmployeeNaturalOrder() {
		List<Employee> naturalOrder = new ArrayList<Employee>(employees);
		Collections.sort(naturalOrder);
		return naturalOrder;
	}
	
	/**
	 * Sorting collection of Employee by Name 
	 * @return collection of sorted employee
	 */
	public List<Employee> sortEmployeeByName() {
		List<Employee> sortByNameList = new ArrayList<Employee>(employees);
		Collections.sort(sortByNameList, new SortByName());
		return sortByNameList;
	}
	
	/**
	 * Get Employee by id
	 * @param id
	 * @return Employee object
	 * @throws EmployeeException
	 */
	public Employee getEmployee(int id) throws EmployeeException {
		Employee employee = null;
		if(ids.contains(id)) {
			for(Employee iterator: employees) {
				if(iterator.getId() == id) {
					employee = iterator;
				}
			}
		} else {
			throw new EmployeeException("Id not Found");
		}
		return employee;
	}
}