package Request;





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.cmpe202.TestPikCarpool;

import Reports.GenerateReport;

public class ProcessRequestManager {
	private String natureOfCall;
	private ServiceRequest servicerequest;
	// private ReportsRequest reports;
	private CustomerServiceRequest cr;
	private String issueType;
	private String priority;
	public static long count = 0L;

	Scanner scan = new Scanner(System.in);

	public ProcessRequestManager(String callType) {
		this.natureOfCall = callType;

	}

	public String navigateRequestType() {

		if (natureOfCall.equalsIgnoreCase("Service")) {
			try {
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Please select an option:Request/Update/Cancel a ride : ");
				String typeOfRequest = bufferRead.readLine();
				servicerequest = new ServiceRequest(typeOfRequest);
				System.out.println("\n");
				while (true) {

					System.out.print("Please enter the from street address : ");
					String fromStreetAdd = bufferRead.readLine();
					System.out.print("Please enter the to street address : ");

					String toStreetAdd = bufferRead.readLine();

					System.out.print("Please enter the from zipcode : ");
					int fromZipcode = Integer.parseInt(bufferRead.readLine());

					System.out.print("Please enter the to zipcode : ");
					int toZipcode = Integer.parseInt(bufferRead.readLine());

					 {
						System.out.print("Please enter the date : ");
						String date = bufferRead.readLine();
						System.out.print("Please select the time ");
						String time = bufferRead.readLine();

						servicerequest.requestType(fromStreetAdd, toStreetAdd, fromZipcode, toZipcode, date, time);

					}
					System.out.print("Do you want to continue? yes/no ");
					String select = bufferRead.readLine();
					if (select.equalsIgnoreCase("yes")){
						continue;}

					//if (!select.equalsIgnoreCase("yes"))
					else{
						System.out.println("Thankyou, for riding with PIK Carpool Company! Enjoy your ride.");
						TestPikCarpool.main(null);}
					
					
					

				}

			} catch (IOException ex) {
				ex.printStackTrace();
			}

		} else if (natureOfCall.equalsIgnoreCase("Reports")) {
			System.out.print("Please select an option for ReportsType:SalesReport/PaymentReport ");
			String answer = scan.nextLine();

			if (answer.equalsIgnoreCase("SalesReport")) {

				GenerateReport reports = new GenerateReport();
				reports.setup();
			} else {
				System.out.println("Generating Reports,takes little time");
			}
		} else if (natureOfCall.equalsIgnoreCase("CustomerService")) {

			try {

				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

				System.out.print("Please enter issue type: ");
				issueType = bufferRead.readLine();

				System.out.print("Please enter the priority of the issue Urgent,NonUrgent : ");
				priority = bufferRead.readLine();

				cr = new CustomerServiceRequest(issueType, priority);
				String s = cr.getInformation();
				System.out.print(s);

			} catch (IOException ex) {
				ex.printStackTrace();
			}

		} else {
			System.out.println("Not a valid option");
		}

		return "You will get confirmation shortly";
	}

}

































/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Reports.GenerateReport;

public class ProcessRequestManager {
	private String natureOfCall;
	private ServiceRequest servicerequest;
	//private ReportsRequest reports;
	private CustomerServiceRequest cr;
	private String issueType;
	private String priority;
	
	
	Scanner scan=new Scanner(System.in);
	
	
	public ProcessRequestManager(String callType){
		this.natureOfCall=callType;
		
		
		
	}
	
