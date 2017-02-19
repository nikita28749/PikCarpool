package Reports;

public class PerformanceReport extends StaffReport {

		public PerformanceReport(String reportDescription) {
			this();
			reportsType = "Performance Report";
			this.reportDescription = reportDescription;
		}

		public PerformanceReport() {
			super();
			reportsType = "Performance Report";
		}

		@Override
		public void showReport() {
			System.out.println("Performance Reports: ");
			super.showReport();
		}
	}


