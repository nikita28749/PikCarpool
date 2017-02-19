package Dispatch;

import Schedule.RequestSchedule;
import Vehicle.Vehicle;

public class RequestState implements DispatchState {
	
	Vehicle vehicle;
	RequestSchedule schedule;
	boolean isParkingNeeded;
	DispatchContext dc;
	String make;
	String fromZipcode;
	String toZipcode;
	RequestSchedule rs;
	
	RequestState(DispatchContext dc){
		this.dc=dc;
		
		
		
	}
	
	

	@Override
	public void requestDispatch() {
		
		//make=vehicle.getVehicleMake();
		 //fromZipcode=schedule.getFromZipcode();
		 //toZipcode=schedule.getTozipcode(); 	
	 System.out.println("Collecting information for dispatch ");
	 try {
		Thread.sleep(5000);
		this.dc.setCurrentState(dc.processState);
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	
		
		
		
	}

	@Override
	public String processDispatch(int fromZip) {
		//System.out.println("Cannot proceed without details");
		return "Cannot proceed without details";
		
	}

	@Override
	public void completeDispatch() {
		System.out.println("Cannot proceed without details");
		
	}
	
	

}
