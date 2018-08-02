package com.metacube.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementing Queue class and providing methods
 * definition using LinkedList
 * @author Rahul Sharma 
 * Creation Date: 1/8/2018
 */
public class ListQueue<Type> implements Queue<Type> {
	private List<Type> queue = new LinkedList<Type>();
	int maxSize;
	
	public ListQueue(int maxSize) {
		this.maxSize = maxSize;
	}
	
	/**
	 * Used for adding item in a Queue
	 */
	@Override
	public void addItem(Type addElement) {
		if (isQueueFull()) {
			throw new RuntimeException("queue is full");
		} else {
			queue.add(addElement);
		}
	}

	/**
	 * Used for deleting and returning item which was first
	 * inserted in a Queue
	 */
	@Override
	public Type deleteItem() {
		Type item;
		if (isQueueEmpty()) {
			throw new RuntimeException("queue is empty");
		} else {
			item = queue.get(0);
			queue.remove(0);
		}
		return item;
	}

	/**
	 * To check Queue is empty or not
	 */
	@Override
	public boolean isQueueEmpty() {
		return (queue.size() == 0);
	}

	/**
	 * To check Queue is Full or not
	 */
	@Override
	public boolean isQueueFull() {
		return (queue.size() == maxSize);
	}
}
