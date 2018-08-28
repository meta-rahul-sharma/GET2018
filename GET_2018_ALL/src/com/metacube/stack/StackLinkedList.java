package GET2018.DSA.DSSession1.Stack;

import java.util.LinkedList;

/**
 * It is used for implementation of Stack using Linked List
 * 
 * @author Mohit Sharma
 *
 */
public class StackLinkedList implements Stack {
	private int topElement = -1;
	LinkedList<String> stackLinkedList = new LinkedList<>();

	@Override
	public boolean push(String newElement) {
		if (topElement == STACK_SIZE) {
			throw new ArrayIndexOutOfBoundsException(
					"Element can't be Add, Stack is Full");
		}
		topElement++;
		stackLinkedList.add(newElement);
		return true;
	}

	@Override
	public String pop() {
		if (topElement == -1) {
			throw new ArrayIndexOutOfBoundsException("Stack Underflow");
		}
		String deletedItem;
		deletedItem = stackLinkedList.remove(topElement);
		topElement--;
		return deletedItem;
	}

	@Override
	public boolean isEmpty() {
		return (topElement == -1 ? true : false);
	}

	@Override
	public String top() {
		if (topElement == -1) {
			throw new ArrayIndexOutOfBoundsException("Stack is Empty");
		} else {
			return stackLinkedList.get(topElement);
		}
	}
}
