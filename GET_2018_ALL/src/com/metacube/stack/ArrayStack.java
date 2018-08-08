package com.metacube.stack;

/**
 * Implementing Stack interface and methods are provided
 * using array
 * @author Rahul Sharma
 * @param <Type> GenericType
 * Creation Date: 1/8/2018
 */
public class ArrayStack<Type> implements Stack<Type> {
	private int top = 0;
	private int maxSize;
	private Type[] stack;
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = (Type[]) new Object[maxSize];
	}
	
	@Override
	public void push(Type newElement) throws StackException {
		if(isFull()) {
			throw new StackException("stack is full");
		} else {
			stack[top++] = newElement;
		}
	}

	@Override
	public Type pop() {
		Type item;
		if(isEmpty()) {
			throw new RuntimeException("stack is empty");
		} else {
			item = stack[--top];
		}
		return item;
	}

	@Override
	public boolean isEmpty() {
		return (top == 0);
	}

	@Override
	public Type top() {
		Type top = null;
		if(isEmpty()) {
			throw new RuntimeException("stack is empty");
		} else {
			top = stack[this.top - 1];
		}
		return top;
	}

	private boolean isFull() {
		return top == maxSize;
	}
}
