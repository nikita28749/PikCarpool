package Reports;

public class GenerateReport extends ReportsRequest {
	

		public void setup() {

			DriverReport driver1 = new DriverReport("Driver 1 Reports");
			DriverReport driver2 = new DriverReport("Driver 2 Reports");
			//driver1.showReport();

			StaffReport staff1 = new StaffReport("Staff 1 reports");
			StaffReport staff2 = new StaffReport("Staff 2 reports");

			SalesReport sales = new SalesReport("Sales");
			
			
			 sales.addReport(driver1);
			sales.addReport(staff1);
			sales.addReport(driver2);
			sales.addReport(staff2);

			PerformanceReport performance = new PerformanceReport("Performance");
			
			SalesReport companysalesreport=new SalesReport("Sales report of Pik CarpoolCompany");
			

			
			companysalesreport.showReport();

		}
		
		public void generateReports() {
			GenerateReport setup = new GenerateReport();
			setup.setup();
			
		}

	}


