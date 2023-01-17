package commonMethods;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesOperations {

	static Properties properties = new Properties();

	//Get property value using key
	public static String getPropertyValue(String key) throws Exception {
		String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
		FileInputStream fis = new FileInputStream(propFilePath);
		properties.load(fis);
		if(org.apache.commons.lang3.StringUtils.isEmpty(properties.get(key).toString())) {
			throw new Exception("The value is null or empty for the key '" + key + "'");
		}
		return properties.get(key).toString();
	}
}
