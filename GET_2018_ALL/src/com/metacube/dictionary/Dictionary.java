package com.metacube.dictionary;

import java.util.Map;

/**
 * Interface for Dictionary where we are storing key as our
 * Dictionary word and value as our Dictionary meaning
 * @author Rahul Sharma
 * Creation Date: 9/8/2018
 */
public interface Dictionary {
	public void addWord(String word, String meaning) throws DictionaryException;
	public void deleteWord(String word) throws DictionaryException;
	public String getMeaning(String word) throws DictionaryException;
	public Map<String, String> sortedWordDictionary();
	public Map<String, String> sortedWordDictionary(String wordFirst, String wordSecond) throws DictionaryException;
}
