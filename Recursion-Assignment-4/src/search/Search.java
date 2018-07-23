package search;

public class Search {
	
	/**
	 * Search element in array linearly with time complexity of O(n)
	 * @param searchArray where element is being searched
	 * @param element to be searched
	 * @param index (current index of array)
	 * @return index if items present else -1
	 */
	public int linearSearch(int[] searchArray, int element, int index) {
		int indexResult = -1;
		if (index < searchArray.length) {
			if (searchArray[index] == element) {
				indexResult = index;
			} else {
				indexResult = linearSearch(searchArray, element, index + 1);
			}
		}
		return indexResult;
	}

	/**
	 * Perform binary search where array is in sorted manner and element is checked form mid if element is on mid 
	 * return index of mid else half of the elements get eliminated by comparing mid index element value to search value
	 * @param searchArraySorted is array where element is searched (sorted array)
	 * @param element to be searched
	 * @param start
	 * @param end
	 * @return index if items present else -1
	 */
	public int binarySearch(int[] searchArraySorted, int element, int start, int end) {
		int indexResult = -1;
		if(start == end ) {
			if(searchArraySorted[start] == element) {
				indexResult = start;
			}
		} else {
			int mid = start + end / 2;
			if(searchArraySorted[mid] == element) {
				indexResult = mid;
			} else {
				if(element < searchArraySorted[mid]) {
					indexResult = binarySearch(searchArraySorted, element, start, mid - 1);
				}
				if(element > searchArraySorted[mid]) {
					indexResult = binarySearch(searchArraySorted, element, mid + 1, end);
				}
			}
		}
		return indexResult;
	}
}
