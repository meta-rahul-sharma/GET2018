package com.metacube.viratkohli;

/**
 * Implementation of Bowler Class where
 * we describe about properties of bowler
 * @author Rahul Sharma
 * Creation Date: 7/8/2018
 */
public class Bowler {
	int bowl;
	String name;
	
	public Bowler(int bowl, String name) throws MatchException {
		if(bowl == 0) {
			throw new MatchException("Bowler not allowed with zero bowl");
		}
		
		if(name == null) {
			throw new NullPointerException("Bowler name can'nt be null");
		}
		this.bowl = bowl;
		this.name = name;
	}
	
	public void setBowl(int bowl) {
		if(bowl >= 0) {
			this.bowl = bowl;
		}
	}
	
	public int getBowl() {
		return bowl;
	}
	
	public String getBowler() {
		return name;
	}
}
