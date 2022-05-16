package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.CalculatorPage;

public class CommonMethods{

	//String elementText="";
	public void selectValueFromDropdown(WebDriver objWebDriver,String element,String dropdownValue)
	{
		WebDriverWait wait = new WebDriverWait(objWebDriver, 30);
		Select drpValues = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))));
		drpValues.selectByIndex(0);
	}
	
	public void enterElementTextByXpath(WebDriver objWebDriver,String element,String elementText)
	{
		objWebDriver.findElement(By.xpath(element)).sendKeys(elementText);
	}
	
	public void clickButton(WebDriver objWebDriver,String element)
	{
		objWebDriver.findElement(By.xpath(element)).click();
	}
	
	public void clickButtonByID(WebDriver objWebDriver,String element)
	{
		objWebDriver.findElement(By.id(element)).click();
	}
	
	public String getTextByIDWithText(WebDriver objWebDriver,String element,String text)
	{
		String elementText="";
		try
		{
			WebDriverWait wait = new WebDriverWait(objWebDriver, 30);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(element), text));
			elementText = objWebDriver.findElement(By.id(element)).getText();
		}
		catch(Exception e)
		{
			System.out.println("Error while getting element text by ID"+element +" "+e.toString());
		}
		return elementText;
	}
	
	public String getTextByXpath(WebDriver objWebDriver,String element)
	{
		String elementTextByXpath="";
		try
		{
			WebDriverWait wait = new WebDriverWait(objWebDriver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
			elementTextByXpath = objWebDriver.findElement(By.xpath(element)).getText();
			System.out.println("Borrow error message :- "+elementTextByXpath);
		}
		catch(Exception e)
		{
			System.out.println("Error while getting element text by Xpath"+element +" "+e.toString());
		}
		return elementTextByXpath;
	}
	
	public Boolean checkIfItemSelected(WebDriver objWebDriver,String element)
	{
		Boolean selected = objWebDriver.findElement(By.xpath(element)).getAttribute("checked").equalsIgnoreCase("checked");
		return selected;
	}
}
