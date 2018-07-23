import java.util.Comparator;
/**
 * creation date 17/7/2018
 * @author rahul sharma
 *used for sorting purpose of Processes class object
 */
public class SortByArrivalTime implements Comparator<Processes> {
	public int compare(Processes a, Processes b)
    {
        return a.getArrivalTime() - b.getArrivalTime();
    }
}
