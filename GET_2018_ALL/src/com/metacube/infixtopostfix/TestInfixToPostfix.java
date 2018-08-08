package com.metacube.infixtopostfix;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.stack.StackException;

/**
 * Used for testing purposes
 * @author Rahul Sharma Creation Date : 3/8/2018
 */
public class TestInfixToPostfix {

	@Test
	public void testInfixToPostfix1() throws StackException, InfixToPostfixException {
		InfixToPostfix getPostfix = new InfixToPostfix();
		String postfix = getPostfix.infixToPostfix("2 + 3 * 4");
		assertEquals("234*+", postfix);
	}

	@Test
	public void testInfixToPostfix2() throws StackException, InfixToPostfixException {
		InfixToPostfix getPostfix = new InfixToPostfix();
		String postfix = getPostfix.infixToPostfix("a * b + 4");
		assertEquals("ab*4+", postfix);
	}

	@Test
	public void testInfixToPostfix3() throws StackException, InfixToPostfixException {
		InfixToPostfix getPostfix = new InfixToPostfix();
		String postfix = getPostfix.infixToPostfix("a * ( b + c )");
		assertEquals("abc+*", postfix);
	}
	
	@Test
	public void testInfixToPostfix4() throws StackException, InfixToPostfixException {
		InfixToPostfix getPostfix = new InfixToPostfix();
		String postfix = getPostfix.infixToPostfix("( ) ( )");
		assertEquals("", postfix);
	}

	@Test
	public void testWrongInfixExpression() throws StackException {
		try {
		InfixToPostfix getPostfix = new InfixToPostfix();
		String postfix = getPostfix.infixToPostfix("a * b + c )");
		assertEquals(true, false);
		} catch(InfixToPostfixException ex) {
			assertEquals("wrong infix expression", ex.getMessage());
		}
	}
	
	@Test
	public void testInfixNullException() throws StackException {
		try {
		InfixToPostfix getPostfix = new InfixToPostfix();
		String postfix = getPostfix.infixToPostfix(null);
		assertEquals(true, false);
		} catch(InfixToPostfixException ex) {
			assertEquals("infix can not be null", ex.getMessage());
		}
	}
}
