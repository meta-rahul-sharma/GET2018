package com.metacube.training;

/**
 * This class checks spelling of Words for TextEditor
 * @author Rahul Sharma
 * Creation DATE: 05/09/2018
 */
public class SpellChecker {
	private String word;

	 public void setWord(String word) {
		 this.word=word;
	 }
	
	public String getWord() {
		return word;
	}

	public void checkSpelling() {
		System.out.println("checkSpelling " + getWord());
	}
}