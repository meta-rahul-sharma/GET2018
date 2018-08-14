package com.metacube.circulararrayqueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.queue.ArrayQueue;
import com.metacube.queue.ListQueue;
import com.metacube.queue.Queue;
import com.metacube.queue.QueueException;

/**
 * Used for Testing purpose of Queue class
 * @author Rahul Sharma 
 * Creation Date: 3/8/2018
 */
public class TestQueue {
	Queue<Integer> queueArray;
	@Before
	public void testUsingArrayCircularQueue() throws QueueException {
		//Initialize ArrayQueue
		queueArray = new ArrayCircularQueue<Integer>(5);
		queueArray.addItem(1);
		queueArray.addItem(2);
		queueArray.addItem(3);
		queueArray.addItem(4);
	}

	@Test
	public void ArrayCircularQueueIsFullException1() throws QueueException {
		try {
			queueArray.addItem(5);
			queueArray.addItem(6);
			assertEquals(true, false);
		} catch (RuntimeException ex) {
			assertEquals("queue is full", ex.getMessage());
		}
	}

	@Test
	public void ArrayCircularQueueIsFullException2() throws QueueException {		
		queueArray.deleteItem();
		queueArray.deleteItem();
		queueArray.deleteItem();
		queueArray.deleteItem();
		queueArray.addItem(5);
		queueArray.deleteItem();
		queueArray.addItem(6);
		queueArray.addItem(7);
		queueArray.addItem(8);
		queueArray.addItem(9);
	}

	@Test
	public void ArrayCircularQueueIsEmptyException1() throws QueueException {
		try {
			Queue<Integer> queue = new ArrayCircularQueue<Integer>(5);
			queue.deleteItem();
			assertEquals(true, false);
		} catch (RuntimeException ex) {
			assertEquals("queue is empty", ex.getMessage());
		}
	}

	@Test
	public void ArrayCircularQueueIsEmptyException2() throws QueueException {
		try {
			queueArray.addItem(5);
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.deleteItem();
			assertEquals(true, false);
		} catch (RuntimeException ex) {
			assertEquals("queue is empty", ex.getMessage());
		}
	}

	@Test
	public void ArrayCircularQueueDeleteItem1() throws QueueException {

		int result = queueArray.deleteItem();
		assertEquals(1, result);

	}

	@Test
	public void ArrayCircularQueueDeleteItem2() throws QueueException {
		queueArray.addItem(5);
		queueArray.deleteItem();
		int result = queueArray.deleteItem();
		assertEquals(2, result);
	}
}
