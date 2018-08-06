package com.metacube.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Used for Testing purpose of Queue class
 * 
 * @author Rahul Sharma 
 * Creation Date: 1/8/2018
 */
public class TestQueue {
	Queue<Integer> queueArray;
	Queue<Integer> queueList;
	@Before
	public void testUsingArrayQueue() throws QueueException {
		//Initialize ArrayQueue
		queueArray = new ArrayQueue<Integer>(5);
		queueArray.addItem(1);
		queueArray.addItem(2);
		queueArray.addItem(3);
		queueArray.addItem(4);
		
		//Initialize ListQueue
		queueList = new ArrayQueue<Integer>(5);
		queueList.addItem(1);
		queueList.addItem(2);
		queueList.addItem(3);
		queueList.addItem(4);
	}

	@Test
	public void ArrayQueueIsFullException1() {
		try {
			queueArray.addItem(5);
			queueArray.addItem(6);
			assertEquals(true, false);
		} catch (QueueException ex) {
			assertEquals("queue is full", ex.getMessage());
		}
	}

	@Test
	public void ArrayQueueIsFullException2() {
		try {
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.addItem(5);
			queueArray.deleteItem();
			queueArray.addItem(6);
			assertEquals(true, false);
		} catch (QueueException ex) {
			assertEquals("queue is full", ex.getMessage());
		}
	}

	@Test
	public void ArrayQueueIsEmptyException1() {
		try {
			Queue<Integer> queue = new ArrayQueue<Integer>(5);
			queue.deleteItem();
			assertEquals(true, false);
		} catch (QueueException ex) {
			assertEquals("queue is empty", ex.getMessage());
		}
	}

	@Test
	public void ArrayQueueIsEmptyException2() {
		try {
			queueArray.addItem(5);
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.deleteItem();
			queueArray.deleteItem();
			assertEquals(true, false);
		} catch (QueueException ex) {
			assertEquals("queue is empty", ex.getMessage());
		}
	}

	@Test
	public void ArrayQueueDeleteItem1() throws QueueException {

		int result = queueArray.deleteItem();
		assertEquals(1, result);

	}

	@Test
	public void ArrayQueueDeleteItem2() throws QueueException {
		queueArray.addItem(5);
		queueArray.deleteItem();
		int result = queueArray.deleteItem();
		assertEquals(2, result);
	}

	@Test
	public void ListQueueIsFullException() {
		try {
			queueList.addItem(5);
			queueList.addItem(6);
			assertEquals(true, false);
		} catch (QueueException ex) {
			assertEquals("queue is full", ex.getMessage());
		}
	}

	@Test
	public void ListQueueIsEmptyException1() {
		try {
			Queue<Integer> queueList = new ListQueue<Integer>(5);
			queueList.deleteItem();
			assertEquals(true, false);
		} catch (QueueException ex) {
			assertEquals("queue is empty", ex.getMessage());
		}
	}

	@Test
	public void ListQueueIsEmptyException2() {
		try {
			queueList.addItem(5);
			queueList.deleteItem();
			queueList.deleteItem();
			queueList.deleteItem();
			queueList.deleteItem();
			queueList.deleteItem();
			queueList.deleteItem();
			assertEquals(true, false);
		} catch (QueueException ex) {
			assertEquals("queue is empty", ex.getMessage());
		}
	}

	@Test
	public void ListQueueDeleteItem1() throws QueueException {
		int result = queueList.deleteItem();
		assertEquals(1, result);
	}

	@Test
	public void ListQueueDeleteItem2() throws QueueException {
		queueList.addItem(5);
		queueList.deleteItem();
		int result = queueList.deleteItem();
		assertEquals(2, result);
	}
}
