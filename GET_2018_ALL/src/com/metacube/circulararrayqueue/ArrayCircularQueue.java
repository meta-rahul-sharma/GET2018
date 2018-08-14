package com.metacube.circulararrayqueue;

import com.metacube.queue.*;

/**
 * Implementing circular queue using array for better
 * utilization of space
 * @author Rahul Sharma
 * Creation Date : 3/8/2018
 */
public class ArrayCircularQueue<Type> implements Queue<Type> {
	private int rear = -1, front = -1, maxSize;
	Type[] queue;

	public ArrayCircularQueue(int maxSize) {
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
			if (front == -1) {
				front = 0;
			}	
			rear = (rear + 1) % maxSize;
			queue[rear] = addElement;
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
		} else if (front == rear) {
			item = queue[front];
			//front and rear are set -1 so again put array in utilization 
			front = -1;
			rear = -1;
		} else {
			item = queue[front];
			front = (front + 1) % maxSize;
		}
		return item;
	}

	/**
	 * To check Queue is empty or not
	 */
	@Override
	public boolean isQueueEmpty() {
		boolean empty = false;
		if (front == -1) {
			empty = true;
		}
		return empty;
	}

	/**
	 * To check Queue is Full or not
	 */
	@Override
	public boolean isQueueFull() {
		boolean full = false;
		if (front == 0 && rear == maxSize - 1 || front == rear + 1) {
			full = true;
		}
		return full;
	}
}
