package Payments;

import Member.DriverModel;
import Member.RiderModel;

//import com.carpooling.system.DriverModel;
//import com.carpooling.system.RiderModel;

public abstract class Payment 
{
	RiderModel riderModel;
	DriverModel driverModel;
	double percentageTax;
	double calculatedAmount;
	long creditLimit;
	int creditScore;
	
	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	double balance;
	double accountBalance;
	
	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public long getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(long creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getPercentageTax() {
		return percentageTax;
	}

	public void setPercentageTax(double percentageTax) {
		this.percentageTax = percentageTax;
	}

	public double getCalculatedAmount() {
		return calculatedAmount;
	}

	public void setCalculatedAmount(double calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	abstract public void collectPayment();
	
	
}
