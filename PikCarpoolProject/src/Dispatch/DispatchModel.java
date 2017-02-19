package Dispatch;

public class DispatchModel 
{
	public static final int baseFare = 2;
	public static final double taxPerRide = 1.55;
	public static final double waitingTimePerMinute = 0.75;
	public static final double costOfRidePerMinute = 0.90;
	public static final double costOfRidePerMile = 3.75;
	
	public double numberOfMiles;
	public long waitingTime;
	public long timeForDestination;
	
	public double getNumberOfMiles() {
		return numberOfMiles;
	}
	public void setNumberOfMiles(double numberOfMiles) {
		this.numberOfMiles = numberOfMiles;
	}
	public long getWaitingTime() {
		return waitingTime;
	}
	public void setWaitingTime(long waitingTime) {
		this.waitingTime = waitingTime;
	}
	public long getTimeForDestination() {
		return timeForDestination;
	}
	public void setTimeForDestination(long timeForDestination) {
		this.timeForDestination = timeForDestination;
	}
	public static int getBasefare() {
		return baseFare;
	}

}
