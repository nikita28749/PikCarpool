package Reports;


	import java.util.Vector;



	public abstract class PaymentReport extends ReportsRequest {



	protected Vector<ReportsRequest> directReports = new Vector<ReportsRequest>();



	public void showReport() {

	super.showReport();

	if (directReports.size() > 0) {

	for (ReportsRequest report : directReports) {

	report.showReport();

	}

	}

	}

}
