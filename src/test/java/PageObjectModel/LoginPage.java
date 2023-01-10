package PageObjectModel;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[contains(text(),'ONLINE BANKING LOGIN')]")
	public WebElement loginButton;
	
//	public static void clickLogin(WebDriver driver)
//	{
//		WebElement OnlineBankingLogin_WebLink = driver.findElement(By.xpath("//*[contains(text(),'ONLINE BANKING LOGIN')]"));
//		OnlineBankingLogin_WebLink.click();
//	}
	
	@FindBy(id  = "uid")
	public WebElement usernameField;
	
	public static void enterUsername(WebDriver driver, String Username)
	{
		
		
		WebElement Username_WebEdit = driver.findElement(By.id("uid"));
		Username_WebEdit.sendKeys(Username);
	}
	
	@FindBy(id  = "passw")
	public WebElement passwordField;
	
//	public static void enterPassword(WebDriver driver, String Password)
//	{
//		WebElement Password_WebEdit = driver.findElement(By.id("passw"));
//		Password_WebEdit.sendKeys(Password);
//	}
	
	@FindBy(name = "btnSubmit")
	public WebElement submitBtn;
	
//	public static void clickLoginBtn(WebDriver driver)
//	{
//		WebElement Login_WebBtn = driver.findElement(By.name("btnSubmit"));
//		Login_WebBtn.click();
//	}
	
	@FindBy(xpath = "//h1[contains(text(),'Online Banking Login')]//following::span[1]")
	public WebElement loginErrorMessage;
	
//	public static String getLoginErrorMessage(WebDriver driver)
//	{
//		WebElement Login_ErrorMessage = driver.findElement(By.xpath("//h1[contains(text(),'Online Banking Login')]//following::span[1]"));
//		String ErrorDetails =Login_ErrorMessage.getText();
//		return ErrorDetails;
//	}
	

}
