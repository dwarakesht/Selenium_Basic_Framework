package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import commonMethods.ElementOperations;
import commonMethods.PropertiesOperations;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsuranceDataPage;
import pageObjects.EnterProductDataPage;
import pageObjects.EnterVehicleDataPage;
import pageObjects.HomePage;

public class TestBase extends ObjectCreationForPage{
	//Methods
	public WebDriver browserSetup() throws Exception {
		selectBrowserType(PropertiesOperations.getPropertyValue("browser"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public void launchURL() throws Exception {
		driver.get(PropertiesOperations.getPropertyValue("url"));
	}

	public void selectBrowserType(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
	}

	@BeforeMethod
	public void setUp() throws Exception {
		WebDriver driver = browserSetup();
		launchURL();
		homePage = new HomePage(driver);
		insuranceDataPage = new EnterInsuranceDataPage(driver);
		vehicleDataPage = new EnterVehicleDataPage(driver);
		productDataPage = new EnterProductDataPage(driver);
		elementOperations = new ElementOperations();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
