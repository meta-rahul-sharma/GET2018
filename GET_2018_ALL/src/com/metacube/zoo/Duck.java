package com.metacube.zoo;

/**
 * Implementation of Duck class which extends Bird class
 * @author Rahul Sharma
 * Creation date: 29/7/2018
 */
public class Duck extends Bird {
	public Duck(String name, int age, int weight, int zoneNo, int cageNo) {
		super.sound = "quack";
		super.name = name;
		super.age = age;
		super.weight = weight;
		super.cageNo = cageNo;
		super.zoneNo = zoneNo;
	}
}
