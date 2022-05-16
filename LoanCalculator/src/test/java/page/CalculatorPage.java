package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.CommonMethods;

public class CalculatorPage {	
	
	public static String appTypeSingle ="//label[@for='application_type_single']['Single']";
	public static String appTypeJoint ="//label[@for='application_type_joint']['Joint']";
	public static String numOfDependents ="//select[@title='Number of dependants']";
	//public static String numOfDependents ="//div[@class='borrow__question__answer borrow__question__answer--select']";
	public static String homeToLiveIn ="//label[@for='borrow_type_home']['Home to live in']";
	////input[@id='borrow_type_investment']
	public static String resInvestment ="//input[@id='borrow_type_investment']";
	public static String annumalIncomeBeforeText ="//span[@id='q2q1i1']/following-sibling::input";
	public static String othetAnnualIncome = "//span[@id='q2q2i1']/following-sibling::input";
	public static String monthlyLivingExpenses = "//span[@id='q3q1i1']/following-sibling::input";
	public static String currentHomeLoanRepayment ="//span[@id='q3q2i1']/following-sibling::input";
	public static String otherLoanMonthlyPayments = "//span[@id='q3q3i1']/following-sibling::input";
	public static String otherMonthlyCommitments = "//span[@id='q3q4i1']/following-sibling::input";
	public static String totalCreditCardLimit = "//span[@id='q3q5i1']/following-sibling::input";
	public static String calculateBorrowAmount = "btnBorrowCalculater";
	public static String estimatedBorrowAmount ="borrowResultTextAmount";
	public static String startOver ="//div[@class='result__restart']/button";
	public static String borrowErrorText = "//div[@class='borrow__error__text']";
	public static String borrowErrorMessage ="Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.";
	
	//String calculatedAmount = "";
	String errorMessage = "";
	
	CommonMethods commonMethods = new CommonMethods();
	
	public void EnterValuesToCalculate(WebDriver objWebDriver)
	{
		try {
			commonMethods.clickButton(objWebDriver, appTypeSingle);
			commonMethods.selectValueFromDropdown(objWebDriver, numOfDependents,"0");
			commonMethods.clickButton(objWebDriver, homeToLiveIn);
			commonMethods.enterElementTextByXpath(objWebDriver, annumalIncomeBeforeText, "80000");
			commonMethods.enterElementTextByXpath(objWebDriver, othetAnnualIncome, "10000");
			commonMethods.enterElementTextByXpath(objWebDriver, monthlyLivingExpenses, "500");
			commonMethods.enterElementTextByXpath(objWebDriver, currentHomeLoanRepayment, "0");
			commonMethods.enterElementTextByXpath(objWebDriver, otherLoanMonthlyPayments, "100");
			commonMethods.enterElementTextByXpath(objWebDriver, otherMonthlyCommitments, "0");
			commonMethods.enterElementTextByXpath(objWebDriver, totalCreditCardLimit, "10000");	
		}
		catch(Exception e)
		{
			System.out.print("Error occured while accessing elements" + e.toString());
		}
	}
	
	public String calculateBorrowAmount(WebDriver objWebDriver) {
		String calculatedAmount = "";
		try
		{
			commonMethods.clickButtonByID(objWebDriver, calculateBorrowAmount);
			calculatedAmount = commonMethods.getTextByIDWithText(objWebDriver, estimatedBorrowAmount,"$528,000");
			//objWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Calculated amount :- "+calculatedAmount);
		}
		catch(Exception e)
		{
			System.out.print("Error occured while calculating borrow amount" + e.toString());
		}
		return calculatedAmount;
	}
	
	public String resetValuesToDefault(WebDriver objWebDriver)
	{
		String calculatedAmount = "";
		try {
			commonMethods.clickButton(objWebDriver, startOver);
			calculatedAmount = commonMethods.getTextByIDWithText(objWebDriver, estimatedBorrowAmount,"$0");
		}
		catch(Exception e)
		{
			System.out.print("Error occured while reseting values" + e.toString());
		}
		return calculatedAmount;
	} 
	
	public String calculateOnlyWithLivingExpenseData(WebDriver objWebDriver)
	{
		try
		{
			commonMethods.enterElementTextByXpath(objWebDriver, monthlyLivingExpenses, "500");
			commonMethods.clickButtonByID(objWebDriver, calculateBorrowAmount);
			errorMessage = commonMethods.getTextByXpath(objWebDriver, borrowErrorText);
		}
		catch(Exception e)
		{
			System.out.print("Error occured while checking error message" + e.toString());
		}
		return errorMessage;
	}

}
