package Rides;

import Schedule.Schedule;

public class UpdateRide extends Request {

	

	//UpdateRide(Schedule schedule) {
	//	super(schedule);
		
	//}
	public UpdateRide(Schedule schedule, String req,String timingType,String fromzip,String toZip) {
		super(schedule);
		this.req=req;
		
	}

	@Override
	public void ride() {
		
		//this.fromZipcode=fromZipcode;
		//this.toZipcode=toZipcode;
		System.out.println("Updating ride");
	}

	

}














/*import Schedule.Schedule;

public class UpdateRide extends Request {

	

	//UpdateRide(Schedule schedule) {
	//	super(schedule);
		
	//}
	public UpdateRide(Schedule schedule, String req,String timingType,String fromzip,String toZip) {
		super(schedule);
		this.req=req;
		this.toZipcode =Integer.parseInt(toZip) ;
		this.fromZipcode = Integer.parseInt(fromzip);
		this.timingType=timingType;
		
	}

	@Override
	public void ride() {
		
		//this.fromZipcode=fromZipcode;
		//this.toZipcode=toZipcode;
		System.out.println("Updating ride");
	}

	

}*/
