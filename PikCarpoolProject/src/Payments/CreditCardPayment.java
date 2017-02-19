package Payments;

import Dispatch.*;

//import com.carpooling.dispatch.DispatchModel;

public class CreditCardPayment extends Payment
{
	ProcessState pr;
	double totalMiles;
	long totalWaitingTimeInMilliseconds,totalTimeForDestinationInMilliseconds,totalWaitingTimeInMinutes,totalTimeForDestinationInMinutes;
	double totalAmount,costOfTotalMile;
	double amountForWholeRide;


	public double calculatePayment()
	
	{
		pr=new ProcessState();
		totalMiles = pr.getNumberOfMiles();
		totalWaitingTimeInMilliseconds = pr.getWaitingTime();
		totalTimeForDestinationInMilliseconds = pr.getTimeForDestination();

		//calculate cost of ride for miles covered
		costOfTotalMile = totalMiles * pr.costOfRidePerMile;
		//calculate waiting time in minutes
		totalWaitingTimeInMinutes = totalWaitingTimeInMilliseconds/1000*60;
		//calculate time taken to cover destination in minutes
		totalTimeForDestinationInMinutes = totalTimeForDestinationInMilliseconds/1000*60;
		//calculate total amount
		totalAmount = (ProcessState.baseFare) + costOfTotalMile + (totalWaitingTimeInMinutes*ProcessState.waitingTimePerMinute)+
				(totalTimeForDestinationInMinutes*ProcessState.costOfRidePerMinute)+ (ProcessState.taxPerRide);
		System.out.println("The totalfare is :"+totalAmount);
		return totalAmount;

	}
	public void chargeCreditCard(Long creditCardNumber)
	{

		amountForWholeRide = calculatePayment();
		long creditAmountOnCreditCard = getCreditLimit();
		double balanceAmountSpentOnCreditCard = getBalance();

		if(balanceAmountSpentOnCreditCard >= creditAmountOnCreditCard)
		{
			//actually you should notify
			System.out.println("Sorry" +riderModel.getName() + " !" +" You have no sufficient funds for this ride!");
		}
		else
		{
			double updatedBalance = balanceAmountSpentOnCreditCard+amountForWholeRide;
			setBalance(updatedBalance);
			System.out.println("Payment Received. Thank You!");
		}
	}

	public void collectPayment() 
	{
		chargeCreditCard(riderModel.getCreditCardNumber());;
	}

	public void payToDriver()
	{
		driverModel.getAccountNumber();
		double driverAccountBalance = getAccountBalance();
		double newDriverAccountBalance = driverAccountBalance+amountForWholeRide;
		setAccountBalance(newDriverAccountBalance);
		System.out.println("Payment to driver is successful!");
	}
	public boolean checkCreditHistory()
	{
		setCreditScore(creditScore);
		if(getCreditScore()>=600)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}