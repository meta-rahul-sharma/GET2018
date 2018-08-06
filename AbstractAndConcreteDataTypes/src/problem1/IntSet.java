package problem1;

import java.util.Arrays;

/**
 * Implementation of Immutable class IntSet which have 
 * set which have integers in range of 1-1000
 * and have properties of set like:-
 * 1. isMember
 * 2. size of set
 * 3. get complement of set
 * 4. check if a given set is subset of another set
 * 5. perform union on 2 sets
 * @author Rahul Sharma
 * Creation Date:24/7/2018
 */
public final class IntSet {
	private final int[] arrayOfInteger;

	public IntSet(int[] arrayOfInteger) {
		Arrays.sort(arrayOfInteger);
		int[] arrayNoDuplicate = removeDuplicateElements(arrayOfInteger);

		this.arrayOfInteger = new int[arrayNoDuplicate.length];
		for (int i = 0; i < this.arrayOfInteger.length; i++) {
			this.arrayOfInteger[i] = arrayNoDuplicate[i];
		}
	}

	/**
	 * Used for checking that given value in method is
	 * member or not of set
	 * @param memberToFind (value to search in set)
	 * @return true if value isMebmer else false
	 */
	public boolean isMember(int memberToFind) {
		boolean isMember = false;
		for (int i = 0; i < arrayOfInteger.length; i++) {
			if (memberToFind == arrayOfInteger[i]) {
				isMember = true;
				break;
			}
		}
		return isMember;
	}

	/**
	 * Used for returning size of the set
	 * @return set size
	 */
	public int size() {
		return arrayOfInteger.length;
	}

	/**
	 * 
	 * @param superSet
	 * @return
	 */
	public boolean isSubSet(IntSet superSet) {
		boolean isSubSet = false;
		int thisIndex = 0;
		if (this.size() == 0) {
			isSubSet = true;
		} else {
			for (int i = 0; i < superSet.size() && this.size() < superSet.size() && thisIndex < this.size(); i++) {
				if (superSet.arrayOfInteger[i] == arrayOfInteger[thisIndex]) {
					thisIndex++;
				}
			}
			if (thisIndex == this.size()) {
				isSubSet = true;
			}
		}
		return isSubSet;
	}

	/**
	 * Used for get complement of set
	 * @return array of integer which is complement of class set
	 */
	public int[] getComplement() {
		int universalSetSize = 20;
		int[] complementArray = new int[universalSetSize - this.size()];

		int complementIndex = 0;
		for (int i = 0, mainSetIndex = 0; i < universalSetSize; i++) {
			if (mainSetIndex < this.size() && i + 1 == arrayOfInteger[mainSetIndex]) {
				mainSetIndex++;
			} else {
				complementArray[complementIndex++] = i + 1;
			}
		}
		return complementArray;
	}

	/**
	 * Used for giving union of 2 sets one this object set and another "set" object set
	 * @param set (Object of Intset class)
	 * @return Union of this object and set object sets
	 */
	public int[] union(IntSet set) {
		int set1Pointer = 0, set2Pointer = 0;
		int[] unionArray = new int[this.size() + set.size()];
		int unionIndex = 0;
		while (set1Pointer < this.size() && set2Pointer < set.size()) {
			if (this.arrayOfInteger[set1Pointer] == set.arrayOfInteger[set2Pointer]) {
				unionArray[unionIndex++] = this.arrayOfInteger[set1Pointer];
				set1Pointer++;
				set2Pointer++;
			} else if (this.arrayOfInteger[set1Pointer] < set.arrayOfInteger[set2Pointer]) {
				unionArray[unionIndex++] = this.arrayOfInteger[set1Pointer++];
			} else if (this.arrayOfInteger[set1Pointer] > set.arrayOfInteger[set2Pointer]) {
				unionArray[unionIndex++] = set.arrayOfInteger[set2Pointer++];
			}
		}
		while (set1Pointer < this.size()) {
			unionArray[unionIndex++] = this.arrayOfInteger[set1Pointer++];
		}
		while (set2Pointer < set.size()) {
			unionArray[unionIndex++] = set.arrayOfInteger[set2Pointer++];
		}

		int[] intSetArray = new int[unionIndex];
		for (int i = 0; i < unionIndex; i++) {
			intSetArray[i] = unionArray[i];
		}

		return intSetArray;
	}

	/**
	 * Used for removing duplicates from user given input when giving
	 * set Values because set does not contain same values 2 times
	 * @param arrayOfInteger (Array in which we need to remove duplicates)
	 * @return Array without any duplicate in it
	 */
	private int[] removeDuplicateElements(int[] arrayOfInteger) {
		if (arrayOfInteger.length == 0 || arrayOfInteger.length == 1) {
			return arrayOfInteger;
		}

		int nonDuplicateNumber = 1;
		int[] nonDuplicateArray = new int[arrayOfInteger.length];
		int checkValue = arrayOfInteger[0];
		nonDuplicateArray[0] = arrayOfInteger[0];
		for (int i = 1; i < arrayOfInteger.length; i++) {
			if (checkValue != arrayOfInteger[i]) {
				nonDuplicateArray[nonDuplicateNumber++] = arrayOfInteger[i];
				checkValue = arrayOfInteger[i];
			}
		}

		int[] copyNonDuplicate = new int[nonDuplicateNumber];
		for (int i = 0; i < nonDuplicateNumber; i++) {
			copyNonDuplicate[i] = nonDuplicateArray[i];
		}
		return copyNonDuplicate;
	}
}
