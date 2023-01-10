
package org.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.AccountHistoryPage;
import PageObjectModel.AccountPage;
import PageObjectModel.LoginPage;
import PageObjectModel.RecentTransactionPage;
import PageObjectModel.TransferFundsPage;

public class ExecutionClass extends BaseClass {

	// public WebDriver driver = null;
	Properties prop = readPropertiesFile(
			System.getProperty("user.dir")+"\\target\\Config.properties");

	public static Properties readPropertiesFile(String fileName) {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return prop;
	}

	AccountHistoryPage accountHistoryPage;
	AccountPage accountPage;
	LoginPage loginPage;
	RecentTransactionPage recentTransactionPage;
	TransferFundsPage transferFundsPage;

	
	@BeforeMethod
	public void launchURL() {
		
			browserLaunchChrome();
		
		urlLaunch(prop.getProperty("URL"));
		maxBrowser();
//		
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.dir")+"\\target\\Config.properties");
//		System.setProperty("webdriver.chrome.driver", "F:\\Project\\AltoroMutual\\SupportingFiles\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get(prop.getProperty("URL"));
//		driver.manage().window().maximize();

		accountHistoryPage = new AccountHistoryPage();
		accountPage = new AccountPage();
		loginPage = new LoginPage();
		recentTransactionPage = new RecentTransactionPage();
		transferFundsPage = new TransferFundsPage();

	}

	@Test(invocationCount = 1)
	public void testcaseflow() throws InterruptedException {

		// Clicking on Online Banking Login link

		clickButton(loginPage.loginButton);
		// Entering Username

		fillText(loginPage.usernameField, prop.getProperty("Invalid_Username"));
		// Entering Password

		fillText(loginPage.passwordField, prop.getProperty("Invalid_Password"));
		// Click Login

		clickButton(loginPage.submitBtn);

		// Validating the Error message for invalid credentials
		String ExpectedErrorDetails = "Login Failed: We're sorry, but this username or password was not found in our system. Please try again.";

		String ActualErrorDetails = getTextValue(loginPage.loginErrorMessage);
		
		SoftAssert s = new SoftAssert();
		s.assertEquals(ActualErrorDetails, ExpectedErrorDetails,
				"Error message displayed for invalid credentials is correct");

		// Retrying with Correct Credentials
		// Entering Username

		fillText(loginPage.usernameField, prop.getProperty("Username"));

		// Entering Password

		fillText(loginPage.passwordField, prop.getProperty("Password"));
		// Click Login

		clickButton(loginPage.submitBtn);

		// Getting the WelcomeMessage for the logged user

		String ActualWelcomeMessage = getTextValue(accountPage.accountUserLabelWelcomeMessage);
		String ExpectedWelcomeMessage = "Hello Admin User";
		s.assertEquals(ActualWelcomeMessage, ExpectedWelcomeMessage, "Validating the welcome Message");

		// Clicking View Account Summary

		clickButton(accountPage.accountSummary);

		selectByText(accountPage.selectAccount, "800001 Checking");

		clickButton(accountPage.goButton);

		Assert.assertTrue(true, getTextValue(accountHistoryPage.accountBalance));

		// Click on Transfer Funds

		clickButton(accountHistoryPage.transferFundButton);

		// Select From and To Account

		selectByText(transferFundsPage.from_Account, "800000 Corporate");

		selectByText(transferFundsPage.to_Account, "800001 Checking");

		fillText(transferFundsPage.amountToEnterField, "9876");

		clickButton(transferFundsPage.transferMoneyBtn);

		// Getting the transfer fund message
		String ExpectedTransferMessage = "9876.0 was successfully transferred from Account 800000 into Account 800001";

		String ActualTransferMessage = getTextValue(transferFundsPage.transferFundMessage);

		// Validating the Fund Transfer message
		String arr[] = new String[2];
		arr = ActualTransferMessage.split("at");
		s.assertEquals(arr[0].trim(), ExpectedTransferMessage.trim());
		// Clicking on View Recent Transactions

		clickButton(transferFundsPage.viewRecentTransactionsBtn);

		recentTransactionPage.validateTransactions(recentTransactionPage.firstAccountID,
				recentTransactionPage.secondAccountID, recentTransactionPage.firstAction,
				recentTransactionPage.secondAction, recentTransactionPage.firstAmount,
				recentTransactionPage.secondAmount);
		// Submitting the feedback form

		clickButton(accountPage.contactUsBtn);

		clickButton(accountPage.onlineForm);

		fillText(accountPage.emailAddress_WebEdit, "test@gmail.com");
		fillText(accountPage.subject_WebEdit, "Test Subject");
		fillText(accountPage.questions_WebEdit, "Test Questions/Comments");
		clickButton(accountPage.submitBtnFinal);

		String ActualThankYouMessage = getTextValue(accountPage.thankYouMessage);
		String ExpectedThankYouMessage = "Thank You";
		s.assertEquals(ActualThankYouMessage, ExpectedThankYouMessage);

		clickButton(accountPage.signOff);
		s.assertAll();
		closeBrowser();

	}

}
