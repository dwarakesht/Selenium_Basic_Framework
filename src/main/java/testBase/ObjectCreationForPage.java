package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import commonMethods.ElementOperations;
import commonMethods.ExcelOperations;
import commonMethods.ExtentReporting;
import commonMethods.ReuseableMethods;
import pageObjects.EnterInsuranceDataPage;
import pageObjects.EnterProductDataPage;
import pageObjects.EnterVehicleDataPage;
import pageObjects.HomePage;

public class ObjectCreationForPage{
	//	WebDriver Initialization
	public static WebDriver driver;
	//	Object creation for page Objects
	public static HomePage homePage ;
	public static EnterInsuranceDataPage insuranceDataPage;
	public static EnterVehicleDataPage vehicleDataPage;
	public static EnterProductDataPage productDataPage;
	public static ElementOperations elementOperations;
	public static ReuseableMethods reuseableMethods = new ReuseableMethods();
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static ExtentReporting extentReporting =new ExtentReporting();
	public static WebDriverWait wait;
	public static ExcelOperations excelOperations =  new ExcelOperations();
}
