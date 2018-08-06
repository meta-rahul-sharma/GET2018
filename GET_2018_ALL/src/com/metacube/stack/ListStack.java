package com.metacube.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementing Stack interface and methods are provided
 * using LinkedList
 * @author Rahul Sharma
 * @param <Type> GenericType
 * Creation Date: 1/8/2018
 */
public class ListStack<Type> implements Stack<Type> {
	private List<Type> stack;

	public ListStack() {
		stack = new LinkedList<Type>();
	}

	@Override
	public void push(Type newElement) {
		stack.add(newElement);
	}

	@Override
	public Type pop() throws StackException {
		Type item;
		if (isEmpty()) {
			throw new StackException("stack is empty");
		} else {
			item = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
		}
		return item;
	}

	@Override
	public boolean isEmpty() {
		return (stack.size() == 0);
	}

	@Override
	public Type top() {
		return stack.get(stack.size() - 1);
	}
}
