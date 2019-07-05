package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PropertyFileHandler {

	public String strPropertyFilePath= System.getProperty("user.dir") + "\\Resources\\prop.properties";
	public java.util.Properties prop=null;

	/*
	 * This is a constructor which loads the property file object with file input stream
	 * @return 
	 * @param 
	 * @throws 
	 */

	public PropertyFileHandler() {
		FileInputStream fileInput = null;
		try {
			System.out.println(strPropertyFilePath);
			fileInput = new FileInputStream(new File (strPropertyFilePath));
		} catch (FileNotFoundException e) {
			System.out.println( "File not found. Please check the file path");
			e.getStackTrace();
		}

		// create properties object and load the file input
		prop = new java.util.Properties();
		try {
			prop.load(fileInput);
			System.out.println(prop);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This is a constructor which loads the property file object with file input stream
	 * @return  string
	 * @param   key
	 * @throws 
	 */

	public String readProperties(String key){
		return prop.getProperty(key);
	}

}

