package com.metacube.priorityqueue;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests priority queue.
 * @author Rahul Sharma
 * Creation Date: 7/8/2018
 * 
 */
public class TestPriorityQueue {

	
	
	PriorityQueue<Integer> priorityDeEnqueue = new PriorityQueue<Integer>(5);
	
	@Test
	public void enqueueTestQueueIsFullException(){
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(5);
		try {
			assertTrue(priorityQueue.enqueueElement(15,5));
			assertTrue(priorityQueue.enqueueElement(13,3));
			assertTrue(priorityQueue.enqueueElement(14,4));
			assertTrue(priorityQueue.enqueueElement(11,1));
			assertTrue(priorityQueue.enqueueElement(12,2));
			assertFalse(priorityQueue.enqueueElement(17,7));
			assertEquals(true, false);
		} catch (PriorityQueueException e) {
			assertEquals("queue is full", e.getMessage());
		}
		
	}

	@Test
	public void dequeueTest() throws PriorityQueueException {
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(5);

		assertTrue(priorityQueue.enqueueElement(13,3));
		assertTrue(priorityQueue.enqueueElement(14,4));
		assertTrue(priorityQueue.enqueueElement(11,1));
		assertTrue(priorityQueue.enqueueElement(10,1));
		assertTrue(priorityQueue.enqueueElement(23,3));
		
		Job<Integer> dequeuedJob = priorityQueue.dequeueElement();		
		assertEquals((Integer)14, dequeuedJob.value);
		
		dequeuedJob = priorityQueue.dequeueElement();
		assertEquals((Integer)13, dequeuedJob.value);
		
	}
	
	@Test
	public void queueIsEmptyException() {
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(5);
		@SuppressWarnings("unused")
		Job<Integer> nextJob;
		try {
			nextJob = priorityQueue.dequeueElement();
			assertEquals(true, false);
		} catch (PriorityQueueException e) {
			assertEquals("queue is empty", e.getMessage());
		}
		
		
	}
	
	@Test
	public void peekTest() throws PriorityQueueException {
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(5);

		assertTrue(priorityQueue.enqueueElement(13,3));
		assertTrue(priorityQueue.enqueueElement(14,4));
		assertTrue(priorityQueue.enqueueElement(11,1));
		assertTrue(priorityQueue.enqueueElement(10,1));
		assertTrue(priorityQueue.enqueueElement(23,3));
		
		Job<Integer> nextJob = priorityQueue.peek();		
		assertEquals((Integer)14, nextJob.value);
		
	}
	
	@Test
	public void peekEmptyTest() {
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(5);
		Job<Integer> nextJob;
		try {
			nextJob = priorityQueue.peek();
			assertEquals((Integer)14, nextJob.value);
			assertEquals(true, false);
		} catch (PriorityQueueException e) {
			assertEquals("queue is empty", e.getMessage());
		}
	}
	
	@Test
	public void isFullTest() throws PriorityQueueException {
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(5);

		assertTrue(priorityQueue.enqueueElement(13,3));
		assertTrue(priorityQueue.enqueueElement(14,4));
		assertTrue(priorityQueue.enqueueElement(11,1));
		assertFalse(priorityQueue.isFull());	
		assertTrue(priorityQueue.enqueueElement(10,1));
		assertTrue(priorityQueue.enqueueElement(23,3));
		assertTrue(priorityQueue.isFull());		
	}
	
	@Test
	public void isEmptyTest() throws PriorityQueueException {
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(5);

		assertTrue(priorityQueue.isEmpty());
		
		assertTrue(priorityQueue.enqueueElement(13,3));
		assertTrue(priorityQueue.enqueueElement(14,4));
		assertTrue(priorityQueue.enqueueElement(11,1));
		
		assertFalse(priorityQueue.isEmpty());	
	}
}