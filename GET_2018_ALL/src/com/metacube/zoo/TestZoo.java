package com.metacube.zoo;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
/**
 * 
 * @author Rahul Sharma
 * At time of Initialization 
 * numberOfZones = 3
 * numberOfCages = 6
 * numberOfAnimals = 18
 */
public class TestZoo {

	@Test
	public void getInfoTest() {
		Zoo zoo = new Zoo();
		zoo.getInfo();
	}
	
	@Test
	public void addZoneTest() {
		Zoo zoo = new Zoo();
		zoo.addZone(10, "Mammal", true, true);
		assertEquals(4, zoo.numberOfZone());
	}
	
	@Test
	public void addCageTest() {
		Zoo zoo = new Zoo();
		zoo.addCage("Peacock", 1, 2);
		assertEquals(7, zoo.numberOfCage());
	}
	
	@Test
	public void addAnimalTest() {
		Zoo zoo = new Zoo();
		zoo.addAnimal("Lion-4", "Lion", 23, 90, 1, 1);
		assertEquals(19, zoo.totalAnimals());
	}
	
	/**
	 * Adding animal in full cage
	 */
	@Test
	public void testAddAnimalWithCageNotAvailableException() {
		try{
		Zoo zoo = new Zoo();
		zoo.addAnimal("Duck-3", "Duck", 23, 90, 2, 4);
		} catch(RuntimeException ex) {
			assertEquals("Cage Not Available", ex.getMessage());
		}
	}
	
	@Test
	public void addZoneWithNullCategory() {
		try {
			Zoo zoo = new Zoo();
			zoo.addZone(10, null, true, true);
		} catch (NullPointerException ex) {
			assertEquals("Category of animal in zone can't be null", ex.getMessage());
		}
	}
	
	@Test
	public void addCageWithNullCategory() {
		try {
			Zoo zoo = new Zoo();
			zoo.addCage(null, 4, 5);
		} catch (NullPointerException ex) {
			assertEquals("Category of animal in cage can't be null", ex.getMessage());
		}
	}
	
	@Test
	public void removeAnimalTest() {
		Zoo zoo = new Zoo();
		zoo.removeAnimal("Lion-3");
		assertEquals(17, zoo.totalAnimals());
	}
	
	@Test
	public void removeAnimalTestWithWrongName() {
		try{
			Zoo zoo = new Zoo();
			zoo.removeAnimal("Lion-4");
		} catch(RuntimeException ex) {
			assertEquals("No Animal by this name", ex.getMessage());
		}
	}
	
	/**
	 * searchAnimal result is in string form
	 * where result is:
	 * animalName animalAge animalWeight animalSound
	 */
	@Test
	public void searchAnimal() {
		Zoo zoo = new Zoo();
		String info = zoo.search("Lion-3");
		assertEquals("Lion-3 20 90 roar", info);
	}
}
