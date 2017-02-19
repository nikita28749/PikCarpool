package Parking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Parking {

	ParkingModel model;

	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	// CSV file header
	private static final String FILE_HEADER = "parkingSlotId,garageLocation,parkingSlotStatus,garageCapacity,garageTimeIn,garageTimeOut,ParkingFees";

	StringBuilder parkingDetailsFile = new StringBuilder();
	ParkingModel parking1 = new ParkingModel(1, "SFO", "V", 5, System.currentTimeMillis(),  System.currentTimeMillis()+10000000, 10);

	public static void writeCsvFile() {
		FileWriter fileWriter = null;
		// Create new students objects
		ParkingModel parking1 = new ParkingModel(1, "SFO", "V", 5, System.currentTimeMillis(),  System.currentTimeMillis()+10000000, 10);
		//ParkingModel parking2 = new ParkingModel(2, "Santa Clara", 'O', 15, "10:30", "3:30", 30);
		//ParkingModel parking3 = new ParkingModel(3, "Sunnyvale", 'O', 25, "16:30", "20:30", 20);
		//ParkingModel parking4 = new ParkingModel(4, "San Jose", 'V', 18, "8:30", "9:30", 5);

		// Create a new list of student objects
		List<ParkingModel> parkingOfAllLocations = new ArrayList<ParkingModel>();
		parkingOfAllLocations.add(parking1);
//		parkingOfAllLocations.add(parking2);
//		parkingOfAllLocations.add(parking3);
//		parkingOfAllLocations.add(parking4);

		try {

			fileWriter = new FileWriter("parkingDetailsFile", true);

			// fileWriter = new FileWriter(riderDetailsFile.toString(),true);
			fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\parkingDetailsFile.csv", true);

			// Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			// Write a new student object list to the CSV file
			for (ParkingModel parking : parkingOfAllLocations) {
				fileWriter.append(String.valueOf(parking.getParkingSlotID()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(parking.getGarageLocation());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(parking.getParkingSlotStatus());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(parking.getGarageCapacity()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(parking.getGarageTimeIn()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(parking.getGarageTimeOut()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(parking.getParkingFees()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			System.out.println("CSV file was created successfully !!!");
			fileWriter.flush();
			fileWriter.close();

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		}

	}

	public void listAllSlots() {
		// String[] allparkingInColumns;
		// Parking.writeCsvFile();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("parkingDetailsFile.csv"));
			List<String> allParking = new ArrayList<>();
			String eachLineParking = null;

			while ((eachLineParking = reader.readLine()) != null) {
				allParking.add(eachLineParking);
				// allparkingInColumns = (String[])allParking.toArray();
				// String[] ary = eachLineParking.split(",");
				// System.out.println(ary[1]);
				// System.out.println("Parking is available in" +ary[1]);
			}

			System.out.println("These are parking slot details:");
			// remove header
			allParking.remove(0);
			for (String parking : allParking) {
				System.out.println(parking);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void searchVacantSlot() {
		// Parking.writeCsvFile();
		model=new ParkingModel(1, "SFO", "V", 5, System.currentTimeMillis(),  System.currentTimeMillis()+10000000, 10);
		String[] eachParking = null;
		String[] slotStatus = new String[100];
		String[] slotLocation = new String[100];
		String[] vacantSlots = new String[100];
		String[] vacantSlotsLocation = new String[100];
		String[] occupiedSlots = new String[100];
		String[] occupiedSlotsLocation = new String[100];

		try {

			BufferedReader reader = new BufferedReader(new FileReader("parkingDetailsFile.csv"));
			List<String> allParking = new ArrayList<>();
			String eachLineParking = "V";
			int i = 0;
			while ((eachLineParking = reader.readLine()) != null) {
				allParking.add(eachLineParking);
				eachParking = eachLineParking.split(",");
				slotStatus[i] = eachParking[2];
				slotLocation[i] = eachParking[1];
				i++;

			}

			for (int j = 0; j < vacantSlots.length; j++) {
				for (int k = 0; k < vacantSlots.length; k++) {
					if (slotStatus[k].equalsIgnoreCase("V")) {
						vacantSlots[j] = slotStatus[k];
						vacantSlotsLocation[j] = slotLocation[k];
						System.out.println("The parking slot is available at " + vacantSlotsLocation[j]);
					} else if (slotStatus[k].equals(Character.toString('O'))) {
						occupiedSlots[j] = slotStatus[k];
						occupiedSlotsLocation[j] = slotLocation[k];
						System.out.println("The parking slot is occupied at " + occupiedSlotsLocation[j]);
					} else {
						System.out.println("The parking slot is longer available at that location");
					}
				}

			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//print recepit sent to pik carpool company
	public void calculateParkingFee() 
	{
		
		List<String> allParking = new ArrayList<>();
		String eachLineParking = null;
		String[] eachParking = null;
		long[] startTime = new long[100];
		long[] endTime = new long[100];
		//String[] vacantSlots = new String[100];
		int i = 0;
		double totalParkingCharge = 0;
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader("parkingDetailsFile.csv"));
			while ((eachLineParking = reader.readLine()) != null) {
				allParking.add(eachLineParking);
				eachParking = eachLineParking.split(",");
				startTime[i] = Long.parseLong(eachParking[4]);
				endTime[i] = Long.parseLong(eachParking[5]);
				i++;
				
				for (int j=0;j<startTime.length;j++)
				{
					long totalMilliSeconds = endTime[j]-startTime[j];
					totalParkingCharge = (totalMilliSeconds/(1000*60*60))*5;
				}
				System.out.println("total parking charge is " +totalParkingCharge);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public void assignParking(String driverid,String location){
		int slotnum=1;
		System.out.println("You have been alloted the parking slot "+ slotnum +
				"  member id "+ driverid  +"  for location  "+  location);
		
		
	}


	public void sendParkingNotification() 
	{

	}

}

