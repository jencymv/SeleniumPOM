package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePageSalesforce;

public class HomeSalesforce extends BasePageSalesforce{
@FindBy(xpath ="/html/body/div[2]/div[2]/h1") WebElement home;
@FindBy(xpath = "//span[@id='userNavLabel']") WebElement usermenu;
@FindBy(linkText="Logout") static WebElement logout_button;
	
	public HomeSalesforce(WebDriver driver) {
		super(driver);
	}
	

	public static String getTextFromHomePage() throws InterruptedException {
		Thread.sleep(2000);
		return getPageTitle();
	}

/*	public String getTextFromStudentRegistrationFormText() {
		waitForVisibility(home, 30,"studetn resitration text area");
		String data= getTextFromElement(home, "stu regi form text");
		System.out.println("text extracted from registartion page="+data);
		return data;
	}
	*/
	/*public void clickButton() {
		clickElement(rememberButtonElement,"Remember button");
	}
	*/
	

public void clickButton() {
	clickElement(usermenu,"Usermenu button");
}

	public WebDriver clickLogoutButton() {
		clickElement(logout_button,"Logout button");
		return driver;
		
	}

}
