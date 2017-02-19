package Member;

public class RiderModel 
{
	private int riderId;
	
	private String emailId;
	private String password;
	private String name;
	private long phNumber;
	private long creditCardNumber;
	private int cvv;
	private String expirationDate;
	private long zipCode;
	private String typeOfCreditCard;
	
	
	public String getTypeOfCreditCard() {
		return typeOfCreditCard;
	}
	public void setTypeOfCreditCard(String typeOfCreditCard) {
		this.typeOfCreditCard = typeOfCreditCard;
	}
	public int getRiderId() {
		return riderId;
	}
	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(long phNumber) {
		this.phNumber = phNumber;
	}
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		/*return "[riderId=" + riderId + ", emailId=" + emailId + ", password=" + password + ", name=" + name
				+ ", phNumber=" + phNumber + ", creditCardNumber=" + creditCardNumber + ", cvv=" + cvv
				+ ", expirationDate=" + expirationDate + ", zipCode=" + zipCode + "]";*/
		
		//id,name,phNumber,emailId,password,creditCardNumber,cvv,expirationDate,zipCode
	//	id,name,phNumber,emailId,password,typeOfCreditCard,creditCardNumber,cvv,expirationDate,zipCode
		return  riderId + "," + name + "," + phNumber + "," + emailId + "," + password + ","+ typeOfCreditCard + 
				"," + creditCardNumber + "," + cvv + "," + expirationDate + "," + zipCode ;
		
		/*return " + riderId + "," + emailId + "," + password + "," + name + "," + phNumber + "," + creditCardNumber + "," +
		cvv + "," + expirationDate + "," + zipCode +" ;*/
	}

}

