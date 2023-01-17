package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterVehicleDataPage extends TestBase {
	WebDriver driver;
	//Constructor to initialize the initElements
	public EnterVehicleDataPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Locators
	@FindBy(id = "make") WebElement dd_makeElement;
	@FindBy(id = "engineperformance") WebElement txt_enginePerformance;
	@FindBy(id = "dateofmanufacture") WebElement cal_dateOfManufacture;
	@FindBy(id = "numberofseats") WebElement dd_numberOfSeats;
	@FindBy(id = "fuel") WebElement dd_fuelType;
	@FindBy(id = "listprice") WebElement txt_listPrice;
	@FindBy(id = "licenseplatenumber") WebElement txt_licensePlateNumber;
	@FindBy(id = "annualmileage") WebElement txt_annualMileage;
	@FindBy(id = "nextenterinsurantdata") WebElement btn_Next;

	//methods
	public void validateVehicleDataPageTitle(String pageTitle) {
		reuseableMethods.assertPageTitle(pageTitle);
	}
	public void selectMakeDropDown(String dd_value) {
		elementOperations.selectDropdownValue(dd_makeElement, dd_value);

	}

	public void enterEnginePerformance(String txt_value) {
		elementOperations.sendValuesToTextbox(txt_enginePerformance, txt_value);
	}

	public void enterDateOfManufacture(String txt_value) {
		elementOperations.sendValuesToTextbox(cal_dateOfManufacture, txt_value);
	}

	public void selectNoOfSeatsDropDown(String dd_value) {
		elementOperations.selectDropdownValue(dd_numberOfSeats, dd_value);	
	}

	public void selectFuelTypeDropDown(String dd_value) {
		elementOperations.selectDropdownValue(dd_fuelType, dd_value);	
	}

	public void enterListPrice(String txt_value) {
		elementOperations.sendValuesToTextbox(txt_listPrice, txt_value);
	}

	public void enterLicensePlateNumber(String txt_value) {
		elementOperations.sendValuesToTextbox(txt_licensePlateNumber, txt_value);
	}

	public void enterAnnualMileage(String txt_value) {
		elementOperations.sendValuesToTextbox(txt_annualMileage, txt_value);
	}

	public void clickNextButton() {
		elementOperations.clickElement(btn_Next);
	}
	
	public void enterAllVechileData(HashMap<String, String> data) {
		vehicleDataPage.selectMakeDropDown(data.get("MAKE"));
		vehicleDataPage.enterEnginePerformance(data.get("ENGINE_PERFORMANCE"));
		vehicleDataPage.enterDateOfManufacture(data.get("DATE_OF_MANUFACTURE"));
		vehicleDataPage.selectNoOfSeatsDropDown(data.get("NO_OF_SEATS"));
		vehicleDataPage.selectFuelTypeDropDown(data.get("FUEL_TYPE"));
		vehicleDataPage.enterListPrice(data.get("LIST_PRICE"));
		vehicleDataPage.enterLicensePlateNumber(data.get("LICENSE_PLATE_NUMBER"));
		vehicleDataPage.enterAnnualMileage(data.get("ANNUAL_MILEAGE"));
	}
}
