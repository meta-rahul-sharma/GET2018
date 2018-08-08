package com.metacube.queue;

/**
 * Implementing Queue class and providing methods
 * definition using array
 * @author Rahul Sharma 
 * Creation Date: 1/8/2018
 */
public class ArrayQueue<Type> implements Queue<Type> {
	private int rear = 0, front = -1, maxSize;
	Type[] queue;

	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		queue = (Type[]) new Object[maxSize];
	}

	/**
	 * Used for adding item in a Queue
	 * @throws QueueException 
	 */
	@Override
	public void addItem(Type addElement) throws QueueException {
		if (isQueueFull()) {
			throw new QueueException("queue is full");
		} else {
			queue[rear++] = addElement;
		}
	}

	/**
	 * Used for deleting and returning item which was first inserted in a Queue
	 * @throws QueueException 
	 */
	@Override
	public Type deleteItem() throws QueueException {
		Type item;
		if (isQueueEmpty()) {
			throw new QueueException("queue is empty");
		} else {
			item = queue[++front];
		}
		return item;
	}

	/**
	 * To check Queue is empty or not
	 */
	@Override
	public boolean isQueueEmpty() {
		return (rear - 1 == front);
	}

	/**
	 * To check Queue is Full or not
	 */
	@Override
	public boolean isQueueFull() {
		return (rear == maxSize);
	}
}
