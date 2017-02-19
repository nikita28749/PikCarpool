package Vehicle;

public class Vehicle {

	public String registration;
	 public int id;
	 public double lat;
	public double lon;

	 public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	
/*	Vehicle[] initialize(double lat , double lon){
		Vehicle[] v= new Vehicle[20];
		
		for(int i=0; i<20 ; i++){
			v[i]= new Vehicle();
			v[i].registration= "PIK0";                         
			v[i].id= i;
			v[i].lat= (Math.random() * 56 + i + lat) / 75;
			v[i].lon= (Math.random() * 34 + i + lon) / 75;
			
}
		return v;
	}*/
}

















/*public class Vehicle {
	String vehicleRegNum;
	String vehicleMake;
	String vehicleModel;
	String driverName;
	String driverphoneNum;
	public Vehicle(String vehicleRegNum, String vehicleMake, String vehicleModel, String driverName,
			String driverphoneNum) {
		super();
		this.vehicleRegNum = vehicleRegNum;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		this.driverName = driverName;
		this.driverphoneNum = driverphoneNum;
	}
	public String getVehicleRegNum() {
		return vehicleRegNum;
	}
	public void setVehicleRegNum(String vehicleRegNum) {
		this.vehicleRegNum = vehicleRegNum;
	}
	public String getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverphoneNum() {
		return driverphoneNum;
	}
	public void setDriverphoneNum(String driverphoneNum) {
		this.driverphoneNum = driverphoneNum;
	}
	
	
	
	

}*/
