package com.metacube.uniquecharacter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * To implement method that takes a string and returns the number of unique
 * characters in the string
 * @author Rahul Sharma 
 * Creation Date: 8/8/2018
 */
public class UniqueCharacter {
	Map<String, Integer> chacheStrings = new HashMap<String, Integer>();

	/**
	 * Calculates Unique Characters in inputString
	 * @param userString
	 * @return
	 */
	public int calculateUniqueCharacters(String userString) {
		if (userString == null) {
			throw new NullPointerException("Input String Can't be Null");
		}

		int uniqueCharacter = 0;
		//trim() is used if user give spaces before or after string
		if(chacheStrings.containsKey(userString.trim())) {
			uniqueCharacter = chacheStrings.get(userString.trim());
		} else {
			//Insertion of character token will remove duplicate character using set
			Set<Character> tokensInString = new HashSet<Character>();
			char arrayOfTokens[] = userString.toCharArray();
			
			for (char token: arrayOfTokens) {
				tokensInString.add(token);
			}	
			uniqueCharacter = tokensInString.size();
			chacheStrings.put(userString, uniqueCharacter);
		}
		return uniqueCharacter;
	}
}
