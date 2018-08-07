package com.metacube.priorityqueue;

/**
 * Interface of priority Queue
 * @author Rahul Sharma
 * @param <Type> is generic type
 * Creation Date: 7/8/2018
 */
public interface Queue<Type> {
	
	/**
	 * 
	 * @param value is value in job.
	 * @param priority is priority of job.
	 * @return true if element is enqueued else false.
	 * @throws PriorityQueueException 
	 */
	public boolean enqueueElement(Type value, int priority) throws PriorityQueueException;
		

	/**
	 * 
	 * @return Job with highest priority after removing it from array.
	 * @throws PriorityQueueException 
	 */
	public Job<Type> dequeueElement() throws PriorityQueueException;

	/**
	 * 
	 * @return Job with highest priority.
	 * @throws PriorityQueueException 
	 */
	public Job<Type> peek() throws PriorityQueueException;

	/**
	 * 
	 * @return true if queue is empty else false.
	 */
	public boolean isEmpty();

	/**
	 * 
	 * @return true if queue is full else false.
	 */
	public boolean isFull();

}
