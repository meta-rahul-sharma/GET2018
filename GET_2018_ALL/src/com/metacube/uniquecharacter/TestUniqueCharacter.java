package com.metacube.uniquecharacter;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs various tests on UniqueCharacters class
 * @author Rahul Sharma 
 * Creation Date: 8/8/2018
 */
public class TestUniqueCharacter {

	UniqueCharacter uniqueString;

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void init() {
		uniqueString = new UniqueCharacter();
		uniqueString.calculateUniqueCharacters("rahul");
		uniqueString.calculateUniqueCharacters("unique87987");
	}

	@Test
	public void testCalculateUniqueCharacters() {
		assertEquals(8,
				uniqueString.calculateUniqueCharacters("vakiya so vakiya"));
	}

	@Test
	public void testCalculateUniqueCharactersAlreadyStored() {
		assertEquals(5, uniqueString.calculateUniqueCharacters("hulra"));
		assertEquals(5, uniqueString.calculateUniqueCharacters("gurjar"));
	}

	@Test
	public void testCalculateUniqueCharactersWithNull() {
		ex.expect(NullPointerException.class);
		ex.expectMessage("Input String Can't be Null");
		uniqueString.calculateUniqueCharacters(null);
		assertEquals(true, false);
	}
}
