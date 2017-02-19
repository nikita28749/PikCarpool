package Schedule;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import Dispatch.DispatchContext;

import Routing.RoutingContext;
import Vehicle.Vehicle;

public class RequestSchedule extends Schedule {
	Scanner scan = new Scanner(System.in);
	String location;
	ArrayList<Vehicle> nearByVehicles;
	RoutingContext rc;
	double lat = 3.2;
	double lon = 5.3;
	DispatchContext dp;
	SimpleDateFormat sf = new SimpleDateFormat("mm/dd/yyyy");
	Date date = new Date();

	@Override

	public void schedule(String poolType, String requestType, int tozip, int fromZip) {
		rc = new RoutingContext();

		if (poolType.equalsIgnoreCase("Carpool") && requestType.equalsIgnoreCase("instant")) {

			System.out.println("The carpool has been scheduled" + " to : " + tozip + " " + "vehicle no:"
					+ scheduledVehicle(fromZip) + " " + "with the recommended routing" + " "
					+ rc.setRoutingStrategyType(tozip, fromZip) + " with routing distance of "
					+ rc.shortestDistance(tozip, fromZip) + " " + "miles");

			System.out.print("Do you want the Dispatch Status?:yes/no:put option 1 for yes and 2 for no ");
			int answer = scan.nextInt();
			if (answer == 1) {
				dp = new DispatchContext();
				dp.requestDispatch();
				dp.processDispatch(fromZip);
				dp.completeDispatch();

			} else {
				System.out.println("Thankyou, for riding with PIK Carpool Company! Enjoy your ride.");
			}

		}

		if (poolType.equalsIgnoreCase("Carpool") && requestType.equalsIgnoreCase("schedule")) {

			System.out.println("The Carpool Scheduled from the above commute is " + " with routing distance of "
					+ rc.shortestDistance(tozip, fromZip) + " miles " + " by " + rc.setRoutingStrategyType(tozip, fromZip)
					+ " by " + "vehicle no:" + scheduledVehicle(fromZip));
			
			
			System.out.print("Do you want the Dispatch Status?:yes/no:put option 1 for yes and 2 for no ");
			int answer = scan.nextInt();
			if (answer == 1) {
				dp = new DispatchContext();
				dp.requestDispatch();
				dp.processDispatch(fromZip);
				dp.completeDispatch();

			} else {
				System.out.println("Thankyou, for riding with PIK Carpool Company! Enjoy your ride.");
			}
            
		}
	}

	Vehicle[] initialize(double lat, double lon) {
		Vehicle[] v = new Vehicle[20];

		for (int i = 0; i < 20; i++) {
			v[i] = new Vehicle();
			v[i].registration = "PIK0" + i;
			v[i].id = i;
			v[i].lat = (Math.random() * 56 + i + lat) / 75;
			v[i].lon = (Math.random() * 34 + i + lon) / 75;

		}

		return v;
	}

	public ArrayList<Vehicle> findNearByUtil(double lat, double lon) {

		ArrayList<Vehicle> nearByVehicles = new ArrayList<Vehicle>();

		Vehicle[] v = new Vehicle[20];
		v = initialize(lat, lon);

		for (int i = 0; i < v.length; i++) {

			if ((lat - v[i].lat <= 13) && (lon - v[i].lon <= 7.5)) {
				// System.out.println("values of lon:"+lon+"-"+v[i].lon);
				nearByVehicles.add(v[i]);

			}

			if (nearByVehicles.isEmpty()) {
				nearByVehicles.add(v[(int) (Math.random() * 20)]);
			}

		}

		return nearByVehicles;
	}

	public ArrayList<Vehicle> findNearBy(int from) {
		ArrayList<Vehicle> nearByVehicles = new ArrayList<Vehicle>();

		nearByVehicles = findNearByUtil(Math.random() * 0.9 * from, Math.random() * 14 * 0.8 * from);

		return nearByVehicles;
	}

	public String scheduledVehicle(int from) {
		ArrayList<Vehicle> one = findNearBy(from);

		int listSize = one.size();

		Vehicle vehicle = (Vehicle) one.get((int) (Math.random() * 100) % listSize);

		return (String) vehicle.registration;

	}

}






























