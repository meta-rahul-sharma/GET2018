package com.metacube.viratkohli;

/**
 * Implementation of Bowler Class where
 * we describe about properties of bowler
 * @author Rahul Sharma
 * Creation Date: 7/8/2018
 */
public class Bowler {
	int ball;
	String name;
	
	public Bowler(int ball, String name) throws MatchException {
		if(ball == 0) {
			throw new MatchException("Bowler not allowed with zero bowl");
		}
		
		if(name == null) {
			throw new NullPointerException("Bowler name can'nt be null");
		}
		this.ball = ball;
		this.name = name;
	}
	
	public void setBowl(int ball) {
		if(ball >= 0) {
			this.ball = ball;
		}
	}
	
	public int getBall() {
		return ball;
	}
	
	public String getBowler() {
		return name;
	}
}
