package Reports;

public class RiderReport extends ReportsRequest {

		public RiderReport(String reportDescription) {
			this();
			reportsType = "Rider Report";
			this.reportDescription = reportDescription;
		}

		public RiderReport() {
			reportsType = "Rider Report";
		}

		@Override
		public void showReport() {
			super.showReport();
		}
	}


