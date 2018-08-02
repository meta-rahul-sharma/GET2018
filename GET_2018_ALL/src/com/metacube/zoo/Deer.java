package com.metacube.zoo;

/**
 * Implementation of Deer class which extends Mammal class
 * @author Rahul Sharma
 * Creation date: 29/7/2018
 */
public class Deer extends Mammal {
	public Deer(String name, int age, int weight, int zoneNo, int cageNo) {
		super.sound = "fawn";
		super.name = name;
		super.age = age;
		super.weight = weight;
		super.cageNo = cageNo;
		super.zoneNo = zoneNo;
	}
}
