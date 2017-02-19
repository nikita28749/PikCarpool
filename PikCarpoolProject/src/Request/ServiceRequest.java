package Request;

import java.util.*;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import Rides.CancelRide;
import Rides.Request;
import Rides.RequestRide;
import Rides.UpdateRide;
import Schedule.CancelSchedule;
import Schedule.RequestSchedule;
import Schedule.Schedule;
import Vehicle.Vehicle;

public class ServiceRequest {
	int requestId;
	String natureOfCall;
	Request request;
	Schedule schedule;
	String requestType;
	static long countSFO = 0;
	static long countMV = 0;
	
	static long count;

	public enum timingType {
		schedule, instant
	}

	CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
			.withCache("preConfigured", CacheConfigurationBuilder
					.newCacheConfigurationBuilder(Long.class, Schedule.class, ResourcePoolsBuilder.heap(100)).build())
			.build(true);

	Cache<Long, Schedule> reConfigured = cacheManager.getCache("preConfigured", Long.class, Schedule.class);

	Cache<Long, Schedule> myCacheSFO = cacheManager.createCache("myCacheSFO", CacheConfigurationBuilder
			.newCacheConfigurationBuilder(Long.class, Schedule.class, ResourcePoolsBuilder.heap(100)).build());
	Cache<Long, Schedule> myCacheMV = cacheManager.createCache("myCacheMV", CacheConfigurationBuilder
			.newCacheConfigurationBuilder(Long.class, Schedule.class, ResourcePoolsBuilder.heap(100)).build());

	public enum natureOfCall {
		RequestRide, UpdateRide, CancelRide

	}

	protected ServiceRequest requestType( String fromAdd, String toAdd, int fromZipcode, int toZip, String date,
			String timingType) {    
		
		if (requestType.equalsIgnoreCase("Request")) {
			System.out.println("Requesting Ride for Customer");
			schedule= initialize( fromAdd,  toAdd,  fromZipcode,  toZip,  date,	 timingType);
			if (fromAdd.equalsIgnoreCase("SJ") || toAdd.equalsIgnoreCase("SFO"))
			countSFO++;
			else
			countMV++;	
			if ((fromAdd.equalsIgnoreCase("SJ") || toAdd.equalsIgnoreCase("SFO")) && countSFO <= 3 ) {
				
				myCacheSFO.put(countSFO, schedule);
				System.out.println(3 - countSFO + " seats available for this route");
				if(3 - countSFO==0){
					System.out.println("We cannot allocate any more seat in this request :Please raise a new request");
				}
			
			}
				
			if ((fromAdd.equalsIgnoreCase("SJ") || toAdd.equalsIgnoreCase("SFO")) &&( countSFO > 3 && countSFO <=6 )) {
				
				myCacheSFO.put(countSFO, schedule);
				
				System.out.println(6 - countSFO + " seats available for this route");
				if(6 - countSFO==0){
					System.out.println("We cannot allocate any more seat in this request :Please raise a new request");
				}
				
			}
			
			if ((fromAdd.equalsIgnoreCase("DRD") || toAdd.equalsIgnoreCase("MV")) && countMV <= 4) {
				
				myCacheMV.put(countMV, schedule);
				
				if((4 - countMV)==0){
					System.out.println("We cannot allocate any more seat in this request :Please raise a new request");
				}
				
				System.out.println(4 - countMV + " seats available for this route");

			}


			if ((fromAdd.equalsIgnoreCase("DRD") || toAdd.equalsIgnoreCase("MV")) && (countMV > 5 && countMV <= 8)) {
				
				myCacheMV.put(countMV, schedule);
				
				if((8 - countMV)==0){
					System.out.println("We cannot allocate any more seat in this request :Please raise a new request");
					
				}
				
				System.out.println((8 - countMV) + " seats available for this route");

			}

			if (countSFO == 3) {
				System.out.println("The ride request is alloted for ");
				for (long i = 1; i <= countSFO; i++) {
					Schedule s = myCacheSFO.get(i);
					
					System.out.println("Schedule Carpool Ride from SJ to SFO for the following request : " + i);
					System.out.println(" From Zip: " + s.getFromZipcode() + " To Zip: " + s.getToZipcode());
					System.out.println(" At " + s.getTimingType());
					
				}
			
				schedule = initialize( "SJ",  "SFO ",  95110 ,  98770,  date,	 timingType);
				request = new RequestRide(schedule, requestType);
				request.ride();

			}
			if (countSFO ==6) {
				System.out.println("The ride request is alloted for ");
				for (long i = 4; i <=countSFO ; i++) {
					Schedule s = myCacheSFO.get(i);
					
					System.out.println("Schedule Carpool Ride from SJ to SFO for the following request : " + i);
					System.out.println(" From Zip: " + s.getFromZipcode() + " To Zip: " + s.getToZipcode());
					System.out.println(" At " + s.getTimingType());
					
				}
			
				schedule = initialize( "SJ",  "SFO ",  95610 ,  98770,  date,	 timingType);
				request = new RequestRide(schedule, requestType);
				request.ride();

			}

			if (countMV == 4) {
				System.out.println("The ride request is alloted for ");
				for (long i = 1; i <= countMV; i++) {
					Schedule s = myCacheMV.get(i);
					
					System.out.println("Schedule Carpool Ride from DRD to MV for the following request : " + i);
					System.out.println(" From Zip: " + s.getFromZipcode() + " To Zip: " + s.getToZipcode());
					System.out.println(" At " + s.getTimingType());
				}
				schedule = initialize( "DRD",  "MV",  98770 ,  99200,  date,	 timingType);
				request = new RequestRide(schedule, requestType);
				request.ride();
			}
            
			if (countMV ==8) {
				System.out.println("The ride request is alloted for ");
				for (long i = 5; i <= countMV; i++) {
					Schedule s = myCacheMV.get(i);
					
					System.out.println("Schedule Carpool Ride from DRD to MV for the following request : " + i);
					System.out.println(" From Zip: " + s.getFromZipcode() + " To Zip: " + s.getToZipcode());
					System.out.println(" At " + s.getTimingType());
				}
				schedule = initialize( "DRD",  "MV",  98710 ,  98200,  date,	 timingType);
				request = new RequestRide(schedule, requestType);
				request.ride();
			}


		}
		return this;
	}

	ServiceRequest(String requestType) {

		this.requestType = requestType;
	}

	 static Schedule initialize(String fromAdd, String toAdd, int fromZipcode, int toZip, String date,String timingType){
		Schedule schedule = new RequestSchedule();
		schedule.setDate(date);
		schedule.setFromstreetAdd(fromAdd);
		schedule.setFromZipcode(fromZipcode);
		// schedule.setOption(option);
		schedule.setTimingType(timingType);
		schedule.setTostreetAdd(toAdd);
		schedule.setToZipcode(toZip);
        return schedule; 
	}
}
