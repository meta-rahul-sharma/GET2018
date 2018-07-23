import java.util.ArrayList;
import java.util.Collections;

/**
 * creation date 17/7/2018
 * 
 * @author rahul sharma implementation of first come first serve algorithm
 */
public class FcfsAlgorithm {
	/**
	 * compute completion time of every process
	 * @param process object of Processes class
	 */
	public void computeCompletionTime(ArrayList<Processes> process) {
		Collections.sort(process, new SortByArrivalTime());

		process.get(0)
				.setCompletionTime(
						process.get(0).getArrivalTime()
								+ process.get(0).getBurstTime());

		for (int i = 1; i < process.size(); i++) {
			if (process.get(i - 1).getCompletionTime() >= process.get(i)
					.getArrivalTime()) {
				process.get(i).setCompletionTime(
						process.get(i - 1).getCompletionTime()
								+ process.get(i).getBurstTime());
			} else {
				process.get(i).setCompletionTime(
						process.get(i).getArrivalTime()
								+ process.get(i).getBurstTime());
			}
		}
		
		
	}

	/**
	 * compute waiting time of every process
	 * 
	 * @param process
	 *            object of Processes class
	 */

	public void computeWaitingTime(ArrayList<Processes> process) {
		Collections.sort(process, new SortByArrivalTime());
		for (int i = 1; i < process.size(); i++) {
			process.get(i).setWaitingTime(
					process.get(i).getTurnAroundTime()
							- process.get(i).getBurstTime());
		}
	}

	/**
	 * compute turn around time of every process
	 * @param process object of Processes class
	 */

	public void computeTurnAroundTime(ArrayList<Processes> process) {
		Collections.sort(process, new SortByArrivalTime());
		for (int i = 0; i < process.size(); i++) {
			process.get(i).setTurnAroundTime(
					process.get(i).getCompletionTime()
							- process.get(i).getArrivalTime());
		}
	}

	/**
	 * compute average waiting time of every process
	 * @param process object of Processes class
	 */

	public int computeAverageWaitingTime(ArrayList<Processes> process) {
		int averageWaitingTime;
		int totalWait = 0;
		for (int i = 0; i < process.size(); i++) {
			totalWait += process.get(i).getWaitingTime();
		}
		averageWaitingTime = totalWait / process.size();
		return averageWaitingTime;
	}

	/**
	 * compute maximum of waiting time of every process
	 * @param process object of Processes class
	 */

	public int computeMaxWaitingTime(ArrayList<Processes> process) {
		int max = 0;
		for (int i = 0; i < process.size(); i++) {
			if (max < process.get(i).getWaitingTime()) {
				max = process.get(i).getWaitingTime();
			}
		}
		return max;
	}
}
