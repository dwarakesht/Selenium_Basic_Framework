package commonMethods;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import testBase.TestBase;

public class ExtentReporting extends TestBase{

	public  ExtentReports setUpReports() {
		String filePath = System.getProperty("user.dir") + "/target/RunReports/report_"+reuseableMethods.getDateTimeStamp("dd-MM-yyy_hhmmss")+".html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filePath);
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		//Set Configurations
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Insurance Calulator Run Report");
		sparkReporter.config().setDocumentTitle("Document Title");
		return extentReports;
	}
}
