package problem2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Implementation of sort2DMatrix which is used for sorting 
 * 2DMatrix on the values of specific column
 * @author rahul sharma
 *Creation date: 25/7/2018
 */
public class sort2DMatrix {
	public void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
       	Arrays.sort(arr, new Comparator<int[]>() {
           
                       
       // Compare values according to columns
       	public int compare(final int[] entry1, 
                             final int[] entry2) {
 
       	if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
          }
        });
    }
}
