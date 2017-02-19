package Member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import Payments.CreditCardPayment;

//import com.carpooling.payment.CreditCardPayment;

public class Driver extends Member {
	CreditCardPayment creditCardPayment = new CreditCardPayment();
	RiderModel driverModel = new RiderModel();
	int currentId, numberOfLines;;

	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	// CSV file header

	private static final String FILE_HEADER = "id,firstName,lastName,phNumber,emailId,password,city,typeOfDebitCard,accountNumber,"
			+ "SSN,typeOfVehicle,carInsuranceNumber,carRegistrationNumber,driverLicenseNumber";

	StringBuilder riderDetailsFile = new StringBuilder();

	Scanner input = new Scanner(System.in);

	List<DriverModel> allDrivers = new ArrayList<DriverModel>();

	public void createMember() {

		try {
			int i = 0;
			FileWriter fileWriter = null;
			// fileWriter = new FileWriter("riderDetailsFile",true);

			// fileWriter = new FileWriter(riderDetailsFile.toString(),true);
			fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv", true);

			fileWriter.append(FILE_HEADER.toString());
			fileWriter.append(NEW_LINE_SEPARATOR);

			// get the last id in the line and then increment
			String lastId = "";
			String[] lastIds = new String[100];

			String currentLine, lastLine;
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv"));

			while ((currentLine = br.readLine()) != null) {
				lastLine = currentLine;
				numberOfLines++;
				String[] ary = lastLine.split(",");
				lastId = ary[0];
				lastIds[i] = ary[0];
				i++;
			}

			DriverModel driverModel = new DriverModel();
			if (lastId.equals("")) {
				currentId = 1;
				driverModel.setDriverId(currentId);
			} else if (lastId.contains("'")) {
				String changedId = lastId.replace("'", "");
				for (int j = 0; j < i - 1; j++) {
					if (Integer.parseInt(changedId) < Integer.parseInt(lastIds[i - 2]))
						lastId = lastIds[i - 2];
				}

				currentId = Integer.parseInt(lastId) + 1;
				driverModel.setDriverId(currentId);
			} else {
				currentId = Integer.parseInt(lastId) + 1;
				driverModel.setDriverId(currentId);
			}

			br.close();
			System.out.println("Please provide your first name");
			String fname = input.next();
			driverModel.setFirstName(fname);

			System.out.println("Please provide your last name");
			String lname = input.next();
			driverModel.setLastName(lname);

			System.out.println("Please provide your contact number");
			long num = input.nextLong();
			driverModel.setPhNumber(num);

			try {
				System.out.println("Please provide your emailid");
				String email = input.next();
				driverModel.setEmailId(email);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Please provide your password");
			String pass = input.next();
			driverModel.setPassword(pass);

			System.out.println("Please enter your city");
			String city = input.next();
			driverModel.setCity(city);

			System.out.println("Please provide your type of debit-card: Visa/MasterCard/Discover");
			String typeOfDebitCard = input.next();
			driverModel.setTypeOfDebitCard(typeOfDebitCard);

			System.out.println("Please provide your Account Number");
			long accNum = input.nextLong();
			driverModel.setAccountNumber(accNum);

			System.out.println("Please provide your Social Security Number");
			long ssn = input.nextLong();
			driverModel.setSSN(ssn);

			System.out.println("Please enter type of vehicle: Personal/ Taxi");
			String typeOfVehicle = input.next();
			driverModel.setTypeOfVehicle(typeOfVehicle);

			System.out.println("Please provide your Car Insurance Number");
			long insNum = input.nextLong();
			driverModel.setCarInsuranceNumber(insNum);

			System.out.println("Please provide your Car Registration Number;");
			String carRegNum = input.next();
			driverModel.setCarRegistrationNumber(carRegNum);

			System.out.println("Please provide your Driver License Number");
			String driverLicenseNum = input.next();
			driverModel.setDriverLicenseNumber(driverLicenseNum);

			fileWriter.append(String.valueOf(driverModel));
			fileWriter.flush();
			fileWriter.close();

			System.out.println(
					"Thank You for registering! You are now a Member!" + "\n" + "Your are member id is: " + currentId);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

	public void retrieveDriverMember() {
		try {
			Scanner inputId = new Scanner(System.in);
			int driverIdForRetrieval;

			System.out.println("Please enter the driver id to fetch details");
			driverIdForRetrieval = inputId.nextInt();

			BufferedReader reader = new BufferedReader(new FileReader("newDriverFile.csv"));
			List<String> lines = new ArrayList<>();
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}

			System.out.println(lines.get(0));

			// prints the line given by index
			System.out.println(lines.get(driverIdForRetrieval));
			reader.close();
			inputId.close();
		}

		catch (Exception e) {
			// System.out.println(e.getStackTrace());
			e.printStackTrace();
		}
	}

	public void updateMemberDriverCredentials() {
		//
		System.out.println("Please provide your member id");
		Scanner in = new Scanner(System.in);
		int memberId = in.nextInt();

		System.out.println("Press 1 to update phone number");
		System.out.println("Press 2 to update email address");
		System.out.println("Press 3 to update password");
		System.out.println("Press 4 to update city");
		System.out.println("Press 5 to update your type of debit card");
		System.out.println("Press 6 to update account number");
		System.out.println("Press 7 to update your type of vehicle");
		System.out.println("Press 8 to update your car insurance number");
		System.out.println("Press 9 to update your car registration number");
		System.out.println("Press 0 to view options again!");

		System.out.println("Please enter your choice");
		int choice = in.nextInt();

		try {
			String filePathString = "C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv";
			File filePath = new File(filePathString);

			FileWriter fileWriter = null;

			LinkedHashMap<String, String> eachLineWithIdHashMap = new LinkedHashMap<String, String>();
			// read the file
			BufferedReader reader = new BufferedReader(new FileReader("newDriverFile.csv"));
			List<String> lines = new ArrayList<>();
			String lineOfMemberId;
			String[] lineOfMemberIdArray = null;
			String line = null;

			while ((line = reader.readLine()) != null) {
				lines.add(line);
				String[] ary = line.split(",");
				String id = ary[0];
				// hash map contains the rider id and each line of his details.
				eachLineWithIdHashMap.put(id, line);
			}

			lineOfMemberId = eachLineWithIdHashMap.get(Integer.toString(memberId));
			lineOfMemberIdArray = lineOfMemberId.split(",");
			reader.close();
			try {
				if (filePath.exists()) {
					reader.close();
					filePath.delete();
				}

				if (filePath.delete()) {
					System.out.println("Successfully deleted!");
				} else {
					System.out.println("Delete Operation didn't work.");
				}
			} catch (Exception ioe) {
				System.out.println("ERROR. IO Exception: " + ioe.toString());
			}

			switch (choice) {
			case 1:
				System.out.println("Please enter your new contact number");
				long num = in.nextLong();
				lineOfMemberIdArray[3] = Long.toString(num);
				lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[", "").replace("]", "");
				eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
				if (filePath.exists()) {
					filePath.delete();
				}
				fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv", true);
				for (String s : eachLineWithIdHashMap.values()) {
					fileWriter.append(s);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				fileWriter.close();
				in.close();
				System.out.println("Your record is updated successfully");
				break;
			case 2:
				System.out.println("Please enter your new email address");
				String emailId = in.next();
				lineOfMemberIdArray[4] = emailId;
				lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[", "").replace("]", "");
				eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
				if (filePath.exists()) {
					filePath.delete();
				}
				fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv", true);
				for (String s : eachLineWithIdHashMap.values()) {
					fileWriter.append(s);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				fileWriter.close();
				in.close();
				System.out.println("Your record is updated successfully");
				break;
				
			case 3:
				System.out.println("Please enter your new password");
				String password = in.next();
				lineOfMemberIdArray[5] = password;
				lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[", "").replace("]", "");
				eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
				if (filePath.exists()) {
					filePath.delete();
				}
				fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv", true);
				for (String s : eachLineWithIdHashMap.values()) {
					fileWriter.append(s);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				fileWriter.close();
				in.close();
				System.out.println("Your record is updated successfully");
				break;

			case 4:
				System.out.println("Please enter your new city");
				String city = in.next();
				lineOfMemberIdArray[6] = city;
				lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[", "").replace("]", "");
				eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
				fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv", true);
				for (String s : eachLineWithIdHashMap.values()) {
					fileWriter.append(s);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				fileWriter.close();
				in.close();
				System.out.println("Your record is updated successfully");
				break;

			case 5:
				System.out.println("Please enter your new type of debit card");
				String typeOfDebitCard = in.next();
				lineOfMemberIdArray[7] = typeOfDebitCard;
				lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[", "").replace("]", "");
				eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
				if (filePath.exists()) {
					filePath.delete();
				}
				fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv", true);
				for (String s : eachLineWithIdHashMap.values()) {
					fileWriter.append(s);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				fileWriter.close();
				in.close();
				System.out.println("Your record is updated successfully");
				break;

			case 6:
				System.out.println("Please enter your new account number");
				long accNum = in.nextLong();
				lineOfMemberIdArray[8] = Long.toString(accNum);
				lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[", "").replace("]", "");
				eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
				if (filePath.exists()) {
					filePath.delete();
				}
				fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv", true);
				for (String s : eachLineWithIdHashMap.values()) {
					fileWriter.append(s);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				fileWriter.close();
				in.close();
				System.out.println("Your record is updated successfully");

				break;

			case 7:
				System.out.println("Please enter your new vehicle type:Personal/Taxi");
				String typeOfVehicle = in.next();
				lineOfMemberIdArray[9] = typeOfVehicle;
				lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[", "").replace("]", "");
				eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
				if (filePath.exists()) {
					filePath.delete();
				}
				fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv", true);
				for (String s : eachLineWithIdHashMap.values()) {
					fileWriter.append(s);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				fileWriter.close();
				in.close();
				System.out.println("Your record is updated successfully");
				break;

			case 8:
				System.out.println("Please enter your new car insurance number");
				long carInsuranceNumber = in.nextLong();
				lineOfMemberIdArray[11] = Long.toString(carInsuranceNumber);
				lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[", "").replace("]", "");
				eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
				if (filePath.exists()) {
					filePath.delete();
				}
				fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv", true);
				for (String s : eachLineWithIdHashMap.values()) {
					fileWriter.append(s);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				fileWriter.close();
				in.close();
				System.out.println("Your record is updated successfully");
				break;
	
			case 9:
				System.out.println("Please enter your new car registration number");
				String carRegistrationNumber = in.next();
				lineOfMemberIdArray[12] = carRegistrationNumber;
				lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[", "").replace("]", "");
				eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
				if (filePath.exists()) {
					filePath.delete();
				}
				fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv", true);
				for (String s : eachLineWithIdHashMap.values()) {
					fileWriter.append(s);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				fileWriter.close();
				in.close();
				System.out.println("Your record is updated successfully");
				break;

			case 0:
				System.out.println("Press 1 to update phone number");
				System.out.println("Press 2 to update email address");
				System.out.println("Press 3 to update password");
				System.out.println("Press 4 to update credit card number");
				System.out.println("Press 5 to update cvv");
				System.out.println("Press 6 to update expiration date");
				System.out.println("Press 7 to update zip code");
				break;

			}

			in.close();
		}

		catch (Exception e) {
			// e.printStackTrace();
			e.getMessage();
		}
	}

	public void deleteMember() {
		try {
			String filePathString = "C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv";
			File f = new File(filePathString);

			Scanner inputId = new Scanner(System.in);
			int driverIdForDeleteMember;

			System.out.println("Please enter the driver id to withdraw ownership");
			driverIdForDeleteMember = inputId.nextInt();

			BufferedReader reader = new BufferedReader(new FileReader("newDriverFile.csv"));
			List<String> lines = new ArrayList<>();
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}

			lines.remove(driverIdForDeleteMember);

			if (f.exists()) {
				f.delete();
			}

			// fileWriter = new
			// FileWriter("C:\\Users\\neha\\Desktop\\riderDetailsFile.csv",true);
			FileWriter fileWriter = new FileWriter(f);
			for (String eachLine : lines) {
				fileWriter.append(eachLine);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			fileWriter.close();

			System.out.println("Thank You. You are no longer a member of PIK Carpooling company!");
			reader.close();
			inputId.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void retrieveMemberInfo() {
		retrieveDriverMember();
	}

	public void viewPaymentInfo() {
		try {
			Scanner inputId = new Scanner(System.in);
			String[] lineWithIdDetailsArray = new String[100];
			int driverIdForRetrieval;

			System.out.println("Please enter the driver id to fetch details");
			driverIdForRetrieval = inputId.nextInt();

			BufferedReader reader = new BufferedReader(new FileReader("newDriverFile.csv"));
			List<String> lines = new ArrayList<>();
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			String lineWithIdDetails = lines.get(driverIdForRetrieval);
			lineWithIdDetailsArray = lineWithIdDetails.split(",");
			System.out.println("The type of debit card for this memebr is:" + lineWithIdDetailsArray[7]);
			inputId.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isBackgroundCheckSuccess() {
		return creditCardPayment.checkCreditHistory();

	}

}

