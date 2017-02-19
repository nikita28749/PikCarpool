package com.cmpe202;

import java.util.Scanner;

import Member.MemberDecision;
import Parking.Parking;
import Request.ProcessRequestManager;
import Schedule.RequestSchedule;



import Dispatch.DispatchContext;
import Tracking.*;

public class TestPikCarpool {

	public static void main(String[] args) {
		//RequestSchedule r=new RequestSchedule();
		//r.schedule("carpool", "instant", 94536,94538);
		//r.schedule("carpool", "instant", 7, 5);
		//DispatchContext dp=new DispatchContext();
		//dp.requestDispatch();
		//dp.processDispatch(3);
		//dp.completeDispatch();
		Parking p=new Parking();
		//Parking.writeCsvFile();
		
		//Tracking track=new Tracking();
		//track.vehicleTracking();
		//System.out.println("CarSurveylance is on");
		//CarSurveylance car=new CarSurveylance(track);
		//car.setCarSurveylanceFlag(true);
		
		
		
		System.out.println("********** WELCOME TO PIK CARPOOL SYSTEM ************ ");
		System.out.println("********** Please Select from the following menus************");
		System.out.println("1. Member Menu ");
		System.out.println("2. Request a Ride");
		System.out.println("3. Request for Reports");
		System.out.println("4. CustomerService");
		System.out.println("5. Parking Request");
		
		//System.out.println("5.Tracking of Vehicle ");
		
		
		
		System.out.print("Please enter the number: ");
		
		
		Scanner scan=new Scanner(System.in);
		int input=scan.nextInt();
		
		if(input==1){
			System.out.println("How can we help you regarding your membership? Please select from the following options: ");
			System.out.println("Press 1 to become member");
			System.out.println("Press 2 to retrieve member details");
			System.out.println("Press 3 to update member info");
			System.out.println("Press 4 to withdraw membership");
			System.out.println("Press 5 to list all parking slots");
			System.out.println("Press 6 to search for vacant slots");
			System.out.println("Press 7 to view payment info");
			System.out.println("Press 0 to exit");
			MemberDecision md=new MemberDecision();
			md.decideClass();
		

		
		}
			
			else if (input==2){
				System.out.print("Are you a member of PikCarpool? Yes/No: ");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("Yes")){
					System.out.print("Please select an option ServiceRequest/ReportsRequest/Others: ");
					String answer1=scan.next();
				
				
				
				
				ProcessRequestManager prm=new ProcessRequestManager(answer1);
				prm.navigateRequestType();
				}
				else{System.out.println("Please register as a member");}
				
				
				
					
				}
			else if(input==3){
				System.out.print("Are you a member of PikCarpool? Yes/No: ");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("Yes")){
					System.out.print("Please select an option ServiceRequest/ReportsRequest/Others: ");
					
					String answer1=scan.next();
					
					ProcessRequestManager prm=new ProcessRequestManager(answer1);
					prm.navigateRequestType();
					
					}
				
				else{System.out.println("Please register as a member");}
				
				
				
			}
			
			else if(input==4){
				
					System.out.print("Please select an option ServiceRequest/ReportsRequest/CustomerService: ");
					
					String answer1=scan.next();
					
					ProcessRequestManager prm=new ProcessRequestManager(answer1);
					prm.navigateRequestType();
					
					}
			else if(input==5){
				
				System.out.print("Are you a driver member? Yes/No: ");
				String answer1=scan.next();
				if(answer1.equalsIgnoreCase("yes")){
					System.out.print("Please give your member id: ");
					String answer2=scan.next();
					System.out.print("Please give destination street: ");
					String answer3=scan.next();
					p.searchVacantSlot();
					p.assignParking(answer2, answer3);
					
					
				}
				else{
					System.out.println("Please register as a driver ");
					
				}
				
				
				
				}
		
		
				
				else{System.out.println("Please register as a member");}
				
				
				
			}
			
		}
	
			

