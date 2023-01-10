package PageObjectModel;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountPage extends BaseClass{

	public AccountPage() {
		PageFactory.initElements(driver	, this);
	}
	
	@FindBy(xpath = "//h1")
	public WebElement accountUserLabelWelcomeMessage;
	
	public static String getAccountUserLabelWelcomeMessage(WebDriver driver)
	{
		WebElement UserLabelWelcomeMessage = driver.findElement(By.xpath("//h1"));
		String WelcomeMessage =UserLabelWelcomeMessage.getText();
		return WelcomeMessage;
	}
	
	@FindBy(xpath = "//*[contains(text(),'View Account Summary')]")
	public WebElement accountSummary;
	
	public static void clickAccountSummary(WebDriver driver)
	{
		WebElement AccountSummary_WebLink = driver.findElement(By.xpath("//*[contains(text(),'View Account Summary')]"));
		AccountSummary_WebLink.click();
	}
	
	@FindBy(xpath = "//*[contains(text(),'View Account Details')]//following::select")
	public WebElement selectAccount;
	
	public static void selectAccount(WebDriver driver,String AccountName)
	{
		WebElement viewAccount_WebList = driver.findElement(By.xpath("//*[contains(text(),'View Account Details')]//following::select"));
		Select s = new Select(viewAccount_WebList);
		s.selectByVisibleText(AccountName);
	}
	
	@FindBy(xpath = "//*[contains(text(),'View Account Details')]//following::input")
	public WebElement goButton;
	
	public static void clickGo(WebDriver driver)
	{
		WebElement Go_WebBtn = driver.findElement(By.xpath("//*[contains(text(),'View Account Details')]//following::input"));
		Go_WebBtn.click();
	}
	
	@FindBy(xpath = "//*[contains(text(),'Contact Us')]")
	public WebElement contactUsBtn;
	
	public static void clickContactUs(WebDriver driver)
	{
		WebElement ContactUS = driver.findElement(By.xpath("//*[contains(text(),'Contact Us')]"));
		ContactUS.click();
	}
	
	@FindBy(xpath = "//*[contains(text(),'online form')]")
	public WebElement onlineForm;
	
	public static void clickOnlineForm(WebDriver driver)
	{
		WebElement onlineform = driver.findElement(By.xpath("//*[contains(text(),'online form')]"));
		onlineform.click();
	}
	
	@FindBy(xpath = "//*[contains(text(),'Your Email Address')]//following::input")
	public WebElement emailAddress_WebEdit;
	
	@FindBy(xpath = "//*[contains(text(),'Subject')]//following::input")
	public WebElement subject_WebEdit;
	
	@FindBy(xpath = "//*[contains(text(),'Question/Comment:')]//following::TEXTAREA")
	public WebElement questions_WebEdit;
	
	@FindBy(name = "submit")
	public WebElement submitBtnFinal;
	
	public static void fillFeedback(WebDriver driver, String Email, String Subject, String Questions)
	{
		WebElement EmailAddress_WebEdit = driver.findElement(By.xpath("//*[contains(text(),'Your Email Address')]//following::input"));
		WebElement Subject_WebEdit = driver.findElement(By.xpath("//*[contains(text(),'Subject')]//following::input"));
		WebElement Questions_WebEdit = driver.findElement(By.xpath("//*[contains(text(),'Question/Comment:')]//following::TEXTAREA"));
		EmailAddress_WebEdit.sendKeys(Email);
		Subject_WebEdit.sendKeys(Subject);
		Questions_WebEdit.sendKeys(Questions);
		WebElement submit_btn = driver.findElement(By.name("submit"));
		submit_btn.click();
		
	}
	
	@FindBy(xpath = "//h1")
	public WebElement thankYouMessage;
	
	public static String getThankYouMessage(WebDriver driver)
	{
		WebElement ThankYouMessage = driver.findElement(By.xpath("//h1"));
		String ThanksMessage =ThankYouMessage.getText();
		return ThanksMessage;
	}
	
	@FindBy(xpath = "//*[contains(text(),'Sign Off')]")
	public WebElement signOff;
	
	public static void clickSignOff(WebDriver driver)
	{
		WebElement SignOff = driver.findElement(By.xpath("//*[contains(text(),'Sign Off')]"));
		SignOff.click();
	}
	
}
