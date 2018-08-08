package com.metacube.zoo;

/**
 * Implementation of Crocodile class which extends Reptile class
 * @author Rahul Sharma
 * Creation date: 29/7/2018
 */
public class Crocodile extends Reptile {
	public Crocodile(String name, int age, int weight, int zoneNo, int cageNo) {
		super.sound = "hissing";
		super.name = name;
		super.age = age;
		super.weight = weight;
		super.cageNo = cageNo;
		super.zoneNo = zoneNo;
	}
}
