package com.automation.tests.scripts;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.forgotpassword.Forgotpassword;
import com.automation.pages.home.HomePage;
import com.automation.pages.home.HomeSalesforce;
import com.automation.pages.login.LoginPage;
import com.automation.pages.login.LoginSalesforce;
import com.automation.tests.base.BaseSalesforce;
import com.automation.tests.utilities.PropertiesUtility;

public class SalesforceScript extends BaseSalesforce {
@Test

	public void login_to_salesforce() throws InterruptedException {
		
	String expected = "Home Page ~ Salesforce - Developer Edition";
	
	PropertiesUtility pro=new PropertiesUtility();
	Properties p=pro.createPropertyObject();
	pro.loadFile("applicationDataProperties",p);
	String username=pro.getPropertyValue("login.valid.userid",p);
	String password=pro.getPropertyValue("login.valid.password",p);
	
	LoginSalesforce loginPage=new LoginSalesforce(driver);
	loginPage.enterUserName(username);
	Thread.sleep(1000);
	loginPage.enterPassword(password);
	driver=loginPage.clickLoginButton();
	Thread.sleep(3000);
	
	HomeSalesforce homePage=new HomeSalesforce(driver);
	String actual=homePage.getTextFromHomePage();
	Assert.assertEquals(actual, expected);
}	

@Test

private static void check_remember_me() throws InterruptedException {
	// TODO Auto-generated method stub
	
	String expected = "Home Page ~ Salesforce - Developer Edition";
	String expected1 = "Login | Salesforce";
	PropertiesUtility pro=new PropertiesUtility();
	Properties p=pro.createPropertyObject();
	pro.loadFile("applicationDataProperties",p);
	String username=pro.getPropertyValue("login.valid.userid",p);
	String password=pro.getPropertyValue("login.valid.password",p);
	
	LoginSalesforce loginPage=new LoginSalesforce(driver);
	loginPage.enterUserName(username);
	Thread.sleep(1000);
	loginPage.enterPassword(password);
	loginPage.clickRememberButton();
	driver=loginPage.clickLoginButton();
	Thread.sleep(6000);


	HomeSalesforce homePage=new HomeSalesforce(driver);
	String actual=homePage.getTextFromHomePage();
	Assert.assertEquals(actual, expected);
	
	homePage.clickButton();
	driver = homePage.clickLogoutButton();
	Thread.sleep(3000);
	
	String actual1=loginPage.getTitleOfThePAge();
	Assert.assertEquals(actual1, expected1);
	
	String username1 = loginPage.getText();
	//System.out.println(username1);
	Assert.assertEquals(username1, "jencyv1619@gmail.com");


}
@Test

private static void validate_login_error_message() throws InterruptedException {
	// TODO Auto-generated method stub
	
	System.out.println("**************Validate login error message test case started***********");
	String expected ="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	PropertiesUtility pro=new PropertiesUtility();
	Properties  p=pro.createPropertyObject();
	pro.loadFile("applicationDataProperties",p);
	String username1=pro.getPropertyValue("login.invalid.userid",p);
	String password1=pro.getPropertyValue("login.invalid.password",p);
Thread.sleep(2000);

LoginSalesforce loginPage=new LoginSalesforce(driver);
loginPage.enterUserName(username1);
Thread.sleep(1000);
loginPage.enterPassword(password1);
loginPage.clickRememberButton();
driver=loginPage.clickLoginButton();
Thread.sleep(6000);

String actual=loginPage.getErrorMessage();
Assert.assertEquals(actual, expected,"Pass: testcase passed");
	

	System.out.println("*****Validate Login Error message test case ended*****");
}	

@Test

private static void login_error_message() throws InterruptedException {
	// TODO Auto-generated method stub
	System.out.print("******Login Error Message test case started*******");
	String expected = "Please enter your password.";
	PropertiesUtility pro=new PropertiesUtility();
	Properties  p=pro.createPropertyObject();
	pro.loadFile("applicationDataProperties",p);
	String username1=pro.getPropertyValue("login.invalid.userid",p);
	//String password1=pro.getPropertyValue(" ",p);
Thread.sleep(2000);

LoginSalesforce loginPage=new LoginSalesforce(driver);
loginPage.enterUserName(username1);
Thread.sleep(1000);
loginPage.enterPassword("");
driver=loginPage.clickLoginButton();
Thread.sleep(6000);


String actual=loginPage.getErrorMessage();
Assert.assertEquals(actual, expected,"Pass: testcase passed");	

System.out.println("********Login error message test case ended***********");	
}	


@Test

private static void forgot_password() throws InterruptedException {
	// TODO Auto-generated method stub
	System.out.println("***********************Forgot password testcase started*******************");
	
	PropertiesUtility pro=new PropertiesUtility();
	Properties p=pro.createPropertyObject();
	pro.loadFile("applicationDataProperties",p);
	String username=pro.getPropertyValue("login.valid.userid",p);
	
	Thread.sleep(1000);
	LoginSalesforce loginpage = new LoginSalesforce(driver);
	driver=loginpage.clickforgotButton();
	
	Thread.sleep(3000);
	
	Forgotpassword forgotpage = new Forgotpassword(driver);
	forgotpage.enterUserName(username);
	driver=forgotpage.clickLoginButton();
	Thread.sleep(5000);
	
	//forgotpage.clickElement(null, username);
/*	WebElement forgot_pass= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/div/a[1]"));
	clickElement(forgot_pass,"Forgot");
	Thread.sleep(2000);
	WebElement id = driver.findElement(By.id("un"));
	enterText(id,username,"Id");
	WebElement continu= driver.findElement(By.id("continue"));
	waitForVisibility(continu,5);
	clickElement(continu,"Continue ");
	WebElement headerElement = driver.findElement(By.id("header"));
	String actual=getTextFromElement(headerElement, "header");
	System.out.println(actual);
	Assert.assertEquals(actual,"Check Your Email" ,"Testcase failed");
	
	*/
System.out.println("************Forgot Password Test case ended*****************");
}



}


