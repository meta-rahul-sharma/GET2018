package com.metacube.zoo;

import java.util.List;
import java.util.ArrayList;

/**
 * Implementation of zoo management system here we are managing 
 * 1. list of cages 
 * 2. list of zones
 * 3. list of animals
 * @author Rahul Sharma
 *
 */
public class Zoo {
	private List<Cage> cageList = new ArrayList<Cage>();
	private List<Zones> zoneList = new ArrayList<Zones>();
	private List<Animal> animalList = new ArrayList<Animal>();

	/**
	 * Used for initializing zoo Class
	 */
	public Zoo() {
		initialize();
	}

	/**
	 * Used for creating zone in a zoo
	 * @param numberOfCages
	 * @param category 
	 * @param hasCanteen
	 * @param hasPark
	 */
	public void addZone(int numberOfCages, String category, boolean hasCanteen,
			boolean hasPark) {
		if(category == null) {
			throw new NullPointerException("Category of animal in zone can't be null");
		}
		
		zoneList.add(new Zones(numberOfCages, category, hasCanteen, hasPark));
	}

	public void addCage(String animalType, int limitNumberOfAnimals, int zoneNo) {
		if (animalType == null) {
			throw new NullPointerException("Category of animal in cage can't be null");
		}
		if (zoneList.get(zoneNo - 1).getCurrentNumberOfCages() < zoneList.get(
				zoneNo - 1).getLimitOfCages() && zoneList.get(zoneNo - 1).getZoneCategory().equals(animalCategory(animalType))) {
			cageList.add(new Cage(animalType, limitNumberOfAnimals, zoneNo));
			zoneList.get(zoneNo - 1).increaseNumberOfCages();
		} else {
			throw new RuntimeException("Zone Cage Limit is already reached");
		}
	}

	/**
	 * Used for creating Animal in a cage
	 * @param name
	 * @param typeOfAnimal
	 * @param age
	 * @param weight
	 * @param zoneNo
	 * @param cageNo
	 */
	public void addAnimal(String name, String typeOfAnimal, int age,
			int weight, int zoneNo, int cageNo) {
		int index;
		for (index = 0; index < cageList.size(); index++) {
			if (cageNo == index + 1
					&& cageList.get(index).zoneNo() == zoneNo
					&& cageList.get(index).checkAvailabilityAndCompatibility(
							typeOfAnimal)) {
				switch (typeOfAnimal) {
				case "Lion":
					animalList.add(new Lion(name, age, weight, zoneNo, cageNo));
					cageList.get(index).increaseNumberOfAnimals();
					break;
				case "Deer":
					animalList.add(new Deer(name, age, weight, zoneNo, cageNo));
					cageList.get(index).increaseNumberOfAnimals();
					break;
				case "Crocodile":
					animalList.add(new Crocodile(name, age, weight, zoneNo,
							cageNo));
					cageList.get(index).increaseNumberOfAnimals();
					break;
				case "Snakes":
					animalList
							.add(new Snakes(name, age, weight, zoneNo, cageNo));
					cageList.get(index).increaseNumberOfAnimals();
					break;
				case "Peacock":
					animalList.add(new Peacock(name, age, weight, zoneNo,
							cageNo));
					cageList.get(index).increaseNumberOfAnimals();
					break;
				case "Duck":
					animalList.add(new Duck(name, age, weight, zoneNo, cageNo));
					cageList.get(index).increaseNumberOfAnimals();
					break;
				default:
					throw new RuntimeException("Animal Type do not match With Any Animal Type in Zoo");
				}
				break;
			}
		}

		if (index == cageList.size()) {
			throw new RuntimeException("Cage Not Available");
		}
	}

