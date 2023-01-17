package e2eTests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.TestBase;

public class SuccessScenario extends TestBase{

	@Test(dataProvider = "InsuranceData")
	public void volvoAutomobile(Object dataObject) throws Exception {
		@SuppressWarnings("unchecked")
		HashMap<String, String> data = (HashMap<String, String>) dataObject;
		//		System.out.println(data);
		homePage.validateHomePageTitle(data.get("HOMEPAGE_TITLE"));
		homePage.clickOnvehicleTypeLink(data.get("VEHICLE_TYPE"));
		vehicleDataPage.validateVehicleDataPageTitle(data.get("VEHICLE_DATA_PAGE_TITLE"));
		vehicleDataPage.enterAllVechileData(data);
		vehicleDataPage.clickNextButton();
		insuranceDataPage.validateInsuranceDataPageTitle("Enter Insurant Data");
		insuranceDataPage.enterAllInsuranceData();
	}

	@DataProvider (name = "InsuranceData")
	public Object[][] testData() throws EncryptedDocumentException, IOException {
		Object [] [] obj = new Object [excelOperations.getRowCount()][1];
		for(int i = 1; i<= excelOperations.getRowCount(); i++) {
			HashMap<String, String> testData =  excelOperations.getDataInMap(i);
			obj[i-1][0] = testData;
		}
		return obj;
	}
}
