package com.metacube.viratkohli;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * To test Match class method which give order or bowler's
 * so virat can perform minimum
 * @author Rahul Sharma
 * Creation Date: 7/8/2018
 */
public class TestMatch {

	Match match = null;
	
	@Before
	public void Initialize() throws MatchException {
		match = new Match();
		match.addBowler(8, "rahul");
		match.addBowler(3, "chirag");
		match.addBowler(1, "mohit");
	}
	
	@Test
	public void test1() throws MatchException {
		
		
		match.totalBall();
		List<Bowler> names = match.viratMinimumRun();
		List<Bowler>  result = new ArrayList<Bowler>();
		result.add(new Bowler(6, "rahul"));
		result.add(new Bowler(1, "chirag"));
		result.add(new Bowler(1, "rahul"));
		result.add(new Bowler(1, "chirag"));
		result.add(new Bowler(1, "rahul"));
		result.add(new Bowler(1, "chirag"));
		result.add(new Bowler(1, "mohit"));
		for(int i = 0; i < result.size(); i++) {
			assertEquals(names.get(i).getBall(), result.get(i).getBall());
			assertEquals(names.get(i).getBowler(), result.get(i).getBowler());
		}
	}

	@Test
	public void test2() throws MatchException {
		match.addBowler(4, "bobby");
		
		match.totalBall();
		List<Bowler> names = match.viratMinimumRun();
		List<Bowler>  result = new ArrayList<Bowler>();
		result.add(new Bowler(5, "rahul"));
		result.add(new Bowler(1, "bobby"));
		result.add(new Bowler(1, "rahul"));
		result.add(new Bowler(1, "chirag"));
		result.add(new Bowler(1, "bobby"));
		result.add(new Bowler(1, "rahul"));
		result.add(new Bowler(1, "chirag"));
		result.add(new Bowler(1, "bobby"));
		result.add(new Bowler(1, "rahul"));
		result.add(new Bowler(1, "chirag"));
		result.add(new Bowler(1, "mohit"));
		result.add(new Bowler(1, "bobby"));
		for(int i = 0; i < result.size(); i++) {
			assertEquals(names.get(i).getBall(), result.get(i).getBall());
			assertEquals(names.get(i).getBowler(), result.get(i).getBowler());
		}
	}
	
	@Test
	public void bowlerWithZeroBallException() {
		try {
			match.addBowler(0, "mohit");
			assertEquals(true, false);
		} catch (MatchException ex) {
			assertEquals("Bowler not allowed with zero bowl", ex.getMessage());
		}
	}
	
	@Test
	public void bowlerWithNullNameException() throws MatchException {
		try {
			match.addBowler(1, null);
			assertEquals(true, false);
		} catch (NullPointerException ex) {
			assertEquals("Bowler name can'nt be null", ex.getMessage());
		}
	}
}
