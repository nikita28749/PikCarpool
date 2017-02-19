package Tracking;


	public abstract class TrackingDecorator implements TrackingInterface {

		protected TrackingInterface tracking;
		
		public TrackingDecorator(TrackingInterface track){
			this.tracking = track;
		}
		
		


	}


