/**
 * creation date 17/7/2018
 * 
 * @author rahul sharma creating processes
 */
public class Processes {
	private int id;
	private int arrivalTime;
	private int burstTime;
	private int completionTime;
	private int waitingTime;
	private int turnAroundTime;

	public Processes() {

	}

	/**
	 * intialize process
	 * @param id
	 * @param arrivalTime
	 * @param burstTime
	 */
	public Processes(int id,int arrivalTime, int burstTime) {
    	this.id=id;
    	this.arrivalTime=arrivalTime;
    	this.burstTime=burstTime;
    }

	public void setCompletionTime(final int completionTime) {
		this.completionTime = completionTime;
	}

	public void setWaitingTime(final int waiting_time) {
		this.waitingTime = waiting_time;
	}

	public void setTurnAroundTime(final int turn_around_time) {
		this.turnAroundTime = turn_around_time;
	}

	public void setArrivalTime(final int arrival_time) {
		this.arrivalTime = arrival_time;
	}

	public void setBurstTime(final int burst_time) {
		this.burstTime = burst_time;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public int getBurstTime() {
		return burstTime;
	}

	public int getCompletionTime() {
		return completionTime;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public int getTurnAroundTime() {
		return turnAroundTime;
	}

	public int getId() {
		return id;
	}
}
