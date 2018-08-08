package com.metacube.evaluatepostfix;

import java.util.ArrayList;
import java.util.List;

import com.metacube.stack.*;
/**
 * To implement postfix evaluation
 * @author Rahul Sharma
 * Creation Date : 3/8/2018
 */
public class EvaluatePostfix {

	/**
	 * Evaluating postfix expression result
	 * @param postfix
	 * @return result of postfix
	 * @throws StackException 
	 * @throws EvaluatePostfixException 
	 */
	public double evaluatePostfix(String postfix) throws StackException, EvaluatePostfixException {
		if(postfix == null) {
			throw new NullPointerException("postfix Expression cann't be null");
		}
		Stack<Double> stack = new ListStack<Double>();
		List<String> tokens = tokenize(postfix);
		for (int i = 0, j = tokens.size(); i < j; i++) {
			if("+".equals(tokens.get(i)) || "-".equals(tokens.get(i)) || "*".equals(tokens.get(i)) ||
					"/".equals(tokens.get(i))) {
				//first popped element is second operand in evaluation of new stack element
				double secondOperand = stack.pop();
				if(stack.isEmpty()) {
					throw new EvaluatePostfixException("Wrong postfix expression");
				}
				//second popped element is first operand in evaluation of new stack element
				double firstOperand = stack.pop();
				double result = evaluate(firstOperand, secondOperand, tokens.get(i));
				stack.push(result);
			} else {
				stack.push(Double.parseDouble(tokens.get(i)));
			}
		}
		
		double result = stack.pop();
		
		if(!stack.isEmpty()) {
			throw new EvaluatePostfixException("Wrong postfix expression");
		}
		
		return result;
	}

	/**
	 * To convert given input postfix string into token
	 * which are divided by " "(spaces)
	 * @param postfix
	 * @return List of token string
	 */
	private List<String> tokenize(String postfix) {
		List<String> word = new ArrayList<String>();
		String wordTaker = "";
		for (int i = 0, j = postfix.length(); i < j; i++) {
			if ((char) postfix.charAt(i) == ' ' || i == postfix.length() - 1) {

				if (i == postfix.length() - 1) {
					wordTaker = wordTaker
							+ postfix.charAt(postfix.length() - 1);
					word.add(wordTaker);
				} else {
					word.add(wordTaker);
				}
				wordTaker = "";
			} else {
				wordTaker = wordTaker + postfix.charAt(i);
			}
		}
		return word;
	}
	
	/**
	 * @param firstOperand
	 * @param secondOperand
	 * @param operator
	 * @return Evaluated stack new element which will be used for further calculation or result
	 * @throws EvaluatePostfixException 
	 */
	private double evaluate(double firstOperand,double secondOperand, String operator) throws EvaluatePostfixException {
		double result;
		switch(operator) {
		case "+":
			result = firstOperand + secondOperand;
			break;
		case "-":
			result = firstOperand - secondOperand;
			break;
		case "*":
			result = firstOperand * secondOperand;
			break;
		case "/":
			try {
				result = firstOperand / secondOperand;
			} catch(Exception ex) {
				throw new EvaluatePostfixException("secondOperand in a evaluation is zero");
			}
			break;
		default :
			throw new EvaluatePostfixException("postfix expression wrong");
		}
		return result;
	}
}
