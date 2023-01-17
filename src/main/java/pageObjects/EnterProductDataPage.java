package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterProductDataPage extends TestBase{
	WebDriver driver;
	//Constructor to initialize the initElements
	public EnterProductDataPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
