package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ConfigFileReader {
	
	//public Properties properties;
	//anzbank\src\test\java\properties
	private final String propertyFilePath= "src/test/java/properties/common.properties";
	public HashMap<String,String> commonParams = new HashMap<String,String>();
	
	public ConfigFileReader() throws IOException{
		Properties properties = new Properties();
		//BufferedReader reader;
		System.out.println(System.getProperty("user.dir"));
		try {
			if (new File(propertyFilePath).exists())
			{
				properties.load(new FileInputStream(propertyFilePath));
				for(Object propertyName : properties.keySet())
				{
					commonParams.put(propertyName.toString(), properties.get(propertyName).toString());
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	/*public String getBrowser()
	{
		String browser = properties.getProperty("webBrowser");
		if(browser!= null) return browser;
		else throw new RuntimeException("Web browser not found.");
	}
	
	public String getAppURL(){
		String appurl = properties.getProperty("AppUrl");
		if(appurl!= null) return appurl;
		else throw new RuntimeException("AppURL not found.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}*/

}
