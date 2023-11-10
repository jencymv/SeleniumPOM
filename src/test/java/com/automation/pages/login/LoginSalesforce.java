package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePageSalesforce;
import com.automation.tests.base.BaseSalesforce;

public class LoginSalesforce extends BasePageSalesforce{

	
	@FindBy(id="username") WebElement userNameElement;
	@FindBy(id="password") WebElement passwordElement;
	@FindBy(id="Login") WebElement loginButtonElement;
	@FindBy(id="rememberUn")  WebElement rememberButtonElement;
	@FindBy(id="error") WebElement errorwongdataElement;
	@FindBy(xpath="//*[@id=\"forgot_password_link\"]") WebElement forgotpasswordElement;
	
	public LoginSalesforce(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String data) {
		//userNameElement.sendKeys(data);
		enterText(userNameElement, data, "Username textbox");
	}
	public void enterPassword(String data) {
		enterText(passwordElement, data, "password field");
	}
	
	
	public void clickRememberButton() {
		clickElement(rememberButtonElement,"Remember button");
	}
	
	public WebDriver clickLoginButton() {
		clickElement(loginButtonElement,"login button");
		return driver;
		
	}
	
	public String getTitleOfThePAge() {
		//waitUntilPageLoads();
		return getPageTitle();
	}
	
	public String getText()
	{
		String data =getTextFromElement(userNameElement,"Username");
		return data;
	}
	
	public String getErrorMessage()
	{
		String data = getTextFromElement(errorwongdataElement,"invalid Password and username Login Error message");
		return data;
		
	}
	

	public WebDriver clickforgotButton() {
		clickElement(forgotpasswordElement,"Forgot Password button");
		return driver;
		
	}
	
}
