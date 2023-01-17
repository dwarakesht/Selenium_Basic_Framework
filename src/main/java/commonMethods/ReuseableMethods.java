package commonMethods;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import testBase.TestBase;

public class ReuseableMethods extends TestBase{

	//Verify and assert title of current page
	public void assertPageTitle(String expectedTitle) {
		Assert.assertEquals(driver.getTitle(), expectedTitle, "ERR !! The page title does not match.");
//		extentTest.lo
	}

	//Get Date Time Stamp in format specified as parameter
	public String getDateTimeStamp(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date());
	}
	
	//Wait for the element to be clickable
	public void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//Wait for the element to be clickable
		public void waitForElementToBeVisible(WebElement element) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
}
