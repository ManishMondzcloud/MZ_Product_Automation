package com.product.qa.pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.product.qa.base.TestBase;

public class ForgotPasswordPage extends TestBase {

	@FindBy(xpath = "//p//a//span[text()='Forgot password?']" )
	WebElement ForgotYourPasswordLink;
	
	@FindBy(xpath = "//div//input[@name='email']")
	WebElement UserName;
	
	@FindBy(xpath = "//div//button[@type='submit']")
	WebElement PasswordResetButton;
	
	@FindBy(xpath = "//div//a[text()='Cancel']")
	WebElement CancelButton;
	
	@FindBy(xpath = "//div[@class='content']/p/div[@classname='alert-dismissible alert alert-danger']")
	WebElement MessageError;
	
	@FindBy(xpath = "//div[@class='content']/p/div[@classname='alert-dismissible alert alert-success']")
	WebElement PasswordResetText;
	
	public ForgotPasswordPage() {
		//initializing WebElement
		PageFactory.initElements(driver ,this);
}
	
	public ForgotPasswordPage VerifyForgotPassword() throws InterruptedException {
		Thread.sleep(5000);
		ForgotYourPasswordLink.click();
		UserName.clear();
		UserName.sendKeys(prop.getProperty("Email"));
		
		WebElement element=PasswordResetButton;
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", element);
		//PasswordResetButton.click();
		//Assert.fail("Wrong Email");
		try
		{
			//Get text Value Of Login Error
			String error=MessageError.getText();
			//Compare text 
			if(error.equals("Username cannot be blank")||error.equals("Invalid username"))
			{
				System.out.println(error);
			}
			else {
				Assert.fail(PasswordResetText.getText());
				//System.out.println(PasswordResetText.getText());
			}
		}
		catch (Exception e) {
		}

		
		return new ForgotPasswordPage();
	}
}


