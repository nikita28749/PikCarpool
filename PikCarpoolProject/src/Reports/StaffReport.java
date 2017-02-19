package Reports;

public class StaffReport extends ReportsRequest {

		public StaffReport(String reportDescription) {
			this();
			reportsType = "Staff Report";
			this.reportDescription = reportDescription;
		}

		public StaffReport() {
			reportsType = "Staff Report";
		}

		@Override
		public void showReport() {
			super.showReport();
		}
	}


