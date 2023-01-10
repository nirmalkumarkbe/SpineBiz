package PageObjectModel;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountHistoryPage extends BaseClass{
	
	public AccountHistoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[contains(text(),'Available balance')]//following::td[1]")
	public WebElement accountBalance;
	
	@FindBy(xpath = "//*[contains(text(),'Transfer Funds')]")
	public WebElement transferFundButton;
	
	public static String getAccountBalance(WebDriver driver)
	{
		WebElement AvailableBalance = driver.findElement(By.xpath("//*[contains(text(),'Available balance')]//following::td[1]"));
		String strAvailableBalance =AvailableBalance.getText();
		return strAvailableBalance;
	}
	
	public static void clickTransferFund(WebDriver driver)
	{
		WebElement TransferFunds_WebLink = driver.findElement(By.xpath("//*[contains(text(),'Transfer Funds')]"));
		TransferFunds_WebLink.click();
	}

}
