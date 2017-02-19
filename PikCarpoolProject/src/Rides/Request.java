package Rides;

import Schedule.Schedule;

public abstract class Request {
	
	//protected String fromLocation;
	//protected String toLocation;
	protected String req;
	protected Schedule schedule;
	
	
    Request(Schedule schedule){
	this.schedule=schedule;
		
	}
		
	public abstract void ride ();
	

}














/*import Schedule.Schedule;

public abstract class Request {
	
	//protected String fromLocation;
	//protected String toLocation;
	protected int fromZipcode;
	protected int toZipcode;
	protected String req;
	protected Schedule schedule;
	protected String timingType;
	
      Request(Schedule schedule){
	this.schedule=schedule;
		
	}
	
	//Request(String requestType,String timingType,String fromzip,String toZip){
	//	this.req=requestType;
	//	this.toZipcode = toZip;
	//	this.fromZipcode = fromzip;
	//	this.timingType=timingType;
		
//	}
	

	//public String getFromLocation() {
	//	return fromLocation;
	//}

	//public void setFromLocation(String fromLocation) {
	//	this.fromLocation = fromLocation;
	//}

	//public String getToLocation() {
	//	return toLocation;
	//}

	//public void setToLocation(String toLocation) {
	//	this.toLocation = toLocation;
	//}

	
	
	
	public int getFromZipcode() {
		return fromZipcode;
	}

	public void setFromZipcode(int fromZipcode) {
		this.fromZipcode = fromZipcode;
	}

	public int getToZipcode() {
		return toZipcode;
	}

	public void setToZipcode(int toZipcode) {
		this.toZipcode = toZipcode;
	}

	
	
	public abstract void ride ();
	

}*/
