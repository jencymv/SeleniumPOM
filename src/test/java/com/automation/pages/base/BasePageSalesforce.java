package com.automation.pages.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//import com.automation.tests.utilities.ExtentReportsUtility;
import com.automation.tests.utilities.Log4JUtility;
import com.automation.tests.utilities.PropertiesUtility;

public class BasePageSalesforce {

 protected static WebDriver driver;
	WebDriverWait wait;
	protected Log4JUtility logObject=Log4JUtility.getInstance();
	protected static Logger myLog;
//	protected ExtentReportsUtility report=ExtentReportsUtility.getInstance();
	

	public BasePageSalesforce(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//		maximiseBrowser();
	//	goToUrl(url);
	
	public static String getPageTitle() {
			return driver.getTitle();
		}
		
	/*	public static void logintoBrowser()
		{
			PropertiesUtility pro=new PropertiesUtility();
			Properties appProp= pro.loadFile("applicationDataProperties");
			String username=appProp.getProperty("login.valid.userid");
			String password=appProp.getProperty("login.valid.password");
			
			WebElement username1 = driver.findElement(By.id("username"));
			waitForVisibility(username1,20);
			enterText(username1,username,"Username ");
			WebElement password1 = driver.findElement(By.id("password"));
			waitForVisibility(password1,20);
			enterText(password1,password,"password ");
			
			WebElement login_but= driver.findElement(By.id("Login"));
			clickElement(login_but,"Login ");
			
		}
*/
		public static String getTextFromElement(WebElement element, String objectName)
		{
			String data = element.getText();
			System.out.println(data + "text extracted from " + objectName);
			return data;
		}
		
		public static void waitForVisibility(WebElement ele,int time,int pollingtime,String objectName)
		{
			FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
			wait.withTimeout(Duration.ofSeconds(5))
			.pollingEvery(Duration.ofSeconds(2))
			.ignoring(ElementNotInteractableException.class);
			wait.until(ExpectedConditions.visibilityOf(ele));
			
			System.out.println(objectName+"is waited for visibilty using fluent wait");
		}
		
		public static void waitForVisibility(WebElement ele,int time)
		{
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOf(ele));
			
		}
		public static void goToUrl(String url)
		{
			driver.get(url);
			System.out.println(url+"is enetered");
		}
		
		public static void maximiseBrowser() {
			driver.manage().window().maximize();
		}
		
		
		public static void enterText(WebElement ele,String data,String ObjectName)
		{
			if(ele.isDisplayed())
			{
				ele.clear();
				ele.sendKeys(data);
				System.out.println(ObjectName+" is enetered in the object");
			}
			else
			{
				System.out.println(ObjectName+" is not displayed");
			}
		}
		
		
		public static void elementDisplayed(WebElement ele,String ObjectName)
		{
			if(ele.isDisplayed())
			{
				
				System.out.println(ObjectName+" Element is enetered in the object");
			}
			else
			{
				System.out.println(" Element is not displayed");
			}
		}
		
		public static void clickElement(WebElement ele,String i) {
			if(ele.isEnabled()) {
				ele.click();
				System.out.println(i+"button is clicked");
				}
				else {
					System.out.println("button element is not enabled");
				}
		}
		
		
	
		public static void webElementToBeClickable(WebElement elem,int time) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		}


		public static String getTextFromElement(WebElement ele)
		{
			String data= ele.getText();
			return data;
		}
		public static void selectDropDown(WebElement ele,int index)
		{
			Select select = new Select(ele);
			select.selectByIndex(index);
		}
		
		public static void selectDropDown(WebElement ele,String text)
		{
			Select select = new Select(ele);
			select.selectByVisibleText(text);
		
			ArrayList<WebElement> list = (ArrayList<WebElement>)select.getOptions();
			for(WebElement ele1:list)
			{
			System.out.println(ele1.getText());
			}
		}

		public static void mouseOver(WebDriver driver,WebElement ele)
		{
			if(ele.isDisplayed())
			{
				Actions action = new Actions(driver);
				action.moveToElement(ele).build().perform();
				System.out.println("Element is prsesnt");
			}
			{
				System.out.println("Element not present");
			}
		}
		public static void gotoUrl(String url)
		{
			driver.get(url);
			System.out.println("Url is entered");
		}
		
		public static void closeBrowser()
		{
			driver.close();
		}
		
 
		}
