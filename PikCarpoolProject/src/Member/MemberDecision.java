package Member;

import java.util.Scanner;

public class MemberDecision {
	
	Rider member;
	Driver driver;
	//Parking parking ;
	
	
	public void decideClass()
	{
		try
		{
			int choice;
			String answer;
			//parking = new Parking();
			System.out.println("Please enter your choice");
			Scanner input = new Scanner(System.in);
			Scanner inputAnswer = new Scanner(System.in);
			//			BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
			choice = input.nextInt();

			switch(choice)
			{
			case 1: System.out.println("Do you want to register as a rider or a driver?");
			answer = inputAnswer.nextLine();


			if(answer.toLowerCase().equals("rider"))
			{
				member = new Rider();
				member.createMember();
			}
			else if(answer.toLowerCase().equals("driver"))
			{
				driver = new Driver();
				driver.createMember();
			}
			else
			{
				System.out.println("please provide valid input");
			}

			break;

			case 2: System.out.println("Do you want to retrieve the details of a member by id? Please enter yes or no.");
			answer = inputAnswer.nextLine();

			if(answer.toLowerCase().equals("yes"))
			{
				System.out.println("Enter R To retrive the details by id of rider");
				System.out.println("Enter D To retrive the details by id of driver");
				char ch = input.next().charAt(0);
				if(ch == 'R')
				{
					member = new Rider();
					member.retrieveRiderMember();
				}
				else if(ch == 'D')
				{
					driver = new Driver();
					driver.retrieveDriverMember();
				}
				else
				{
					System.out.println("Press 1 to become member");
					System.out.println("Press 2 to retrieve member details");
					System.out.println("Press 3 to update member info");
					System.out.println("Press 4 to withdraw membership");
					decideClass();
				}
			}
			else
			{
				System.out.println("Thank You!");
				System.out.println("Press 1 to become member");
				System.out.println("Press 2 to retrieve member details");
				System.out.println("Press 3 to update member info");
				System.out.println("Press 4 to withdraw membership");
				decideClass();
			}
			break;
			
			case 3: System.out.println("Enter R To update the details by id of rider");
					System.out.println("Enter D To update the details by id of driver");
					char ch = input.next().charAt(0);
			if(ch == 'R')
			{
				member = new Rider();
				member.updateMemberRiderCredentials();
			}
			else if(ch == 'D')
			{
				driver = new Driver();
				driver.retrieveDriverMember();
			}
			else
			{
				System.out.println("Press 1 to become member");
				System.out.println("Press 2 to retrieve member details");
				System.out.println("Press 3 to update member info");
				System.out.println("Press 4 to withdraw membership");
				decideClass();
			}
			break;
			case 4: 
				member = new Rider();
			//	member.retrieveMember();
				member.deleteMember();
			break;
			//case 5: System.out.println("Please do parking");
			//parking.listAllSlots();
			//break;
			
			//case 6: parking.searchVacantSlot();
			case 5: 
				member= new Rider();
				member.viewPaymentInfo();
			case 0: System.out.println("Press 1 to become member");
			System.out.println("Press 2 to retrieve member details");
			System.out.println("Press 3 to update member info");
			System.out.println("Press 4 to withdraw membership");
			decideClass();
			break;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}


	}

}
