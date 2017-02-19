package Reports;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SalesReport extends PaymentReport {
	
	String csvFile = "C:/Users/sista/Desktop/Assignment/workface/PikCarpoolProject/SalesReport.csv";
    String line = "";
    String cvsSplitBy = ",";

		public SalesReport(String reportDescription) {
			this();
			reportsType = "Sales Report ";
			this.reportDescription = reportDescription;
		}

		public SalesReport() {
			super();
			reportsType = "Sales Report";
		}

		@Override
		public void showReport() {
			System.out.println("#.Sales Reports: ");
			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] country = line.split(cvsSplitBy);

	                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

			super.showReport();
		}

		public void addReport(DriverReport driver) {
			this.directReports.addElement(driver);
			
			
		}
		public void addReport(StaffReport staff) {
			this.directReports.addElement(staff);
			
			
		}
	}


