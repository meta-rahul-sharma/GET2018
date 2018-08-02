package com.metacube.zoo;

/**
 * Implementation of Snakes class which extends Reptile class
 * @author Rahul Sharma
 * Creation date: 29/7/2018
 */
public class Snakes extends Reptile {
	public Snakes(String name, int age, int weight, int zoneNo, int cageNo) {
		super.sound = "hiss";
		super.name = name;
		super.age = age;
		super.weight = weight;
		super.cageNo = cageNo;
		super.zoneNo = zoneNo;
	}
}
