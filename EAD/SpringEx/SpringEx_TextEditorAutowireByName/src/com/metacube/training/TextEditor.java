package com.metacube.training;

/**
 * This class performs operations in Text Editor
   @author Rahul Sharma
 * Creation DATE: 05/09/2018
 */
public class TextEditor {
	private SpellChecker spellChecker1;
	private SpellChecker spellChecker2;
	private SpellChecker spellChecker3;

	public SpellChecker getSpellChecker1() {
		return spellChecker1;
	}

	public SpellChecker getSpellChecker2() {
		return spellChecker2;
	}

	public SpellChecker getSpellChecker3() {
		return spellChecker3;
	}

	public void setSpellChecker1(SpellChecker spellChecker1) {
		this.spellChecker1 = spellChecker1;
	}

	public void setSpellChecker2(SpellChecker spellChecker2) {
		this.spellChecker2 = spellChecker2;
	}

	public void setSpellChecker3(SpellChecker spellChecker3) {
		this.spellChecker3 = spellChecker3;
	}
	
	public void spellCheck() {
        spellChecker1.checkSpelling();
        spellChecker2.checkSpelling();
        spellChecker3.checkSpelling();
    }

}
