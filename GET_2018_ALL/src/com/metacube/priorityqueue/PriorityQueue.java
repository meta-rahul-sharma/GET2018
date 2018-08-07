package com.metacube.priorityqueue;

/**
 * This class implements priority queue.
 * @author Rahul Sharma
 * @param <Type> is Generic type
 * Creation Date: 7/8/2018
 */
public class PriorityQueue<Type> implements Queue<Type> {

	@SuppressWarnings("rawtypes")
	private Job[] queueArray;
	private int queueLength;
	private final int SIZE;

	public PriorityQueue(int SIZE) {
		this.queueLength = -1;
		this.queueArray = new Job[SIZE];
		this.SIZE = SIZE;
	}

	/**
	 * To insert element in the Queue
	 * @param value is value in job.
	 * @param priority is priority of job.
	 * @return true if element is enqueued else false.
	 * @throws PriorityQueueException 
	 */
	public boolean enqueueElement(Type value, int priority) throws PriorityQueueException {
		Job<Type> elementToEnqueue = new Job<Type>(value, priority);
		boolean flag;
		try {
			if (!isFull()) {
				queueArray[++queueLength] = elementToEnqueue;
				flag = true;
			} else {
				throw new PriorityQueueException("queue is full");
			}
		}
		
		catch(IndexOutOfBoundsException error) {
			flag = false;
		}
		return flag;
	}

	/**
	 * To get element which was first inserted
	 * @return Job with highest priority after removing it from array.
	 * @throws PriorityQueueException 
	 */
	@SuppressWarnings("unchecked")
	public Job<Type> dequeueElement() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException("queue is empty");
		}
		
		Job<Type> element =  queueArray[getHighestPriority()];
		for(int i = getHighestPriority(); i < queueLength; i++) {
			queueArray[i] = queueArray[i+1];
		}
		queueArray[queueLength] = null;
		queueLength--;
		return element;
	}

	/**
	 * 
	 * @return Job with highest priority.
	 * @throws PriorityQueueException 
	 */
	@SuppressWarnings("unchecked")
	public Job<Type> peek() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException("queue is empty");
		}
		return queueArray[getHighestPriority()];
	}

	/**
	 * @return true if queue is empty else false.
	 */
	public boolean isEmpty() {
		if (queueLength == -1) {
			return true;
		}
		return false;
	}

	/**
	 * @return true if queue is full else false.
	 */
	public boolean isFull() {
		if (queueLength == SIZE-1) {
			return true;
		}
		return false;
	}
	
	/** 
	 * @return index of element with highest priority.
	 */
	private int getHighestPriority() {

		int maxPriority = queueArray[0].priority;
		int indexOfHighestPriority = 0;
		
		for (int i = 0; i < queueLength+1; i++) {
			if (queueArray[i].priority > maxPriority) {
				indexOfHighestPriority = i;
				maxPriority = queueArray[i].priority;
			}
		}
		return indexOfHighestPriority;

	}	
}