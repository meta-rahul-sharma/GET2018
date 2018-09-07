package com.metacube.training;

/**
 * User defined object person
   @author Rahul Sharma
 * Creation DATE: 05/09/2018
 */
public class Person {
    private String type;

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void checkType() {
        System.out.println(type);
    }
}