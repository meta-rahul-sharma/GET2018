package GET2018.DSA.DSSession1.Stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

	StackArray stackArray;
	StackLinkedList stackList;

	@Before
	public void init() {
		stackArray = new StackArray();
		stackList = new StackLinkedList();

		// Initializing Stack using Array
		stackArray.push("The");
		stackArray.push("Fault");
		stackArray.push("In");
		stackArray.push("Our");

		// Initializing Stack using Linked List
		stackList.push("Wolf");
		stackList.push("of");
		stackList.push("the");
		stackList.push("Wall");
	}

	@Test
	public void testPushStackUsingArrayOverflow() {
		// Adding element when Stack is Full
		try {
			stackArray.push("Stars");
			stackArray.push("Written");
		} catch (ArrayIndexOutOfBoundsException ex) {
			assertEquals("Element can't be Add, Stack is Full", ex.getMessage());
		}
	}

	@Test
	public void testPopStackUsingArray() {
		// Deleting Element from Stack
		assertEquals("Our", stackArray.pop());
		assertEquals("In", stackArray.pop());
	}

	@Test
	public void testPushStackUsingArray() {
		// Adding Element in Stack
		assertTrue(stackArray.push("Stars"));
	}

	@Test
	public void testTopElementStackUsingArray() {
		// Top Element in Stack
		assertEquals("Our", stackArray.top());
	}

	@Test
	public void testIsEmptyStackUsingArray() {
		// Checking Whether the Stack is Empty or not
		assertFalse(stackArray.isEmpty());
	}

	@Test
	public void testPopStackUsingArrayUnderflow() {
		// Deleting from an Empty Stack
		try {
			stackArray.pop();
			stackArray.pop();
			stackArray.pop();
			stackArray.pop();
			stackArray.pop();
		} catch (ArrayIndexOutOfBoundsException ex) {
			assertEquals("Stack Underflow", ex.getMessage());
		}
	}

	@Test
	public void testPopStackUsingList() {
		// Deleting Element from Stack
		assertEquals("Wall", stackList.pop());
		assertEquals("the", stackList.pop());
	}

	@Test
	public void testPushStackUsingList() {
		// Adding Element in Stack
		assertTrue(stackList.push("Street"));
	}

	@Test
	public void testTopElementStackUsingList() {
		// Top Element in Stack
		assertEquals("Wall", stackList.top());
	}

	@Test
	public void testIsEmptyStackUsingList() {
		// Checking Whether the Stack is Empty or not
		assertFalse(stackList.isEmpty());
	}

	@Test
	public void testPushStackUsingListOverflow() {
		// Adding element when Stack is Full
		try {
			stackList.push("Street");
			stackList.push("Directed");
		} catch (ArrayIndexOutOfBoundsException ex) {
			assertEquals("Element can't be Add, Stack is Full", ex.getMessage());
		}
	}

	@Test
	public void testPopStackUsingListUnderflow() {
		// Deleting element from an Empty Stack
		try {
			stackList.pop();
			stackList.pop();
			stackList.pop();
			stackList.pop();
			stackList.pop();
		} catch (ArrayIndexOutOfBoundsException ex) {
			assertEquals("Stack Underflow", ex.getMessage());
		}
	}
}
