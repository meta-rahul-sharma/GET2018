import java.util.Scanner;
import java.util.ArrayList;

/**
 * creation date 17/7/2018
 * 
 * @author rahul sharma executing program from here
 */
public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		System.out.println("No of processes ?");
		int processCount = in.nextInt();

		ArrayList<Processes> process = new ArrayList<Processes>();

		for (int i = 0; i < processCount; i++) {
			System.out.println("Enter Process id ");
			int processId = in.nextInt();

			System.out.println("Enter Arrival time of Process " + processId);
			int arrivalTime = in.nextInt();

			System.out.println("Enter Burst time of Process " + processId);
			int burstTime = in.nextInt();
			// process.get(i).setBurstTime(burst_time);
			process.add(new Processes(processId, arrivalTime, burstTime));
		}
		
		FcfsAlgorithm fcfs = new FcfsAlgorithm();
		fcfs.computeCompletionTime(process);

		fcfs.computeTurnAroundTime(process);
		fcfs.computeWaitingTime(process);

		System.out
				.println("process id\tArrival time\tBurst time\tCompletion time\tWaiting time\tTurnAround time");

		for (int i = 0; i < process.size(); i++) {
			System.out.println(process.get(i).getId() + "\t\t"
					+ process.get(i).getArrivalTime() + "\t\t"
					+ process.get(i).getBurstTime() + "\t\t"
					+ process.get(i).getCompletionTime() + "\t\t"
					+ process.get(i).getWaitingTime() + "\t\t"
					+ process.get(i).getTurnAroundTime());
		}

		System.out.println("Average Waiting Time:"
				+ fcfs.computeAverageWaitingTime(process) + "\n"
				+ "Maximum Waiting time:"
				+ fcfs.computeMaxWaitingTime(process));
		in.close();
	}
}