	public String navigateRequestType(){
		
		if(natureOfCall.equalsIgnoreCase("Service")){
		
			try{
				 
			     BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			    
			     System.out.print("Please select an option:Request/Update/Cancel a ride : " );
			     String typeOfRequest = bufferRead.readLine();
			      
			     System.out.print("Please enter the from street address : " );
			     String fromStreetAdd = bufferRead.readLine();
			     System.out.print("Please enter the to street address : " );
			     
			     String toStreetAdd = bufferRead.readLine();
			     
			     System.out.print("Please enter the from zipcode : " );
			    String fromZipcode = bufferRead.readLine();
			     //bufferRead.readLine();
			     
			     System.out.print("Please enter the to zipcode : " );
			     
			     String toZipcode = bufferRead.readLine();
			     //bufferRead.readLine();
			    // System.out.print("Please select the schedule option : Instant or scheduled " );
			    // String option = bufferRead.readLine();
			    // System.out.print("Please enter the date : " );
			    // String date = bufferRead.readLine();
			     
			     
			     
			     for(int i=0;i<3;i++){
			    	 System.out.print("Please select the schedule option : Instant or schedule " );
				     String option = bufferRead.readLine();
			    	 if(option.equalsIgnoreCase("instant")){
			    		 System.out.print("Please enter the date : " );
					     String date = bufferRead.readLine();
				            servicerequest=new ServiceRequest(typeOfRequest,fromStreetAdd,toStreetAdd,fromZipcode,toZipcode,date,option);
	        			    //System.out.println("zipcode10="+fromZipcode);
	        			    servicerequest.requestType(typeOfRequest, fromZipcode, toZipcode);
	        			    //System.out.println("zipcode11="+fromZipcode);
					     }
					     else if(option.equalsIgnoreCase("schedule")){
					    	 System.out.print("Please enter the date : " );
						     String date = bufferRead.readLine();
						     System.out.print("Please select the scheduled option : Daily, EveryAlternateWeek,EveryWeekEnd " ); 
					    	 String scheduled = bufferRead.readLine();
					    	 System.out.print("Please select the time " ); 
					    	 String time = bufferRead.readLine();
					    	 servicerequest=new ServiceRequest(typeOfRequest,fromStreetAdd,toStreetAdd,fromZipcode,toZipcode,date,option);
				             //System.out.println("zipcode10="+fromZipcode);
				             servicerequest.requestType(typeOfRequest, fromZipcode, toZipcode);
				             //System.out.println("zipcode11="+fromZipcode);
					     }
			    	 
			    	// System.out.print("Please select the schedule option : Instant or scheduled " );
				   //  String option = bufferRead.readLine();
			    	 
			    	 
			    	 
				    /* if(option.equalsIgnoreCase("instant")){
			            servicerequest=new ServiceRequest(typeOfRequest,fromStreetAdd,toStreetAdd,fromZipcode,toZipcode,date,option);
        			    //System.out.println("zipcode10="+fromZipcode);
        			    servicerequest.requestType(typeOfRequest, fromZipcode, toZipcode);
        			    //System.out.println("zipcode11="+fromZipcode);
				     }
				     else if(option.equalsIgnoreCase("scheduled")){
				    	 servicerequest=new ServiceRequest(typeOfRequest,fromStreetAdd,toStreetAdd,fromZipcode,toZipcode,date,option);
			             //System.out.println("zipcode10="+fromZipcode);
			             servicerequest.requestType(typeOfRequest, fromZipcode, toZipcode);
			             //System.out.println("zipcode11="+fromZipcode);
				     }*/
				     
				     
				    /* System.out.print("Do you want to continue? yes/no " );
				     String select = bufferRead.readLine();
				     
				     if (!select.equalsIgnoreCase("yes")) break;
				     System.out.println("Thankyou, for riding with PIK Carpool Company! Enjoy your ride.");
				     
			    	 
			     }
			      
			      
			     
                 
			     
			     
			    //servicerequest=new ServiceRequest(typeOfRequest,fromStreetAdd,toStreetAdd,fromZipcode,toZipcode);
			     //System.out.println("zipcode10="+fromZipcode);
			    // servicerequest.requestType(typeOfRequest, fromZipcode, toZipcode);
			     //System.out.println("zipcode11="+fromZipcode);
			     
			     
			     
			 }
			 catch(IOException ex)
			 {
			    ex.printStackTrace();
			 }
			//return "You will get confirmation shortly";
			
			
			
			
			
			
			
		}
		else if(natureOfCall.equalsIgnoreCase("Reports")){
			System.out.print("Please select an option for ReportsType:SalesReport/PaymentReport ");
			String answer=scan.nextLine();
			
			if(answer.equalsIgnoreCase("SalesReport")){
			
			GenerateReport reports=new GenerateReport();
			reports.setup();}
			else{System.out.println("Generating Reports,takes little time");}
		}
        else if(natureOfCall.equalsIgnoreCase("CustomerService")){
        	
        	try{
				 
			     BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			    
			     System.out.print("Please enter issue type: ");
			      issueType = bufferRead.readLine();
			      
			     System.out.print("Please enter the priority of the issue Urgent,NonUrgent : " );
			     priority = bufferRead.readLine();
			     
		        	
					
					cr=new CustomerServiceRequest(issueType,priority);
					String s=cr.getInformation();
					 System.out.print(s );
			     
			     
                
			     
			     
			     
			     
			     
			 }
			 catch(IOException ex)
			 {
			    ex.printStackTrace();
			 }
        	
		}
        else{
        	System.out.println("Not a valid option");
        }
		
		return "You will get confirmation shortly";
	}
	
	
	
	
	

}*/
