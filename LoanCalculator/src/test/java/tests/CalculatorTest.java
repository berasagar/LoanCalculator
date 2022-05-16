package tests;
import page.CalculatorPage;
import util.DriverHandler;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTest extends CalculatorPage {

	WebDriver objWebDriver = null;
	String calculatedAmount="";
	@BeforeTest()
	public void openCalculator() throws IOException
	{
		DriverHandler driver = new DriverHandler();
		objWebDriver = driver.initializeWebDriver();
	}
	CalculatorPage calculatorPage = new CalculatorPage();
	
	@Test()
	public void test_fillDataToCalculateBorrowAmount()
	{
		calculatorPage.EnterValuesToCalculate(objWebDriver);
		calculatedAmount = calculatorPage.calculateBorrowAmount(objWebDriver);
		Assert.assertEquals(calculatedAmount,"$528,000");
	}
	
	@Test()
	public void test_startOver()
	{
		Assert.assertEquals(calculatorPage.resetValuesToDefault(objWebDriver),"$0");
	}
	
	@Test(dependsOnMethods = {"test_fillDataToCalculateBorrowAmount","test_startOver"})
	public void test_calculateOnlyWithLivingExpense()
	{
		Assert.assertEquals(calculatorPage.calculateOnlyWithLivingExpenseData(objWebDriver),borrowErrorMessage);
	}
}
