package Dispatch;

import java.util.Date;
import java.util.Scanner;

import Notifications.Notifications;
import Notifications.Observers;
import Schedule.RequestSchedule;
import Tracking.*;
import Payments.*;

public class ProcessState implements DispatchState,Observers {
	//Rider rider;
	String name;
	RequestState request;
	DispatchContext dc;
	int dispatchId;
	Date dispatchDate;
	private Notifications notify;
	RequestSchedule rs;
	int fromZip;
	
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
	
	Scanner scan=new Scanner(System.in);


	public ProcessState(){
		
		
		
		
	}
	
	ProcessState(DispatchContext dc){
		this.dc=dc;
		
		
		
	}
	
	public ProcessState(String nm){
		this.name=nm;
	}

	@Override
	public void requestDispatch() {
		
		System.out.println(" Already Assigned for process");
	}

	@Override
	public String processDispatch(int fromZip) {
		
		System.out.println("Dispatch is in process");
		this.fromZip=fromZip;
		rs=new RequestSchedule();
	String regnum=rs.scheduledVehicle(this.fromZip);
	try {
		Thread.sleep(5000);
		this.dc.setCurrentState(dc.completeState);
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//this.dc.setCurrentState(dc.completeState);
	
	return regnum;
	
	
	
	
		
		
		//getDispatchId();
		//getDispatchDate();
		//String make=request.make;
		//getTracking for vehicleID
		//getParking for vehicleID
		
		
	/*	MyNotifications mn=new MyNotifications();
		Observers rider=new Rider("Rider");
		mn.registerNotifications(rider);
		rider.setNotifications(mn);
		rider.update();
		mn.postNotifications("Dispatching a vehicle to Rider");
		//rider.update();
		this.dc.setCurrentState(dc.completeState);*/
		
		
	}

	@Override
	public void completeDispatch() {
		
		System.out.println(" Dispacth completed");
		}
	
	@Override
	public void update() {
		//String msg = (String) notify.getUpdate(this);
		//if(msg == null){
		//	System.out.println(name+":: No new messages");
		//}else
	//	System.out.println(name+":: gets notified::"+msg);
	}
	
	@Override
	public void setNotifications(Notifications notifications) {
		this.notify=notifications;
	}

	public int getDispatchId() {
		return dispatchId;
	}

	public void setDispatchId(int dispatchId) {
		this.dispatchId = dispatchId;
	}

	public Date getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

}
