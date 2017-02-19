package Schedule;
import Rides.Request;

public abstract class Schedule {
	

	
	String fromstreetAdd;
	String tostreetAdd;
	int fromZipcode;
	public String getFromstreetAdd() {
		return fromstreetAdd;
	}



	public void setFromstreetAdd(String fromstreetAdd) {
		this.fromstreetAdd = fromstreetAdd;
	}



	public String getTostreetAdd() {
		return tostreetAdd;
	}



	public void setTostreetAdd(String tostreetAdd) {
		this.tostreetAdd = tostreetAdd;
	}



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



	public String getTimingType() {
		return timingType;
	}



	public void setTimingType(String timingType) {
		this.timingType = timingType;
	}



	public String getOption() {
		return option;
	}



	public void setOption(String option) {
		this.option = option;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	int toZipcode;
	
	String timingType;
	
	
	String option;
	String date;
	
	
	
	public abstract void schedule(String poolType,String requestType,int fromZip,int toZip);
	
}


































/*public abstract class Schedule {
	int tozipcode;
	int fromZipcode;
	String req;
	String poolType;
	
	
	
//	Schedule(String poolType,String requestType,int tozip,int fromZip){
		
	//	this.req=requestType;
	  //  this.tozipcode = tozip;
	//	this.fromZipcode = fromZip;
	//	this.poolType=poolType;
	//}
	
	
	public abstract void schedule(String poolType,String requestType,int tozip,int fromZip);
	
	//abstract void categorize();
    //public abstract String[] requestRide(String requestType, String timingType, int to, int from);
   // abstract void updateRide(String requestType, String timingType);
   // abstract void deleteRide(String requestType, String timingType);
}*/