/*import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import Dispatch.DispatchContext;

import Routing.RoutingContext;
import Vehicle.Vehicle;


public class RequestSchedule extends Schedule {
	Scanner scan=new Scanner(System.in);
	 
	
	String location;
	ArrayList<Vehicle> nearByVehicles;
	RoutingContext rc;
	double lat=3.2;
	double lon=5.3;
	DispatchContext dp;
	SimpleDateFormat sf=new SimpleDateFormat("mm/dd/yyyy");
	Date date=new Date();
	
	
	
  public int getTozipcode() {
		return tozipcode;
	}

public void setTozipcode(int tozipcode) {
		this.tozipcode = tozipcode;
	}


public int getFromZipcode() {
		return fromZipcode;
	}


public void setFromZipcode(int fromZipcode) {
		this.fromZipcode = fromZipcode;
	}


@Override
	public void schedule(String poolType,String requestType,int tozip,int fromZip) {
	rc=new RoutingContext();
	
	if(poolType.equalsIgnoreCase("Carpool") && requestType.equalsIgnoreCase("instant") ){
		
		
		 System.out.println( "The carpool has been scheduled"	+
		 " to : " + tozip + " "+ 
		  "vehicle no:" + scheduledVehicle(fromZip)+" " + "with the recommended routing"+" " + rc.setRoutingStrategyType(tozip, fromZip)+" " +sf.format(date)
		  +" with routing distance of " + rc.shortestDistance(tozip,fromZip)+" "+ "miles");
	
		 
		 System.out.print("Do you want the Dispatch Status?:yes/no:put option 1 for yes and 2 for no ");
		 int answer=scan.nextInt();
		 if(answer==1){
			 dp=new DispatchContext();
		  dp.requestDispatch();
		  dp.processDispatch(fromZip);
		  dp.completeDispatch();
		 
		 
		 
		 }
		 else{System.out.println("Thankyou, for riding with PIK Carpool Company! Enjoy your ride.");}
		  
		}
		/*else{
		System.out.println("The carpool not been scheduled but an individual ride"	+
					 " to : " + tozip + 
					  
					 " by " + "vehicle no:" + scheduledVehicle(fromZip));
			
			
		}*/
		
	/*	if(poolType.equalsIgnoreCase("Carpool") && requestType.equalsIgnoreCase("schedule") ){
				
				 System.out.println( "The carpool has been scheduled"	+
				 " to : " + tozip + "on following days from " + sf.format((date)) + 
				 "to " + sf.format(date)+7 + 
				 " with routing distance of" + rc.shortestDistance(tozip,fromZip)+ "miles" +
				 " by " + rc.setRoutingStrategyType(tozip,fromZip) +
				  
				 " by " +  "vehicle no:" + scheduledVehicle(fromZip));
				 
				/* System.out.print("Do you want the Dispatch Status?:yes/no:put option 1 for yes and 2 for no ");
				 int answer=scan.nextInt();
				 if(answer==1){
					 dp=new DispatchContext();
				  dp.requestDispatch();
				  dp.processDispatch(fromZip);
				  dp.completeDispatch();
				 
				 
				 
				 }
				 else{System.out.println("Thankyou, for riding with PIK Carpool Company! Enjoy your ride.");}
				  
				}
				/*else{
					 System.out.println( "The carpool not been scheduled but an individual ride");	
							 
					
				}	*/
			/*	if(poolType.equalsIgnoreCase("independent") && requestType.equalsIgnoreCase ("schedule")){
					System.out.println("The vehicle has been scheduled"	+
						 " to : " + tozip + "on following days from " + sf.format(date)+1 + 
						 "to " + sf.format(date)+7 +  " with routing distance of" + rc.shortestDistance(tozip,fromZip)+ "miles" +
								 " by " + rc.setRoutingStrategyType(tozip,fromZip) +
			              "vehicle no:" + scheduledVehicle(fromZip));
					/* System.out.print("Do you want the Dispatch Status?:yes/no:put option 1 for yes and 2 for no ");
					 int answer=scan.nextInt();	
					 if(answer==1){
						 dp=new DispatchContext();
					  dp.requestDispatch();
					  dp.processDispatch(fromZip);
					  dp.completeDispatch();
					 
					 
					 
					 }
					 else{System.out.println("Thankyou, for riding with PIK Carpool Company! Enjoy your ride.");}
					  
					}*/
					
							
							
							
				/*if(poolType.equalsIgnoreCase("independent") && requestType.equalsIgnoreCase( "instant")){
				 System.out.println( "The vehicle has been scheduled"	+
						 " to : " + tozip + " with routing distance of" + rc.shortestDistance(tozip,fromZip) +
						 " by " + rc.setRoutingStrategyType(tozip,fromZip) +
						  "vehicle no:" + scheduledVehicle(fromZip));
				 System.out.print("Do you want the Dispatch Status?:yes/no:put option 1 for yes and 2 for no ");
				 int answer=scan.nextInt();	
				 if(answer==1){
					 dp=new DispatchContext();
				  dp.requestDispatch();
				  dp.processDispatch(fromZip);
				  dp.completeDispatch();
				 
				 
				 
				 }
				 else{System.out.println("Thankyou, for riding with PIK Carpool Company! Enjoy your ride.");}
				  
				}
				}
		}
				
						  
				}	
		
		
		
	 
	
	
		
		
	
	

Vehicle[] initialize(double lat , double lon){
	Vehicle[] v= new Vehicle[20];
	
	for(int i=0; i<20 ; i++){
		v[i]= new Vehicle();
		v[i].registration= "PIK0"+i;                         
		v[i].id= i;
		v[i].lat= (Math.random() * 56 + i + lat) / 75;
		v[i].lon= (Math.random() * 34 + i + lon) / 75;
		

		for(int j=0;j<i;j++){
			//System.out.println("values of reg:"+v[j].registration);
			//System.out.println("values of reg:"+v[j].id);
			//System.out.println("values of reg:"+v[j].lat);
			//System.out.println("values of reg:"+v[j].lon);
			
		}
		
	} 
	
	return v;
}


public ArrayList<Vehicle> findNearByUtil (double lat, double lon){

    ArrayList<Vehicle> nearByVehicles = new ArrayList<Vehicle>();
	
	Vehicle[] v= new Vehicle[20];
	v = initialize(lat,lon);
    
    for(int i=0 ; i< v.length ;i++){
    	
    	if((lat- v[i].lat <= 13) && (lon -v[i].lon <= 7.5) ){
    		//System.out.println("values of lon:"+lon+"-"+v[i].lon);
    		nearByVehicles.add(v[i]);
    		
    		//System.out.println("values of nearByVeh:"+nearByVehicles.add(v[i]));
    		//for(int j=0;j<nearByVehicles.size();j++){
    			//System.out.println("The vehicles are:"+nearByVehicles.get(j));
    		//}
    	}
	    
	   /* Iterator <Vehicle>it=nearByVehicles.iterator();
	    Vehicle r=null;
	    while (it.hasNext()) {
	   // if(it.hasNext()){
	    	r=it.next();
	    	System.out.println("Value of r:"+r.id);
	    }*/
	    
	/*	if (nearByVehicles.isEmpty()) {
		    nearByVehicles.add(v[(int)(Math.random()*20)]);
		}
	    
    	
	}
    
	return nearByVehicles;
}


public ArrayList<Vehicle> findNearBy(int from){
    ArrayList<Vehicle>nearByVehicles= new ArrayList<Vehicle>();
    
	
	nearByVehicles = findNearByUtil(Math.random()* 0.9 * from , Math.random() * 14 *0.8 * from);
	//System.out.println("The values:"+nearByVehicles);
	
	   /* Iterator <Vehicle>it=nearByVehicles.iterator();
	    Vehicle r=null;
	    while (it.hasNext()) {
	   // if(it.hasNext()){
	    	r=it.next();
	    	System.out.println("Value of r:"+r.id);
	    }*/
	    
	
	
/*	return nearByVehicles;
}

public String scheduledVehicle(int from){
	ArrayList<Vehicle> one= findNearBy(from);
	//Vehicle vehicle= (Vehicle) one.get( (int) ((Math.random()*100)%19));
	 int listSize = one.size();

        Vehicle vehicle = (Vehicle) one.get((int)(Math.random() * 100) % listSize);

	//System.out.println("The values:"+vehicle.registration);
	return (String) vehicle.registration;
	





	
	
		
			
	}
	
	


	
	

}*/
