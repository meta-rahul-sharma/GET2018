package com.metacube.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Implementing methods of Dictionary Interface and also
 * getting data from json file
 * @author Rahul Sharma
 * Creation Date: 9/8/2018
 */
public class ImplementDictionary implements Dictionary {

	Map<String, String> dictionary = new TreeMap<String, String>();
	
	/**
	 * To add dictionary from json file
	 * @param jsonValue
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws DictionaryException
	 */
	public void addJsonDictionary(File jsonValue) throws FileNotFoundException, IOException, ParseException, DictionaryException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(jsonValue));
		
		//keySet() gives us all keys of JSONObject
		for(Object key: obj.keySet()) {
			addWord(key.toString(), obj.get(key).toString());
		}
	}
	
	/**
	 * To add word and its meaning in the dictionary
	 */
	@Override
	public void addWord(String word, String meaning) throws DictionaryException {
		if(word == null) {
			throw new DictionaryException("words can'nt be null");
		}
		if(!dictionary.containsKey(word.trim())) {
			dictionary.put(word.trim(), meaning.trim());
		} else {
			throw new DictionaryException("Duplicate Word");
		}
	}

	/**
	 * To delete word and its meaning from the dictionary iff
	 * it contains word
	 */
	@Override
	public void deleteWord(String word) throws DictionaryException {
		if(word == null) {
			throw new DictionaryException("words can'nt be null");
		}

		if(dictionary.containsKey(word.trim())) {
			dictionary.remove(word.trim());
		} else {
			throw new DictionaryException("Word is not in Dictionary");
		}
	}

	/**
	 * To getMeaning of word from Dictionary iff it contains word
	 */
	@Override
	public String getMeaning(String word) throws DictionaryException {
		String meaning = null;
		if(dictionary.containsKey(word.trim())) {
			meaning = dictionary.get(word.trim());
		} else {
			throw new DictionaryException("Word is not in Dictionary");
		}
		return meaning;
	}

	/**
	 * To give sorted dictionary by words of dictionary
	 */
	@Override
	public Map<String, String> sortedWordDictionary() {
		Map<String, String> sortedDictionary = new HashMap<String, String>();
		for(String key: dictionary.keySet()) {
			sortedDictionary.put(key, dictionary.get(key));	
		}
		return sortedDictionary;
	}

	/**
	 * To give sorted dictionary from wordFirst to wordSecond where wordFirst < wordSecond
	 */
	@Override
	public Map<String, String> sortedWordDictionary(String wordFirst, String wordSecond) throws DictionaryException {
		if(wordFirst == null || wordSecond == null) {
			throw new DictionaryException("words can'nt be null");
		}
		
		Map<String, String> dictionaryInRange = new HashMap<String, String>();
		for(String key: dictionary.keySet()) {
			if(key.compareTo(wordFirst) >= 0 && key.compareTo(wordSecond) <= 0) {
				dictionaryInRange.put(key, dictionary.get(key));
			}
		}
		return dictionaryInRange;
	}

}
