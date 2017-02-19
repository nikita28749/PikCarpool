package Member;

public abstract class Member 
{
	//in become member 
	// 3 methods
	// member info - call retrive method
	// credit card info
	// background check - background check criminal record 
	// system.out.prinln. call the credit card class method// credit check 
	//creditHistoryCheck
	//checkMEmber --name
	public void becomeMember()
	{
		retrieveMemberInfo();
		showProgress();
		//add a new field type of card
		//check if visa or mastercard
		viewPaymentInfo();
		//call checkCreditHistory for rider
		//call checkCreditHistory for driver
		isBackgroundCheckSuccess();
		
	}
	
	abstract public void retrieveMemberInfo();
	abstract public void viewPaymentInfo();
	abstract public boolean isBackgroundCheckSuccess();
	
	public void showProgress()
	{
		System.out.println("Retrieving details! This may take sometime");
	}
	
	
//	abstract public void createMember();
//	abstract public void retrieveMember();
//	abstract public void updateMemberCredentials();
//	abstract public void deleteMember();

}
