package com.product.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.product.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//div//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//div//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//div//button[@type='submit']")
	WebElement loginBtn;
	@FindBy(xpath="//img[@class=\"logo1\"]")
	WebElement MzLogo;
	
	//Create Constructor for Initialize the webElements
		public LoginPage() {
			//Initializing WebElements
			PageFactory.initElements(driver,this);
		}
		
		public String ValidateLoginpageTitle() throws InterruptedException {
			Thread.sleep(5000);
			return driver.getTitle();
			
		}
		
		public boolean ValidateMzLogo() throws InterruptedException {
			Thread.sleep(5000);
			return MzLogo.isDisplayed();
		}
		
		
		public HomePage login() {
			email.sendKeys(prop.getProperty("username"));
			password.sendKeys(prop.getProperty("password"));
			loginBtn.click();
			
			return new HomePage();
		}
}
