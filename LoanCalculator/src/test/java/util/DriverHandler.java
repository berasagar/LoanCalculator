package util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverHandler {

	public WebDriver initializeWebDriver() throws IOException
	{
		WebDriver objWebDriver = null;
		try {	
			ConfigFileReader configParams = new ConfigFileReader();
			if((configParams.commonParams.get("webBrowser")).toString().equalsIgnoreCase("chrome"))
			{
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setCapability("noReset", configParams.commonParams.get("noReset"));
				//WebDriverManager.chromedriver().version("101.0.4951.15").setup();
				WebDriverManager.chromedriver().setup();
				objWebDriver = new ChromeDriver(chromeOptions);
			}
			else if(configParams.commonParams.get("webBrowser").equalsIgnoreCase("firefox"))
			{
				//objWebDriver = new FirefoxDriver();
				//.navigate().to(configParams.commonParams.get("webBrowser"));
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setCapability("noReset", configParams.commonParams.get("noReset"));
				WebDriverManager.firefoxdriver().setup();
				objWebDriver = new FirefoxDriver(firefoxOptions);
			}
			objWebDriver.manage().timeouts().implicitlyWait(new Integer(configParams.commonParams.get("implicitWait")), TimeUnit.SECONDS);
			//objWebDriver.manage().window().maximize();
			//objWebDriver.wait(3);
			objWebDriver.navigate().to(configParams.commonParams.get("AppUrl"));
			}
		catch(Exception e)
		{
			System.out.println("Error occured while setting up browser and navigating URL");
			e.printStackTrace();
		}
		return objWebDriver;
	}
}
