import java.util.ArrayList;
/**
 * Used for spliting array such that left of index equal to right index
 * 
 * @author Rahul Sharma Creation Date: 19/7/2018
 */
public class ArrayOperations {
	/**
	 * @param arrayToSplit
	 * @return index from where left of array == right of array from that index
	 */
	public int splitArray(int[] arrayToSplit) {
		if (arrayToSplit.length == 0){
			throw new AssertionError("Array is Empty");
		}
		
		
		int leftAddition = 0;
		int rightAddition = 0;
		int splitIndex = -1;
		for (int i = 0; i < arrayToSplit.length; i++) {
			rightAddition += arrayToSplit[i];
		}

		for (int i = 0; i < arrayToSplit.length; i++) {
			if (leftAddition == rightAddition) {
				splitIndex = i;
				break;
			} else {
				leftAddition += arrayToSplit[i];
				rightAddition -= arrayToSplit[i];
			}
		}

		return splitIndex;
	}
	
	/** 
	 * Return an array that contains exactly the same numbers 
	 * as the input array, but rearranged so that every X is
	 * immediately followed by a Y
	 * @param x value which never shift
	 * @param y need to be shifted just after x
	 * @param arrayToFixXy array where operations are going on
	 * @return array fixed by fixXy
	 */
	public int[] fixXy(int x, int y, int[] arrayToFixXy) {
		int[] copyOfFix = new int[arrayToFixXy.length];
		
		for(int i = 0; i < arrayToFixXy.length; i++){
			copyOfFix[i] = arrayToFixXy[i]; 
		}
		
		if(x == copyOfFix[copyOfFix.length-1]) {
			throw new AssertionError(x + " is at last index");
		}
		
		ArrayList <Integer> xPosition = new ArrayList<Integer>();
		ArrayList <Integer> yPosition = new ArrayList<Integer>();
		
		for(int i = 0; i < copyOfFix.length; i++) {
			if(copyOfFix[i] == x){
				xPosition.add(i);
			}
			if(copyOfFix[i] == y){
				yPosition.add(i);
			}
		}
		
		if(xPosition.size() != yPosition.size()) {
			throw new AssertionError(x + " and " + y + "not Equal");
		}
		
		for(int i = 0; i < xPosition.size(); i++) {
			if(i != xPosition.size()-1 && xPosition.get(i) == xPosition.get(i+1)){
				throw new AssertionError("Two "+ x + " at adjacent Positions");
			}
			
			int swapper = copyOfFix[xPosition.get(i)+1];
			copyOfFix[xPosition.get(i)+1] = copyOfFix[yPosition.get(i)];
			copyOfFix[yPosition.get(i)] = swapper;
			
		}
		
		return copyOfFix;
	} 
	
	/**
	 * Count clump(series of 2 or more adjacent elements 
	 * of the same value) in an array
	 * @param clumpsArray where clumps needed to be found
	 * @return no of clumps
	 */
	public int numbersOfClumps(int[] clumpsArray) {
		if (clumpsArray.length == 0){
			throw new AssertionError("Array is Empty");
		}
		
		int numbersOfClumps = 0;
		int clump = clumpsArray[0];
		int clumpCount = 0;
		for(int i = 1; i < clumpsArray.length; i++){
			if(clump == clumpsArray[i]) {
				if(clumpCount == 0){
					numbersOfClumps++;
					
				}
				clumpCount++;
			} else {
				clump = clumpsArray[i];
				clumpCount = 0;
			}
		}
		return numbersOfClumps;
	}
	
	/**
	 * It returns Mirror Section Length(Mirror section in an array is a
	 * group of contiguous elements such that somewhere in the array,the
	 * same group appears in reverse order)
	 * @param mirrorArray of what we want to have maximum mirror
	 * @return largest consecutive mirror
	 */
	public int largestMirrorSeciton(int[] mirrorArray) {
		if (mirrorArray.length == 0){
			throw new AssertionError("Array is Empty");
		}
		
		int largestMirrorCount = 0;
		int localMirrorCount=0;
		int lengthOfArray = mirrorArray.length;
		for(int i = 0; i < lengthOfArray; i++) {
			int leftPointer = i;
			boolean consecutive = false;
			for(int rightPointer = lengthOfArray-1; rightPointer >= leftPointer; rightPointer--) {
				if(mirrorArray[leftPointer] == mirrorArray[rightPointer]) {
					if(consecutive) {
						if(leftPointer == rightPointer) {
							localMirrorCount = 2 * localMirrorCount +1;
						} else if(leftPointer == rightPointer-1){
							localMirrorCount = 2 * localMirrorCount +2;
						} else {
							localMirrorCount++;
						}
					} else {
						consecutive = true;
						localMirrorCount =1;
					}
					leftPointer++;
					
				} else {
					largestMirrorCount = Math.max(localMirrorCount, largestMirrorCount);
					consecutive = false;
					localMirrorCount = 0;
				}
			}
		}
		return largestMirrorCount;
	}
}