	/**
	 * To remove animal from animal list in zoo
	 * @param name
	 */
	public void removeAnimal(String name) {
		int index;
		for (index = 0; index < animalList.size(); index++) {
			System.out.println(animalList.get(index).getName());
			if (animalList.get(index).getName().equals(name)) {
				animalList.remove(index);
				cageList.get(animalList.get(index).cageNo())
						.decreaseNumberOfAnimals();
				break;
			}
		}

		if (index == animalList.size()) {
			throw new RuntimeException("No Animal by this name");
		}
	}

	/**
	 * To get name of the all animal in the zoo
	 */
	public void getInfo() {
		for (int i = 0; i < animalList.size(); i++) {
			System.out.println(animalList.get(i).getName());
		}
	}

	/**
	 * To search animal in the animal list of the zoo
	 * @param nameOfAnimal
	 * @return Full info about the animal
	 */
	public String search(String nameOfAnimal) {
		String info = null;
		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i).getName() == nameOfAnimal) {
				info = animalList.get(i).getInfo();
				break;
			}
		}
		return info;
	}

	/**
	 * @return Number of animals in the zoo
	 */
	public int totalAnimals() {
		return animalList.size();
	}
	
	/**
	 * @return Number of zone in zoo
	 */
	public int numberOfZone() {
		return zoneList.size();
	}

	/**
	 * @return Number of cages in zoo
	 */
	public int numberOfCage() {
		return cageList.size();
	}
	
	/**
	 * @param animalType
	 * @return category of the type of animal example Mammle category of Lion type animal
	 */
	private String animalCategory(String animalType) {
		String category = null;
		switch (animalType) {
		case "Lion":
			category = "Mammal";
			break;
		case "Deer":
			category = "Mammal";
			break;
		case "Crocodile":
			category = "Reptile";
			break;
		case "Snakes":
			category = "Reptile";
			break;
		case "Peacock":
			category = "Birds";
			break;
		case "Duck":
			category = "Birds";
			break;
		default:
			throw new RuntimeException("Animal Type do not match");
		}
		return category;
	}

	/**
	 * To initialize zoo animals, zoo cages, zoo zone's
	 */
	private void initialize() {
		zoneList.clear();
		cageList.clear();
		animalList.clear();

		addZone(5, "Mammal", true, false);
		addZone(3, "Birds", true, true);
		addZone(2, "Reptile", false, false);

		addCage("Lion", 5, 1);
		addCage("Deer", 5, 1);
		addCage("Peacock", 5, 2);
		addCage("Duck", 2, 2);
		addCage("Crocodile", 5, 3);
		addCage("Snakes", 5, 3);

		addAnimal("Lion-1", "Lion", 5, 80, 1, 1);
		addAnimal("Lion-2", "Lion", 15, 85, 1, 1);
		addAnimal("Lion-3", "Lion", 20, 90, 1, 1);
		addAnimal("Deer-1", "Deer", 5, 30, 1, 2);
		addAnimal("Deer-2", "Deer", 8, 40, 1, 2);
		addAnimal("Peacock-1", "Peacock", 12, 8, 2, 3);
		addAnimal("Peacock-2", "Peacock", 14, 10, 2, 3);
		addAnimal("Peacock-3", "Peacock", 19, 12, 2, 3);
		addAnimal("Duck-1", "Duck", 4, 5, 2, 4);
		addAnimal("Duck-2", "Duck", 6, 7, 2, 4);
		addAnimal("Crocodile-1", "Crocodile", 45, 300, 3, 5);
		addAnimal("Crocodile-2", "Crocodile", 50, 320, 3, 5);
		addAnimal("Crocodile-3", "Crocodile", 54, 430, 3, 5);
		addAnimal("Crocodile-4", "Crocodile", 56, 510, 3, 5);
		addAnimal("Snakes-1", "Snakes", 15, 10, 3, 6);
		addAnimal("Snakes-2", "Snakes", 21, 20, 3, 6);
		addAnimal("Snakes-3", "Snakes", 24, 30, 3, 6);
		addAnimal("Snakes-4", "Snakes", 14, 40, 3, 6);
	}
}
