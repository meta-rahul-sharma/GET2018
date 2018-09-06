package com.metacube.training;

/**
 * This class performs operations in Text Editor
   @author Rahul Sharma
 * Creation DATE: 05/09/2018
 */
public class TextEditor {
	private SpellChecker spellChecker;

	public TextEditor(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	/**
	 * Checks Spelling of a Word
	 * 
	 * @param word
	 */
	public void spellCheck(String word) {
		spellChecker.checkSpelling(word);
	}
}