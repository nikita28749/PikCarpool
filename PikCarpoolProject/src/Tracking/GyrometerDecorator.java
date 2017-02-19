package Tracking;


	public class GyrometerDecorator extends TrackingDecorator {

		

		public GyrometerDecorator(TrackingInterface track) {
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
			tracking.setMonitoringByGyrometers(true);
			
		}

		@Override
		public boolean isCarSurveylanceOn() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setCarSurveylanceFlag(boolean carSurveylanceOn) {
			
			
		}

		
	}

		

