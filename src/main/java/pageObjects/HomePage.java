package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePage extends TestBase{

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Locators
	@FindBy(linkText = "Automobile")
	WebElement link_automobile;

	@FindBy(linkText = "Truck")
	WebElement link_truck;

	@FindBy(linkText = "Motorcycle")
	WebElement link_motorcycle;

	@FindBy(linkText = "Camper")
	WebElement link_camper;

	//Methods	

	public void validateHomePageTitle(String pageTitle) {
		reuseableMethods.assertPageTitle(pageTitle);
	}
	public void clickAutomobileLink() {
		link_automobile.click();
		//		extentTest.log(Status.PASS, "Clicked on Automobile Link");
	}

	public void navigateToTruckPage() {
		link_truck.click();
	}

	public void navigateToMotorcyclePage() {
		link_motorcycle.click();
	}

	public void navigateToCamperPage() {
		link_camper.click();
	}
	
	public void clickOnvehicleTypeLink(String vehicleType) throws Exception {
		if(vehicleType.equalsIgnoreCase("Automobile")) {
			link_automobile.click();
		}
		else if(vehicleType.equalsIgnoreCase("Truck")) {
			link_truck.click();
		}
		else if(vehicleType.equalsIgnoreCase("Motorcycle")) {
			link_motorcycle.click();
		}
		else if(vehicleType.equalsIgnoreCase("Camper")) {
			link_camper.click();
		}
		else {
			throw new Exception("ERR !! The " + vehicleType + " is not expected.");
		}
	}
}
