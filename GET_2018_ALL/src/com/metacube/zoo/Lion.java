package com.metacube.zoo;

/**
 * Implementation of Lion class which extends Mammal class
 * @author Rahul Sharma
 * Creation date: 29/7/2018
 */
public class Lion extends Mammal {
	public Lion(String name, int age, int weight, int zoneNo, int cageNo) {
		super.sound = "roar";
		super.name = name;
		super.age = age;
		super.weight = weight;
		super.cageNo = cageNo;
		super.zoneNo = zoneNo;
	}
}
