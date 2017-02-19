package Member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import Payments.CreditCardPayment;

//import com.carpooling.payment.CreditCardPayment;
//import com.carpooling.payment.Payment;

public class Rider extends Member
{
	CreditCardPayment creditCardPayment = new CreditCardPayment();
	RiderModel riderModel = new RiderModel();
	int currentId,numberOfLines;;

	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	//CSV file header

	private static final String FILE_HEADER = "id,name,phNumber,emailId,password,typeOfCreditCard,creditCardNumber,cvv,expirationDate,zipCode";


	StringBuilder riderDetailsFile = new StringBuilder();

	Scanner input = new Scanner(System.in);


	List<RiderModel> allRiders = new ArrayList<RiderModel>();

	public void createMember() 
	{

		try
		{
			int i=0;
			FileWriter fileWriter = null;
			//fileWriter = new FileWriter("riderDetailsFile",true);

			//fileWriter = new FileWriter(riderDetailsFile.toString(),true); 
			fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv",true);

			//fileWriter.append(FILE_HEADER.toString());
			fileWriter.append(NEW_LINE_SEPARATOR);

			//get the last id in the line and then increment
			String lastId = "";
			String[] lastIds = new String[100];
			
			String currentLine,lastLine;
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv"));			
			while ((currentLine = br.readLine()) != null) 
			{
				//System.out.println(currentLine);
				lastLine = currentLine;
				numberOfLines++;
				String[] ary = lastLine.split(",");
				lastId = ary[0];
				//ary[0] = lastIds[i];
				lastIds[i] = ary[0];
				i++;	
			}		
			RiderModel riderModel = new RiderModel();
			if(lastId.equals(""))
			{
				currentId = 1;
				riderModel.setRiderId(currentId);
			}
			else if(lastId.contains("'"))
			{
					String changedId = lastId.replace("'", "");
					for(int j=0;j<i-1;j++)
					{
						if(Integer.parseInt(changedId) < Integer.parseInt(lastIds[i-2]))
							lastId = lastIds[i-2];
					}
					
					currentId = Integer.parseInt(lastId)+1;
					riderModel.setRiderId(currentId);
			}
			else
			{
				currentId = Integer.parseInt(lastId)+1;
				riderModel.setRiderId(currentId);
			}

			//			System.out.println(currentId);

			System.out.println("Please provide your name");
			String name = input.nextLine();
			riderModel.setName(name);

			System.out.println("Please provide your contact number");
			long num = input.nextLong();
			riderModel.setPhNumber(num);

			try
			{
				System.out.println("Please provide your emailid");
				String email = input.next();
				riderModel.setEmailId(email);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("Please provide your Expiration Date");
			String exDate = input.next();
			//riderModel.setExpirationDate(exDate);
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			//int day = cal.get(Calendar.DAY_OF_MONTH);
			String[] monthAndYear = exDate.split("/");
			if((Integer.parseInt(monthAndYear[1])) > year || (Integer.parseInt(monthAndYear[0])>= month))
			{
				riderModel.setExpirationDate(exDate);
			}
			else
			{
				System.out.println("Expiration Date id already passed. Card is no longer valid.Sorry!");
			}
			
			System.out.println("Please provide your type of credit-card: Visa/MasterCard/Discover");
			String typeOfCreditCard = input.next();
			riderModel.setTypeOfCreditCard(typeOfCreditCard);


			System.out.println("Please provide your Credit Card Number");
			long numC = input.nextLong();
			riderModel.setCreditCardNumber(numC);

			System.out.println("Please provide your CVV");
			int cvv = input.nextInt();
			riderModel.setCvv(cvv);

			System.out.println("Please provide your zip code");
			long zip = input.nextLong();
			riderModel.setZipCode(zip);

			System.out.println("Please provide your password");
			String pass = input.next();
			riderModel.setPassword(pass);

			//allRiders.add(riderModel);

			fileWriter.append(String.valueOf(riderModel));
			fileWriter.flush();
			fileWriter.close();
			br.close();

			System.out.println("Thank You for registering! You are now a Member!" + "\n" + "Your are member id is: "+currentId);



		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}

	}

	public void retrieveRiderMember()
	{
		try
		{
			Scanner inputId = new Scanner(System.in);
			int riderIdForRetrieval;

			System.out.println("Please enter the rider id to fetch details");
			riderIdForRetrieval = inputId.nextInt();

			BufferedReader reader = new BufferedReader(new FileReader("newRiderFile.csv"));
			List<String> lines = new ArrayList<>();
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);


			}

			//String[] ary = line.split(",");
			//System.out.println(ary[0]);

			//print individual columns of array
			//			String[] columns = (String[]) lines.toArray();
			//			System.out.println(columns[0]);

			System.out.println(lines.get(0));

			//prints the line given by index
			System.out.println(lines.get(riderIdForRetrieval));
			reader.close();
			inputId.close();
		}

