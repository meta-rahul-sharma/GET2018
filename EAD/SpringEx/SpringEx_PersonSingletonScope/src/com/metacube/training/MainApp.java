package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class performs operations in Text Editor
   @author Rahul Sharma
 * Creation DATE: 05/09/2018
 */
public class MainApp {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
          Person person = (Person) context.getBean("person");
          person.checkType();
          person.setType("Admin");
          person.checkType();
          Person otherPerson = (Person) context.getBean("person");
          otherPerson.checkType();
    }
}