package com.metacube.zoo;

/**
 * Implementation of Zones of a zoo Class
 * @author Rahul Sharma
 * Creation date: 29/7/2018
 */
public class Zones {
	private int limitNumberOfCages;
	private boolean hasCanteen, hasPark;
	private String category;
	private int numberOfCages = 0;
	public Zones(int limitNumberOfCages, String category, boolean hasCanteen, boolean hasPark) {
		this.limitNumberOfCages = limitNumberOfCages;
		this.category = category;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	}
	
	public void increaseNumberOfCages() {
		numberOfCages++;
	}
	
	public int getLimitOfCages() {
		return limitNumberOfCages;
	}
	
	public int getCurrentNumberOfCages() {
		return numberOfCages;
	}
	
	public String getZoneCategory() {
		return category;
	}
}