		catch(Exception e)
		{
			//System.out.println(e.getStackTrace());
			e.printStackTrace();
		}

	}
	public void updateMemberRiderCredentials()
	{
		//id,name,phNumber,emailId,password,creditCardNumber,cvv,expirationDate,zipCode

		System.out.println("Please provide your member id");
		Scanner in = new Scanner(System.in);
		int memberId = in.nextInt();

		System.out.println("Press 1 to update phone number");
		System.out.println("Press 2 to update email address");
		System.out.println("Press 3 to update password");
		System.out.println("Press 4 to update credit card number");
		System.out.println("Press 5 to update cvv");
		System.out.println("Press 6 to update expiration date");
		System.out.println("Press 7 to update zip code");
		System.out.println("Press 8 to update type of credit card");
		System.out.println("Press 9 to view the update menu again");

		System.out.println("Please enter your choice");
		int choice = in.nextInt();

		try
		{
			String filePathString =  "C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv";
			Path fileToDeletePath = Paths.get("newRiderFile.csv");
			
			File filePath = new File(filePathString);

			FileWriter fileWriter = null;
			//FileWriter fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv",true);
//			
//			fileWriter.append(NEW_LINE_SEPARATOR);
//			
//			
			
			//HashMap<Integer, String> eachLineWithId = new HashMap<Integer, String>();
			LinkedHashMap<String, String> eachLineWithIdHashMap = new LinkedHashMap<String, String>();
			//read the file
			BufferedReader reader = new BufferedReader(new FileReader("newRiderFile.csv"));
			List<String> lines = new ArrayList<>();
			String lineOfMemberId;
			String[] lineOfMemberIdArray = null;
			String line = null;
			
			
			//put each line of string to a list
//			while ((line = reader.readLine()) != null) {
//				lines.add(line);
//				if(line.equals(""))
//				{
//					lines.remove(line);
//				}
//			}
			
			while ((line = reader.readLine()) != null) {
				lines.add(line);
				String[] ary = line.split(",");
				String id = ary[0];
				//ary[0] = lastIds[i];
				//lastIds[i] = ary[0];
				
				//hash map contains the rider id and each line of his details.
				eachLineWithIdHashMap.put(id, line);
			}
			
			//lineOfMemberId = lines.get(memberId);
			lineOfMemberId = eachLineWithIdHashMap.get(Integer.toString(memberId));
		//	lines.remove(memberId);
			lineOfMemberIdArray = lineOfMemberId.split(",");
			reader.close();
			
				if(filePath.exists())
				{
					reader.close();
					filePath.delete();
				}	
			switch(choice)
			{
			case 1: System.out.println("Please enter your new contact number" );
					long num = in.nextLong();
					lineOfMemberIdArray[2] = Long.toString(num);
				   	   lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[","").replace("]",""); 
				   	   eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
				   	   fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv",true);
				   	   for(String s:eachLineWithIdHashMap.values())
				   	   {
				   		   fileWriter.append(s);
				   		   fileWriter.append(NEW_LINE_SEPARATOR);
				   	   }
				   	   fileWriter.close();
				   	in.close();
				   	   System.out.println("Your record is updated successfully" );
					break;
					
			case 2:System.out.println("Please enter your new email address" );
				   String emailId  = in.next();
				   lineOfMemberIdArray[3] = emailId;
				   lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[","").replace("]",""); 
			   	   eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
			   	   fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv",true);
			   	   for(String s:eachLineWithIdHashMap.values())
			   	   {
			   		   fileWriter.append(s);
			   		   fileWriter.append(NEW_LINE_SEPARATOR);
			   	   }
			   	   fileWriter.close();
			   	in.close();
				   System.out.println("Your record is updated successfully" );
				   break;
				   
			case 3:System.out.println("Please enter your new password" );
			   	   String password  = in.next();
			   	   lineOfMemberIdArray[4] = password;
			   	   lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[","").replace("]",""); 
			   	   eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
			   	   fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv",true);
			   	   for(String s:eachLineWithIdHashMap.values())
			   	   {
			   		   fileWriter.append(s);
			   		   fileWriter.append(NEW_LINE_SEPARATOR);
			   	   }
			   	   fileWriter.close();
			   	in.close();
			   	   System.out.println("Your record is updated successfully" );
			   	   break;
			   	   
			case 4:System.out.println("Please enter your new credit card number" );
				   long creditCardNum = in.nextLong();
				   lineOfMemberIdArray[6] = Long.toString(creditCardNum);
				   lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[","").replace("]",""); 
			   	   eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
			   	   fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv",true);
			   	   for(String s:eachLineWithIdHashMap.values())
			   	   {
			   		   fileWriter.append(s);
			   		   fileWriter.append(NEW_LINE_SEPARATOR);
			   	   }
			   	fileWriter.close();
			   	in.close();
		   	      System.out.println("Your record is updated successfully" );
		   	      break;
		   	   
			case 5:System.out.println("Please enter your the new CVV" );
				   int newCvv = in.nextInt();
				   lineOfMemberIdArray[7] = Integer.toString(newCvv);
				   lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[","").replace("]",""); 
			   	   eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
			   	   fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv",true);
			   	   for(String s:eachLineWithIdHashMap.values())
			   	   {
			   		   fileWriter.append(s);
			   		   fileWriter.append(NEW_LINE_SEPARATOR);
			   	   }
			   	fileWriter.close();
			   	in.close();
		   	   System.out.println("Your record is updated successfully" );
		   	break;
		   	   
			case 6:System.out.println("Please enter the new expiration date" );
		   	   String expDate  = in.next();
		   	   lineOfMemberIdArray[8] = expDate;
		   	   lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[","").replace("]",""); 
		   	   eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
		   	   fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv",true);
		   	   for(String s:eachLineWithIdHashMap.values())
		   	   {
		   		   fileWriter.append(s);
		   		   fileWriter.append(NEW_LINE_SEPARATOR);
		   	   }
		   	fileWriter.close();
		   	in.close();
		   	   System.out.println("Your record is updated successfully" );
		   	
		   	break;
		   	   
			case 7:System.out.println("Please enter your new zipcode" );
		   	   String zipCode  = in.next();
		   	   lineOfMemberIdArray[9] = zipCode;
		   	   lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[","").replace("]",""); 
		   	   eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
		   	   fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv",true);
		   	   for(String s:eachLineWithIdHashMap.values())
		   	   {
		   		   fileWriter.append(s);
		   		   fileWriter.append(NEW_LINE_SEPARATOR);
		   	   }
		   	fileWriter.close();
		   	in.close();
		   	   System.out.println("Your record is updated successfully" );
		   	break;
		   	
			case 8:System.out.println("Please enter your new credit card's type: Visa/MasterCard/Discover" );
		   	   String typeOfCreditCard  = in.next();
		   	   lineOfMemberIdArray[5] = typeOfCreditCard;
		   	   lineOfMemberId = Arrays.toString(lineOfMemberIdArray).replace("[","").replace("]",""); 
		   	   eachLineWithIdHashMap.put(Integer.toString(memberId), lineOfMemberId);
		   		fileWriter = new FileWriter("C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv",true);
		   	   for(String s:eachLineWithIdHashMap.values())
		   	   {
		   		   fileWriter.append(s);
		   		   fileWriter.append(NEW_LINE_SEPARATOR);
		   	   }
		   	fileWriter.close();
		   	in.close();
		   	   System.out.println("Your record is updated successfully" );
		   	   break;
		   	
			case 9:System.out.println("Press 1 to update phone number");
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

		catch(Exception e)
		{
		//	e.printStackTrace();
			e.getMessage();
		}





	}
	public void deleteMember()
	{
		try
		{
			String filePathString =  "C:\\Users\\sista\\Desktop\\Assignment\\workface\\PikCarpoolProject\\newDriverFile.csv";
			File f = new File(filePathString);

			//FileWriter fileWriter = null;
			
			//fileWriter.append(NEW_LINE_SEPARATOR);
			//if file exists delete it 
			//create new file with the same file name 
			Scanner inputId = new Scanner(System.in);
			int riderIdForDeleteMember;

			System.out.println("Please enter the rider id to withdraw ownership");
			riderIdForDeleteMember = inputId.nextInt();

			BufferedReader reader = new BufferedReader(new FileReader("newRiderFile.csv"));
			List<String> lines = new ArrayList<>();
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);  
			}

			lines.remove(riderIdForDeleteMember);
			
			
			if(f.exists())
			{
				f.delete();
			}
			
			
			//fileWriter = new FileWriter("C:\\Users\\neha\\Desktop\\riderDetailsFile.csv",true);
			FileWriter fileWriter = new FileWriter(f);
			for(String eachLine:lines)
			{
				fileWriter.append(eachLine);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			fileWriter.close();

			System.out.println("Thank You. You are no longer a member of PIK Carpooling company!");
			reader.close();
			inputId.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public void retrieveMemberInfo()
	{
		retrieveRiderMember();
	}
	public void viewPaymentInfo()
	{
		try
		{
			Scanner inputId = new Scanner(System.in);
			String[] lineWithIdDetailsArray = new String[100];
			int riderIdForRetrieval;

			System.out.println("Please enter the rider id to fetch details");
			riderIdForRetrieval = inputId.nextInt();

			BufferedReader reader = new BufferedReader(new FileReader("newRiderFile.csv"));
			List<String> lines = new ArrayList<>();
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			String lineWithIdDetails = lines.get(riderIdForRetrieval);
			lineWithIdDetailsArray = lineWithIdDetails.split(",");
			System.out.println("The type of Credit card for this memebr is:" +lineWithIdDetailsArray[5]);
			inputId.close();
			reader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean isBackgroundCheckSuccess()
	{
		return creditCardPayment.checkCreditHistory();

	}


}
