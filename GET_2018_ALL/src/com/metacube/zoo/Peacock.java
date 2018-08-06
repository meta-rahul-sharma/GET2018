package com.metacube.zoo;

/**
 * Implementation of Peacock class which extends Bird class
 * @author Rahul Sharma
 * Creation date: 29/7/2018
 */
public class Peacock extends Bird {
	public Peacock(String name, int age, int weight, int zoneNo, int cageNo) {
		super.sound = "scream";
		super.name = name;
		super.age = age;
		super.weight = weight;
		super.cageNo = cageNo;
		super.zoneNo = zoneNo;
	}
}
