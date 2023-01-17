package commonMethods;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;


public class ElementOperations extends TestBase{

	//Static Dropdown method
	public void selectDropdownValue(WebElement element, String value) {
		reuseableMethods.waitForElementToBeVisible(element);
		Select ddSelect =  new Select(element);
		ddSelect.selectByVisibleText(value);
	}

	public void sendValuesToTextbox(WebElement element, String value){
		reuseableMethods.waitForElementToBeVisible(element);
		element.sendKeys(value);
	}

	public void clickElement(WebElement element) {
		reuseableMethods.waitForElementToBeClickable(element);
		element.click();
	}

	public void selectUsersRadioButton(List<WebElement> rdn_elements, String valueString) throws Exception {
		boolean flag = false;
		for (WebElement rdn_element : rdn_elements) {
			if (rdn_element.getAttribute("innerText").equalsIgnoreCase(valueString)) {
				reuseableMethods.waitForElementToBeClickable(rdn_element);
				rdn_element.click();
				flag = true;
				break;
			}
		}
		if(flag == false) {
			throw new Exception("ERR !! The user's selection of radio button is not present in the list of radio button, please check.");
		}
	}
}
