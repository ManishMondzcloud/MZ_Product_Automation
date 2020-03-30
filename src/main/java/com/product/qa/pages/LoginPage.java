package com.product.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.product.qa.pages.HomePage;
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
	@FindBy(xpath = "//p//div[text()='Invalid email address or password.']")
	WebElement LoginError;
	
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
		
		public HomePage login1(String Username, String Password) {
			
			
			
			email.sendKeys(Username);
			String emailtext=email.getAttribute("validationMessage");
			password.sendKeys(Password);
			String pwdtext= password.getAttribute("validationMessage");
			loginBtn.click();
			try
			{
				//Get text Value Of Login Error
				String error=LoginError.getText();
				
				
				
				//Compare text 
				if(error.equals("Invalid email address or password.")||emailtext.equalsIgnoreCase("Please fill out this field.")
						||pwdtext.equalsIgnoreCase("Please fill out this field."))
				{
					//System.out.println("Invalid Login");
					Assert.fail("Invalid Login");
				}
				else {
					//Assert.fail("Login Successfull");
					System.out.println("Login Successfull");
				}
			}
			catch (Exception e) {
			}

			return new HomePage();
			}

		
	public void login2(/* String Uname, String Pwd */)
		{
		String emailtext=email.getAttribute("validationMessage");
		System.out.println(emailtext);
		}
}
