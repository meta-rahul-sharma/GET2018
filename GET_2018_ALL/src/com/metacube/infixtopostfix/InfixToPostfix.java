package com.metacube.infixtopostfix;

import java.util.ArrayList;
import java.util.List;

import com.metacube.stack.*;

/**
 * For implementing infix to postfix conversion methods
 * @author Rahul Sharma
 * Creation Date : 3/8/2018
 */
public class InfixToPostfix {

	/**
	 * @param infix
	 * @return postfix as string
	 * @throws StackException 
	 * @throws InfixToPostfixException 
	 */
	public String infixToPostfix(String infix) throws StackException, InfixToPostfixException {
		if(infix == null) {
			throw new InfixToPostfixException("infix can not be null");
		}
		List<String> tokens = tokenize(infix);
		Stack<String> stack = new ListStack<String>();
		String postfix = "";
		
		for (int i = 0, j = tokens.size(); i < j; i++) {
			String token = tokens.get(i);
			if(!isOperator(token)) {
				postfix += token;
			} else if("(".equals(token)) {
				stack.push(token);
			} else if(")".equals(token)) {
				
				while(!stack.isEmpty() && !"(".equals(stack.top()) ) { // checking to close bracket
					postfix += stack.pop();
				} 
				
				if(!stack.isEmpty() && "(".equals(stack.top()) ) {
					stack.pop();
				} else {
					throw new InfixToPostfixException("wrong infix expression");
				}
				
			} else {
				// <= is providing left to right associativity
				while(!stack.isEmpty() && precedence(token) <= precedence(stack.top())) {
					postfix += stack.pop();
				} 
				stack.push(token);
			}
		}
		
		while(!stack.isEmpty()) {
			postfix += stack.pop();
		}
		
		return postfix;
	}

	/**
	 * @param infix
	 * @return List of string tokens which give operands as well as operator out of infix string
	 */
	private List<String> tokenize(String infix) {
		List<String> word = new ArrayList<String>();
		String wordTaker = "";
		for (int i = 0, j = infix.length(); i < j; i++) {
			if ((char) infix.charAt(i) == ' ' || i == infix.length() - 1) {

				if (i == infix.length() - 1) {
					wordTaker = wordTaker
							+ infix.charAt(infix.length() - 1);
					word.add(wordTaker);
				} else {
					word.add(wordTaker);
				}
				wordTaker = "";
			} else {
				wordTaker = wordTaker + infix.charAt(i);
			}
		}
		return word;
	}
	
	/**
	 * Provide different precedence to different operator
	 * @param operator
	 * @return precedence value
	 */
	private int precedence(String operator) {
		int precedence = 0 ;
		switch(operator) {
		case "||":
			precedence = 1;
			break;
		
		case "&&":
			precedence = 2;
			break;
		
		case "==":
		case "!=":
			precedence = 3;
			break;
		
		case "<":
		case ">":
		case "<=":
		case ">=":
			precedence = 4;
			break;
		
		case "+":
		case "-":
			precedence = 5;
			break;
		
		case "*":
		case "/":
			precedence = 6;
			break;
		}
		return precedence;
	}
	
	/**
	 * @param operator
	 * @return true if string is in the list of operators
	 */
	private boolean isOperator(String operator) {
		boolean isOperator = false;
		switch(operator) {
		case "||":
		case "&&":
		case "==":
		case "!=":
		case "<":
		case ">":
		case "<=":
		case ">=":
		case "+":
		case "-":	
		case "*":
		case "/":
		case "(":
		case ")":
			isOperator = true;
		}
		return isOperator;
	}
}
