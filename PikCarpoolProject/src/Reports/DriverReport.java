package Reports;

public class DriverReport extends ReportsRequest {

		public DriverReport(String reportDescription) {
			this();
			reportsType = "Driver Report";
			this.reportDescription = reportDescription;
		}

		public DriverReport() {
			reportsType = "Driver Report";
		}

		@Override
		public void showReport() {
			super.showReport();
		}

	}


