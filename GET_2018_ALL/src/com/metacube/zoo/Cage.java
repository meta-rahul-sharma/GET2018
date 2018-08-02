package com.metacube.zoo;

/**
 * Implementation of Cage class which specify data members and 
 * functions about Cage of the Animal in a zoo
 * @author Rahul Sharma
 * Creation date: 29/7/2018
 */
public class Cage {
	String animalType;
	int limitNumberOfAnimals;
	int numberOfAnimals = 0;
	int zoneNo;

	/**
	 * Used for initialization of Cage class
	 * Parameterized constructor of Cage class
	 * @param animalType
	 * @param limitNumberOfAnimals
	 * @param zoneNo
	 */
	public Cage(String animalType, int limitNumberOfAnimals, int zoneNo) {
		this.animalType = animalType;
		this.limitNumberOfAnimals = limitNumberOfAnimals;
		this.zoneNo = zoneNo;
	}
	
	/**
	 * To check if we can insert Animal in a cage or not
	 * @param typeOfAnimal
	 * @return true if compitable
	 */
	public boolean checkAvailabilityAndCompatibility(String typeOfAnimal) {
		boolean result = false;
		if(numberOfAnimals < limitNumberOfAnimals && typeOfAnimal.equals(animalType)) {
			result = true;
		}
		return result;
	}
	
	/**
	 * @return numberOfAnimals in a cage
	 */
	public int getNumberOfAnimals() {
		return numberOfAnimals;
	}
	
	public void decreaseNumberOfAnimals() {
		numberOfAnimals--;
	}
	
	public void increaseNumberOfAnimals() {
		numberOfAnimals++;
	}
	
	public int zoneNo() {
		return zoneNo;
	}
	
	public int totalCapacity(int zoneId, int cageId) {
		return numberOfAnimals;
	}
	
	public int spareCapacity() {
		return limitNumberOfAnimals - numberOfAnimals;
	}
}
