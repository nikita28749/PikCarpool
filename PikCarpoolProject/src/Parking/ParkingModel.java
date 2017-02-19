package Parking;

import java.util.Date;

public class ParkingModel 
{
	public ParkingModel(int parkingSlotID,String garageLocation, String parkingSlotStatus, int garageCapacity,
			long garageTimeIn, long garageTimeOut, double parkingFees) {
		//super();
		//this.model = model;
		this.parkingSlotID = parkingSlotID;
		this.garageLocation = garageLocation;
		this.parkingSlotStatus = parkingSlotStatus;
		this.garageCapacity = garageCapacity;
		this.garageTimeIn = garageTimeIn;
		this.garageTimeOut = garageTimeOut;
		this.parkingFees = parkingFees;
		
	}


	String garageLocation;
	String parkingSlotStatus;
	int garageCapacity;
	long garageTimeIn;
	long garageTimeOut;
	double parkingFees;
	int parkingSlotID;

	public int getParkingSlotID() {
		return parkingSlotID;
	}
	public void setParkingSlotID(int parkingSlotID) {
		this.parkingSlotID = parkingSlotID;
	}

	public String getParkingSlotStatus() {
		return parkingSlotStatus;
	}
	public void setParkingSlotStatus(String parkingSlotStatus) {
		this.parkingSlotStatus = parkingSlotStatus;
	}

	public String getGarageLocation() {
		return garageLocation;
	}
	public void setGarageLocation(String garageLocation) {
		this.garageLocation = garageLocation;
	}
	public int getGarageCapacity() {
		return garageCapacity;
	}
	public void setGarageCapacity(int garageCapacity) {
		this.garageCapacity = garageCapacity;
	}
	public long getGarageTimeIn() {
		return garageTimeIn;
	}
	public void setGarageTimeIn(long garageTimeIn) {
		this.garageTimeIn = garageTimeIn;
	}
	public long getGarageTimeOut() {
		return garageTimeOut;
	}
	public void setGarageTimeOut(long garageTimeOut) {
		this.garageTimeOut = garageTimeOut;
	}
	public double getParkingFees() {
		return parkingFees;
	}
	public void setParkingFees(double parkingFees) {
		this.parkingFees = parkingFees;
	}


}



