package Rides;

import Schedule.Schedule;

public class RequestRide extends Request {
	    
	
		public RequestRide(Schedule schedule, String req) {
		super(schedule);
		this.req=req;
	}

	@Override
	public  void ride() {
		 {
			System.out.println("Scheduling a ride for Customer");
			schedule.schedule("Carpool","Schedule",schedule.getFromZipcode(),schedule.getToZipcode());
		}

	}
}
















/*import Schedule.Schedule;

public class RequestRide extends Request {
	
	

	//RequestRide(Schedule schedule) {
	//	super(schedule);
		
	//}
	public RequestRide(Schedule schedule, String req,String timingType,String tozip,String fromZip) {
		super(schedule);
		this.req=req;
		this.toZipcode = Integer.valueOf(tozip);
		this.fromZipcode = Integer.valueOf(fromZip);
		this.timingType=timingType;
		
	}

	@Override
	public  void ride() {
		//try {
			
			System.out.println("Scheduling a ride for Customer");
			//System.out.println(req+toZipcode+fromZipcode+timingType);
			

			//sleep 5 seconds
			//Thread.sleep(5000);
			schedule.schedule(req,timingType,toZipcode,fromZipcode);
			//System.out.println(req+timingType+toZipcode+fromZipcode);
            
			

		//} catch (InterruptedException e) {
			//e.printStackTrace();
		//}

		
		
		
		//schedule.schedule();
		
		
		
		
		}
	




}*/
