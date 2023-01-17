package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterInsuranceDataPage extends TestBase {

	WebDriver driver;

	public EnterInsuranceDataPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Locators
	@FindBy(id = "firstname") WebElement txt_firstName;
	@FindBy(id = "lastname") WebElement txt_lastName;
	@FindBy(id = "birthdate") WebElement cal_birthDate;
	@FindBy(xpath = "//input[@name='Gender' and @type='radio']/parent::label") List<WebElement> rad_gender;
	@FindBy(id = "streetaddress") WebElement txt_streetAddress;
	@FindBy(id = "country") WebElement dd_country;
	@FindBy(id = "zipcode") WebElement txt_zipcode;
	@FindBy(id = "city") WebElement txt_city;
	@FindBy(id = "occupation") WebElement dd_occupation;
	@FindBy(xpath = "//input[@name='Hobbies' and @type='checkbox']") List<WebElement> chk_hobbies;
	@FindBy(id = "website") WebElement txt_website;
	@FindBy(id = "picture") WebElement upload_picture;
	@FindBy(id = "preventervehicledata") WebElement btn_Prev;
	@FindBy(id = "nextenterproductdata") WebElement btn_Next;

	public void enterFirstName(String txt_value) {
		elementOperations.sendValuesToTextbox(txt_firstName, txt_value);
	}

	public void enterLastName(String txt_value) {
		elementOperations.sendValuesToTextbox(txt_lastName, txt_value);
	}

	public void enterBirthDate(String txt_value) {
		elementOperations.sendValuesToTextbox(cal_birthDate, txt_value);
	}

	public void selectGenderRadioButton(String value_to_select) throws Exception {
		elementOperations.selectUsersRadioButton(rad_gender, value_to_select);
	}

	public void validateInsuranceDataPageTitle(String pageTitle) {
		reuseableMethods.assertPageTitle(pageTitle);
	}
	
	public void clickNextButton() {
		elementOperations.clickElement(btn_Next);
	}

	public void enterAllInsuranceData() throws Exception {
		insuranceDataPage.validateInsuranceDataPageTitle("Enter Insurant Data");
		insuranceDataPage.enterFirstName("Dwarakesh");
		insuranceDataPage.enterLastName("Thanigaivelan");
		insuranceDataPage.enterBirthDate("11/12/1994");
		insuranceDataPage.selectGenderRadioButton("Male");
	}
}
