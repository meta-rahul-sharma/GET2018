package com.metacube.queue;

/**
 * Implementing Queue class and providing methods
 * definition using array
 * @author Rahul Sharma 
 * Creation Date: 1/8/2018
 */
public class ArrayQueue<Type> implements Queue<Type> {
	private int front = 0, rear = -1, maxSize;
	Type[] queue;

	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		queue = (Type[]) new Object[maxSize];
	}

	/**
	 * Used for adding item in a Queue
	 */
	@Override
	public void addItem(Type addElement) {
		if (isQueueFull()) {
			throw new RuntimeException("queue is full");
		} else {
			queue[front++] = addElement;
		}
	}

	/**
	 * Used for deleting and returning item which was first inserted in a Queue
	 */
	@Override
	public Type deleteItem() {
		Type item;
		if (isQueueEmpty()) {
			throw new RuntimeException("queue is empty");
		} else {
			item = queue[++rear];
		}
		return item;
	}

	/**
	 * To check Queue is empty or not
	 */
	@Override
	public boolean isQueueEmpty() {
		return (front - 1 == rear);
	}

	/**
	 * To check Queue is Full or not
	 */
	@Override
	public boolean isQueueFull() {
		return (front == maxSize);
	}
}
