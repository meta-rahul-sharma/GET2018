package com.metacube.stack;

/**
 * @author Rahul Sharma
 * @param <Type> GenericType
 * Creation Date: 1/8/2018
 */
public interface Stack <Type> {
	
	/**
	 * To Push the given element to Stack
	 * @param new_element
	 * @throws StackException 
	 */
	public void push(Type newElement) throws StackException;

	/**
	 * To Pop the Top Element in Stack and return it
	 * @return Popped Element from Stack
	 * @throws StackException 
	 */
	public Type pop() throws StackException;

	/**
	 * It checks whether the Stack is Empty or not
	 * @return true if the Stack is Empty
	 */
	public boolean isEmpty();

	/**
	 * It returns the Top Element of Stack
	 * @return Top Element Stored at Stack
	 */
	public Type top();
}
