package org.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void browserLaunchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public static void browserLaunchEdge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	
	public static void fillText(WebElement ele, String text) {
		ele.sendKeys(text);
	}
	
	public static void clickButton(WebElement ele) {
		ele.click();
	}
	
	public static String getTextValue(WebElement ele) {
		String text = ele.getText();
		return text;
	}
	
	public static void maxBrowser() {
		driver.manage().window().maximize();
	}
	
	public static void selectByText(WebElement ele, String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);

	}
	public static void closeBrowser() {
		driver.quit();

	}
	
}
