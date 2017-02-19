package Member;

public class DriverModel 
{
	private int driverId;
	
	private String emailId;
	private String password;
	private String firstName;
	private String lastName;
	private long phNumber;
	private String city;
	private String typeOfVehicle;// : Personal/Taxi
	private long SSN;
	private long accountNumber;
	private long carInsuranceNumber;
	private String carRegistrationNumber;
	private String driverLicenseNumber;
	private String typeOfDebitCard;
	
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	public String getTypeOfDebitCard() {
		return typeOfDebitCard;
	}
	public void setTypeOfDebitCard(String typeOfDebitCard) {
		this.typeOfDebitCard = typeOfDebitCard;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(long phNumber) {
		this.phNumber = phNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTypeOfVehicle() {
		return typeOfVehicle;
	}
	public void setTypeOfVehicle(String typeOfVehicle) {
		this.typeOfVehicle = typeOfVehicle;
	}
	public long getSSN() {
		return SSN;
	}
	public void setSSN(long sSN) {
		SSN = sSN;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getCarInsuranceNumber() {
		return carInsuranceNumber;
	}
	public void setCarInsuranceNumber(long carInsuranceNumber) {
		this.carInsuranceNumber = carInsuranceNumber;
	}
	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}
	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}
	public String getDriverLicenseNumber() {
		return driverLicenseNumber;
	}
	public void setDriverLicenseNumber(String driverLicenseNumber) {
		this.driverLicenseNumber = driverLicenseNumber;
	}
	
	@Override
	public String toString() 
	{
		return  driverId + "," + firstName + "," + lastName + "," + phNumber + "," + emailId + "," + password + "," + city + "," + typeOfDebitCard + ","
		+ accountNumber + "," + SSN + "," + typeOfVehicle + "," + carInsuranceNumber
		+ "," + carRegistrationNumber + "," + driverLicenseNumber;
	}

}
