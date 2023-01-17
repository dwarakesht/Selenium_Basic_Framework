package commonMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {
	Workbook wb;
	Sheet sheet;

	String filePath;
	public ExcelOperations() {
		
		try {
			filePath = System.getProperty("user.dir") + "/" + PropertiesOperations.getPropertyValue("testDataPath");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		FileInputStream file = null;
		try {
			file = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			sheet = wb.getSheet(PropertiesOperations.getPropertyValue("sheetName"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public HashMap<String, String> getDataInMap(int rowCount) throws EncryptedDocumentException, IOException {
		HashMap<String, String> hs = new HashMap<String, String>();
		int colCount = getColCount();
		for(int i = 0; i < colCount; i ++) {
			hs.put(sheet.getRow(0).getCell(i).getStringCellValue(), sheet.getRow(rowCount).getCell(i).getStringCellValue());
		}
		return hs;
	}

	public int getColCount() {
		return sheet.getRow(0).getLastCellNum();
	}

	public int getRowCount() {
		return sheet.getLastRowNum();
	}
}
