package PageObjectModel;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecentTransactionPage extends BaseClass{
	
	public RecentTransactionPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='_ctl0__ctl0_Content_Main_MyTransactions']/tbody/tr[2]/td[3]")
	public WebElement firstAccountID;
	@FindBy(xpath = "//*[@id='_ctl0__ctl0_Content_Main_MyTransactions']/tbody/tr[3]/td[3]")
	public WebElement secondAccountID;
	
	@FindBy(xpath = "//*[@id='_ctl0__ctl0_Content_Main_MyTransactions']/tbody/tr[2]/td[4]")
	public WebElement firstAction;
	@FindBy(xpath = "//*[@id='_ctl0__ctl0_Content_Main_MyTransactions']/tbody/tr[3]/td[4]")
	public WebElement secondAction;
	
	@FindBy(xpath = "//*[@id='_ctl0__ctl0_Content_Main_MyTransactions']/tbody/tr[2]/td[5]")
	public WebElement firstAmount;
	@FindBy(xpath = "//*[@id='_ctl0__ctl0_Content_Main_MyTransactions']/tbody/tr[3]/td[5]")
	public WebElement secondAmount;
	
	public static void validateTransactions(WebElement FirstAccountID, WebElement SecondAccountID,
			WebElement FirstAction, WebElement SecondAction,
			WebElement FirstAmount, WebElement SecondAmount)
	{
//		WebElement FirstAccountID = driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_MyTransactions\"]/tbody/tr[2]/td[3]"));
//		WebElement SecondAccountID = driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_MyTransactions\"]/tbody/tr[3]/td[3]"));
//		
//		WebElement FirstAction = driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_MyTransactions\"]/tbody/tr[2]/td[4]"));
//		WebElement SecondAction = driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_MyTransactions\"]/tbody/tr[3]/td[4]"));
//				
//		WebElement FirstAmount = driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_MyTransactions\"]/tbody/tr[2]/td[5]"));
//		WebElement SecondAmount = driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_MyTransactions\"]/tbody/tr[3]/td[5]"));
		
		if(FirstAccountID.getText().equalsIgnoreCase("800001"))
		{
			if(FirstAction.getText().equalsIgnoreCase("Deposit"))
			{
				if(FirstAmount.getText().equalsIgnoreCase("$9876.00"))
				{
					System.out.println("Deposit Transaction is displayed correctly");
				}
			}
		}
		
		if(SecondAccountID.getText().equalsIgnoreCase("800000"))
		{
			if(SecondAction.getText().equalsIgnoreCase("Withdrawal"))
			{
				if(SecondAmount.getText().equalsIgnoreCase("-$9876.00"))
				{
					System.out.println("Withdrawal Transaction is displayed correctly");
				}
			}
		}

	}
	
	@FindBy(xpath = "//*[contains(text(),'Contact Us')]")
	public WebElement contactUsButton;
	
	public static void clickContactUs(WebDriver driver)
	{
		WebElement ContactUS = driver.findElement(By.xpath("//*[contains(text(),'Contact Us')]"));
		ContactUS.click();
	}

}
