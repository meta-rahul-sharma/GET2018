package com.metacube.evaluatepostfix;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.stack.StackException;

/**
 * 
 * @author Rahul Sharma
 * Creation Date : 3/8/2018
 */
public class TestEvaluatePostfix {

	@Test
	public void test() throws StackException, EvaluatePostfixException {
		EvaluatePostfix evaluate = new EvaluatePostfix();
		double result = evaluate.evaluatePostfix("2 3 1 * + 9 -");
		assertEquals(-4, result, 0.00);
	}
	
	@Test
	public void test1() throws StackException, EvaluatePostfixException {
		EvaluatePostfix evaluate = new EvaluatePostfix();
		double result = evaluate.evaluatePostfix("2 3 1 * + 9 - 78 +");
		assertEquals(74, result, 0.00);
	}
	
	@Test
	public void testWrongPostfixExpressionException() throws StackException {
		try {
		EvaluatePostfix evaluate = new EvaluatePostfix();
		double result = evaluate.evaluatePostfix("2 3 1 * + 9");
		assertEquals(true, false);
		} catch(EvaluatePostfixException ex) {
			assertEquals("Wrong postfix expression", ex.getMessage());
		}
	}
	
	@Test
	public void testWrongPostfixExpressionException1() throws StackException {
		try {
		EvaluatePostfix evaluate = new EvaluatePostfix();
		double result = evaluate.evaluatePostfix("2 3 1 * + 9 - +");
		assertEquals(true, false);
		} catch(EvaluatePostfixException ex) {
			assertEquals("Wrong postfix expression", ex.getMessage());
		}
	}
	
	@Test
	public void testNullPointerException() throws StackException, EvaluatePostfixException {
		try {
		EvaluatePostfix evaluate = new EvaluatePostfix();
		double result = evaluate.evaluatePostfix(null);
		assertEquals(true, false);
		} catch(NullPointerException ex) {
			assertEquals("postfix Expression cann't be null", ex.getMessage());
		}
	}
}
