package com.metacube.zoo;

/**
 * Implementation animal class which include details related to an animal
 * @author Rahul Sharma
 * Creation date: 29/7/2018
 */
public class Animal {
	String name;
	int age, weight, zoneNo, cageNo;
	String sound;

	public String getSound() {
		return sound;
	}

	public String getInfo() {
		return name + " " + String.valueOf(age) + " " + String.valueOf(weight) + " " + getSound();
	}
	
	public String getName() {
		return name;
	}
	
	public int cageNo() {
		return cageNo;
	}
	
	public int zoneNo() {
		return zoneNo;
	}
}
