import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestFcfs {

	@Test
	public void testFcfs1() {
		ArrayList<Processes> process = new ArrayList<Processes>();
		FcfsAlgorithm fcfs = new FcfsAlgorithm();
		
		process.add(new Processes(1, 5, 10));
		process.add(new Processes(2, 8, 20));
		process.add(new Processes(3, 9, 30));
		process.add(new Processes(4, 10, 40));
		process.add(new Processes(6, 11, 50));
		
		fcfs.computeCompletionTime(process);
		fcfs.computeTurnAroundTime(process);
		fcfs.computeWaitingTime(process);
		
		int [] completionTime = new int[process.size()];
		int [] turnAroundTime = new int[process.size()];
		int [] waitingTime = new int[process.size()];
		
		for(int i = 0; i < process.size(); i++) {
			completionTime[i] = process.get(i).getCompletionTime();
			turnAroundTime[i] = process.get(i).getTurnAroundTime();
			waitingTime[i] = process.get(i).getWaitingTime();
		}
		assertArrayEquals(new int[] { 15, 35, 65, 105, 155}, completionTime);
		assertArrayEquals(new int[] { 10, 27, 56, 95, 144}, turnAroundTime);
		assertArrayEquals(new int[] { 0, 7, 26, 55, 94}, waitingTime);
	}

}
