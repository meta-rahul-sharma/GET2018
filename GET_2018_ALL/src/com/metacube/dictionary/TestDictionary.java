package com.metacube.dictionary;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * JUnit to test implementation of Dictionary
 * @author Rahul Sharma
 * Creation Date: 9/8/2018
 */
public class TestDictionary {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	
	ImplementDictionary dictionary;
	@Before
	public void initializeJsonFile() throws FileNotFoundException, IOException, ParseException, DictionaryException {
		File file = new File("dictionary.json");
		dictionary = new ImplementDictionary();
		dictionary.addJsonDictionary(file);
	}
	
	@Test
	public void getWordMeaning1() throws DictionaryException {
		assertEquals("eatable", dictionary.getMeaning("fruit"));
	}
	
	@Test
	public void getWordMeaning2() throws DictionaryException {
		assertEquals("outdoor game", dictionary.getMeaning("vollyball"));
	}
	
	@Test
	public void wordNotInDictionaryException() throws DictionaryException {
		exception.expectMessage("Word is not in Dictionary");
		dictionary.getMeaning("aflatoon");
		assertEquals(true, false);
	}
	
	@Test
	public void sortedWordDictionary() {
		Map<String, String> sortedListResult = dictionary.sortedWordDictionary();
		Map<String, String> sortedListExpected = new HashMap<String, String>();
		sortedListExpected.put("anxiety", "chinta");
		sortedListExpected.put("cat" , "a mammal");
		sortedListExpected.put("data" , "facts");
		sortedListExpected.put("frog" , "an animal");
		sortedListExpected.put("fruit" , "eatable");
		sortedListExpected.put("hello" , "word used when meet");
		sortedListExpected.put("hitler" , "dictator");
		sortedListExpected.put("quota" , "reserved for something");
		sortedListExpected.put("tycoon" , "a good businessmen");
		sortedListExpected.put("vollyball" , "outdoor game");
		assertEquals(sortedListExpected, sortedListResult);
	}
	
	@Test
	public void sortedWordDictionaryInKeyRange() throws DictionaryException {
		Map<String, String> sortedListResult = dictionary.sortedWordDictionary("frog", "tycoon");
		Map<String, String> sortedListExpected = new HashMap<String, String>();
		sortedListExpected.put("frog" , "an animal");
		sortedListExpected.put("fruit" , "eatable");
		sortedListExpected.put("hello" , "word used when meet");
		sortedListExpected.put("hitler" , "dictator");
		sortedListExpected.put("quota" , "reserved for something");
		sortedListExpected.put("tycoon" , "a good businessmen");
		assertEquals(sortedListExpected, sortedListResult);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void wordCannotBeNullException() throws DictionaryException {
		exception.expectMessage("words can'nt be null");
		Map<String, String> sortedListResult = dictionary.sortedWordDictionary(null, "tycoon");
		assertEquals(true, false);
	}
	
	@Test
	public void deleteWord() throws DictionaryException {
		dictionary.deleteWord("frog");
	}
	
	@Test
	public void deleteWordException() throws DictionaryException {
		exception.expectMessage("Word is not in Dictionary");
		dictionary.deleteWord("crog");
		assertEquals(true, false);
	}
	
	@Test
	public void duplicateWordException() throws DictionaryException {
		exception.expectMessage("Duplicate Word");
		dictionary.addWord("frog", "an animal");
		assertEquals(true, false);
	}
}
