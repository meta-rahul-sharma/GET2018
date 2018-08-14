package com.metacube.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Rahul Sharma
 * Creation Date: 1/8/2018
 */
public class TestStack {

	Stack<String> arrayStack;
	Stack<String> stackList;

	@Before
	public void init() throws StackException {
		arrayStack = new ArrayStack<String>(5);
		stackList = new ListStack<String>();

		// Initializing Stack using Array
		arrayStack.push("The");
		arrayStack.push("Fault");
		arrayStack.push("In");
		arrayStack.push("Our");

		// Initializing Stack using Linked List
		stackList.push("Wolf");
		stackList.push("of");
		stackList.push("the");
		stackList.push("Wall");
	}

	@Test
	public void arrayStackFullException() {
		// Adding element when Stack is Full
		try {
			arrayStack.push("Stars");
			arrayStack.push("Written");
		} catch (StackException ex) {
			assertEquals("stack is full", ex.getMessage());
		}
	}

	@Test
	public void testPopArrayStack() throws StackException {
		// Deleting Element from Stack
		assertEquals("Our", arrayStack.pop());
		assertEquals("In", arrayStack.pop());
	}

	@Test
	public void testPushArrayStack() throws StackException {
		// Adding Element in Stack
		arrayStack.push("Stars");
		assertEquals("Stars", arrayStack.top());
	}

	
	@Test
	public void testTopElementArrayStack() {
		// Top Element in Stack
		assertEquals("Our", arrayStack.top());
	}
	
	@Test
	public void testIsEmptyArrayStack() {
		// Checking Whether the Stack is Empty or not
		assertFalse(arrayStack.isEmpty());
	}

	@Test
	public void testPopArrayStackIsEmptyException() {
		// Deleting from an Empty Stack
		try {
			arrayStack.pop();
			arrayStack.pop();
			arrayStack.pop();
			arrayStack.pop();
			arrayStack.pop();
		} catch (StackException ex) {
			assertEquals("stack is empty", ex.getMessage());
		}
	}

	
	@Test
	public void testPopListStack() throws StackException {
		// Deleting Element from Stack
		assertEquals("Wall", stackList.pop());
		assertEquals("the", stackList.pop());
	}
	
	@Test
	public void testPushListStack() throws StackException {
		// Adding Element in Stack
		stackList.push("Street");
		assertEquals("Street", stackList.top());
	}
	
	@Test
	public void testTopElementListStack() {
		// Top Element in Stack
		assertEquals("Wall", stackList.top());
	}
	
	@Test
	public void testIsEmptyListStack() {
		// Checking Whether the Stack is Empty or not
		assertFalse(stackList.isEmpty());
	}


	@Test
	public void testPopListStackIsEmpty() {
		// Deleting element from an Empty Stack
		try {
			stackList.pop();
			stackList.pop();
			stackList.pop();
			stackList.pop();
			stackList.pop();
		} catch (StackException ex) {
			assertEquals("stack is empty", ex.getMessage());
		}
	}
}
