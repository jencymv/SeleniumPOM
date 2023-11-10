package com.automation.pages.forgotpassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePageSalesforce;
import com.automation.tests.base.BaseSalesforce;

public class Forgotpassword extends BasePageSalesforce{
	@FindBy(id="un") WebElement userNameElement;
	@FindBy(id="continue") WebElement cotinueElement;
	
	
	public Forgotpassword(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String data) {
		//userNameElement.sendKeys(data);
		enterText(userNameElement, data, "Username textbox");
	}
	public static String getTextForgotPassword() throws InterruptedException {
		Thread.sleep(2000);
		return getPageTitle();
	}

	public WebDriver clickLoginButton() {
		clickElement(cotinueElement,"Continue button");
		return driver;
		
	}
}
