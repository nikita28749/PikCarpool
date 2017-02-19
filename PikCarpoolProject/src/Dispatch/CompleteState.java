package Dispatch;

import java.util.Scanner;

import Notifications.Notifications;
import Notifications.Observers;
import Payments.CreditCardPayment;
import Tracking.CarSurveylance;
import Tracking.Tracking;

public class CompleteState implements DispatchState,Observers {
	DispatchContext dc;
	CreditCardPayment pay;
	Tracking tr;
	private String name;
	private Notifications notify;
	Scanner scan=new Scanner(System.in);
	
	public CompleteState(String nm){
		this.name=nm;
	}
	
	CompleteState(DispatchContext dc){
		this.dc=dc;
		
		
		
	}

	@Override
	public void requestDispatch() {
		System.out.println(" Already Assigned for process");
		
	}

	@Override
	public String processDispatch(int fromZip) {
		System.out.println(" Dispatched Vehicle");
		return "Dispatched Vehicle";
		
	}

	@Override
	public void completeDispatch() {
		
		
		System.out.println(" Completed Dispatch");
		System.out.print("Do you need the tracking status of the vehicle? Please press option 1 for yes and 2 for no");
		int answer=scan.nextInt();
		if(answer==1){
			
		tr=new Tracking();
		String tracking=tr.vehicleTracking();
		CarSurveylance car=new CarSurveylance(tr);
		
		if(tracking.equals("vehicle trouble")){
			System.out.println("No Payment for the ride ");	
			car.setCarSurveylanceFlag(true);
		}
		else{
			car.setCarSurveylanceFlag(true);
		pay=new CreditCardPayment();
		pay.calculatePayment();
		}
	}
		else{System.out.println("Thankyou for riding!");
		pay=new CreditCardPayment();
		pay.calculatePayment();}

		
		
	}

	@Override
	public void update() {
		String msg = (String) notify.getUpdate(this);
		if(msg == null){
			//System.out.println(name+":: No new message");
		}else
		System.out.println(name+":: Consuming message::"+msg);
		
	}

	@Override
	public void setNotifications(Notifications notify) {
		this.notify=notify;
		
	}

}
