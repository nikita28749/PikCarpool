package Tracking;

import java.util.Date;

import Dispatch.CompleteState;
import Notifications.MyNotifications;
import Notifications.Notifications;
import Notifications.Observers;
import Vehicle.Vehicle;

public class Tracking implements TrackingInterface,Observers {

	private long trackingId;
	public long getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(long trackingId) {
		this.trackingId = trackingId;
	}

	private Vehicle vehicle;
	private String trackingStatus;
	private boolean monitoringByGyrometersFlag;
	private boolean CarSurveylanceFlag;
	private boolean isVehicleTrouble;

	
	
	

	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Tracking:");
		sb.append("\n___________________________________");
		
		sb.append("\nTracking Driver By: " +monitoringByGyrometersFlag );
		sb.append("\nCar Surveylance: " + CarSurveylanceFlag);
		sb.append("\nTracking Status: " + trackingStatus);
		
			
		
		String string = sb.toString();

		return string;
	}

	@Override
	public String vehicleTracking() {
		double random=Math.random();
		if(random >0.2) {
            isVehicleTrouble=true;
        }
		if (isVehicleTrouble==true){
			System.out.println("\n Vehicle got broke down,Notification sent to PIK Carpool Company " + getTrackingId());
			MyNotifications topic = new MyNotifications();
			Observers ob=new CompleteState("Dispatch");
			topic.registerNotifications(ob);
			ob.setNotifications(topic);
			ob.update();
			topic.postNotifications("Vehicle got down,Driver needs assistance");
			
		    return "vehicle trouble";
		}
		
		else{
			System.out.println("Vehicle approaching Rider");
			try {
				Thread.sleep(7000);
				System.out.println("Rider is aboard");
				Thread.sleep(7000);
				System.out.println("Vehicle reaching destination");
				Thread.sleep(7000);
				System.out.println("Destination reached");
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		return "Tracking completed";
	}

	@Override
	public boolean isMonitoringByGyrometers() {
		// TODO Auto-generated method stub
		return monitoringByGyrometersFlag;
	}

	@Override
	public void setMonitoringByGyrometers(boolean monitoringByGyrometers) {
		this.monitoringByGyrometersFlag=monitoringByGyrometers;
		
	}

	@Override
	public boolean isCarSurveylanceOn() {
		// TODO Auto-generated method stub
		return CarSurveylanceFlag;
	}

	@Override
	public void setCarSurveylanceFlag(boolean carSurveylanceOn) {
		this.CarSurveylanceFlag=carSurveylanceOn;
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNotifications(Notifications notify) {
		// TODO Auto-generated method stub
		
	}

	

	
	

	
	
}

