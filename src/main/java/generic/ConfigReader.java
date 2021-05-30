package generic;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class ConfigReader {
	private Properties properties;
	private BufferedReader reader;
	private final String propertyFileName = "TestConfig.properties";
	/*
	 * get data from Test Configuration property file 
	 */
	public String getvalue(String keyName) {
		String keyVal=null;
		try {
			reader = new BufferedReader(new FileReader(propertyFileName));
			properties =new Properties();
			try {
				properties.load(reader);
				keyVal = properties.getProperty(keyName);
			} catch(IOException e) {
				e.printStackTrace();
			}
		} catch(FileNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException("TestConfig file not found");
		}
		
		
		return keyVal;
	}

}
