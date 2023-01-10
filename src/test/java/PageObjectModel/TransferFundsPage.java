package PageObjectModel;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage extends BaseClass{
	
	public TransferFundsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@id='fromAccount']")
	public WebElement from_Account;
	
	public static void selectFromAccount(WebDriver driver, String FromAccount)
	{
		WebElement fromAccount_WebList = driver.findElement(By.id("fromAccount"));
		Select s = new Select(fromAccount_WebList);
		s.selectByVisibleText(FromAccount);
	}
	
	@FindBy(xpath
			 = "//select[@id='toAccount']")
	public WebElement to_Account;
	
	public static void selectToAccount(WebDriver driver, String ToAccount)
	{
		WebElement toAccount_WebList = driver.findElement(By.id("toAccount"));
		Select s = new Select(toAccount_WebList);
		s.selectByVisibleText(ToAccount);
	}
	
	@FindBy(xpath = "//input[@id='transferAmount']")
	public WebElement amountToEnterField;
	
	public static void enterAmounttoEnter(WebDriver driver, String Amount)
	{
		WebElement AmountToEnter_WebEdit = driver.findElement(By.id("transferAmount"));
		AmountToEnter_WebEdit.sendKeys(Amount);
	}
	
	@FindBy(xpath = "//input[@id='transfer']")
	public WebElement transferMoneyBtn;
	
	public static void clickTranferMoney(WebDriver driver)
	{
		WebElement TransferMoney_WebBtn = driver.findElement(By.id("transfer"));
		TransferMoney_WebBtn.click();
	}
	
	@FindBy(xpath = "//*[@id='_ctl0__ctl0_Content_Main_postResp']/span")
	public WebElement transferFundMessage;
	
	public static String getTransferFundMessage(WebDriver driver)
	{
		WebElement TransferMoneyMessage = driver.findElement(By.xpath("//*[@id=\'_ctl0__ctl0_Content_Main_postResp\']/span"));
		return TransferMoneyMessage.getText();
	}
	
	@FindBy(xpath = "//*[contains(text(),'View Recent Transactions')]")
	public WebElement viewRecentTransactionsBtn;

	public static void clickViewRecentTransactions(WebDriver driver)
	{
		WebElement viewRecentTransactions_WebLink = driver.findElement(By.xpath("//*[contains(text(),'View Recent Transactions')]"));
		viewRecentTransactions_WebLink.click();
	}
}
