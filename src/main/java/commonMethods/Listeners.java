package commonMethods;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import testBase.TestBase;

public class Listeners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "The test case " + result.getMethod().getMethodName() + " Passed !!");

	}

	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "The test case " + result.getMethod().getMethodName() + " Failed !!");
		extentTest.log(Status.FAIL, result.getThrowable());
		//Add Screenshot for FAILED test case.
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destFilePath = System.getProperty("user.dir") + "/target/RunReports/Screenshots/"+ reuseableMethods.getDateTimeStamp("dd-MM-yyy_hhmmss") + ".jpeg";
		File destFile = new File(destFilePath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.addScreenCaptureFromPath(destFilePath);
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		extentReports = extentReporting.setUpReports();
	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
}
