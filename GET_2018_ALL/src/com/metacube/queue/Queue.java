package com.metacube.queue;

/**
 * Interface Queue Which is describing
 * about method it should have
 * @author Rahul Sharma
 * Creation Date: 1/8/2018
 */
public interface Queue<Type> {
	public void addItem(Type addElement) throws QueueException;
	public Type deleteItem() throws QueueException;
	public boolean isQueueEmpty();
	public boolean isQueueFull();
}
