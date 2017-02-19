package Tracking;

public class CarSurveylance extends TrackingDecorator{

	public CarSurveylance(TrackingInterface track) {
		super(track);
		
	}

	@Override
	public String vehicleTracking() {
		// TODO Auto-generated method stub
		return "vehicle tracking";
	}

	@Override
	public boolean isMonitoringByGyrometers() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMonitoringByGyrometers(boolean monitoringByGyrometers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCarSurveylanceOn() {
		
		return false;
	}

	@Override
	public void setCarSurveylanceFlag(boolean carSurveylanceOn) {
		tracking.setCarSurveylanceFlag(true);
		System.out.println("Car Surveylance on in this vehicle");
		
	}

}
