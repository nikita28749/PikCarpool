package Reports;

public abstract class ReportsRequest {
	

		public String reportsType;
		public String reportDescription;

		public void showReport() {
			System.out.println(reportsType + ": " + this.reportDescription);
		}
	

	

}
