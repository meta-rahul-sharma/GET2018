/**
 * creation date 17/7/2018
 * @author rahul sharma
 *creating processes
 */
public class Processes {
	private int id;
    private int arrival_time;
    private int burst_time;
    private int completion_time;
    private int waiting_time;
    private int turn_around_time;
    public Processes() {
    	
    }
    /**
     * intialize process
     * @param id
     * @param arrival_time
     * @param burst_time
     */
    public Processes(int id,int arrival_time, int burst_time) {
    	this.id=id;
    	this.arrival_time=arrival_time;
    	this.burst_time=burst_time;
    }
    
    public void setCompletionTime(final int completion_time) {
    	this.completion_time = completion_time;
    }
    
    public void setWaitingTime(final int waiting_time) {
    	this.waiting_time = waiting_time;
    }
    
    public void setTurnAroundTime(final int turn_around_time) {
    	this.turn_around_time = turn_around_time;
    }
    
    public void setArrivalTime(final int arrival_time) {
    	this.arrival_time = arrival_time;
    }
    
    public void setBurstTime(final int burst_time) {
    	this.burst_time = burst_time;
    }
    
    public int getArrivalTime() {
    	return arrival_time;
    }
    
    public int getBurstTime() {
    	return burst_time;
    }
    
    public int getCompletionTime() {
    	return completion_time;
    }
    
    public int getWaitingTime() {
    	return waiting_time;
    }
    
    public int getTurnAroundTime() {
    	return turn_around_time;
    }
    
    public int getId() {
    	return id;
    }
}
