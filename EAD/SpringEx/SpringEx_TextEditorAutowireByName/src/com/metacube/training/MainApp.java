package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class Implements TextEditor
 * @author Rahul Sharma
 * Creation DATE: 05/09/2018
 */
public class MainApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.spellCheck();
	}
}
