package com.metacube.priorityqueue;

/**
 * This class creates a job to pass in queue.
 * @author Rahul Sharma
 * Creation Date: 7/8/2018
 */
public class Job<Type> {
	Type value;
	int priority;

	public Job(Type value, int priority) {
		this.value = value;
		this.priority = priority;
	}

}
