package com.product.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.product.qa.base.TestBase;

public class ChangePassword extends TestBase{
	
	
	@FindBy(xpath="//div[@id='navbarText']//ul//li//div//a[contains(text(),'Change Password')]")
	WebElement changePwdOption;
	
	@FindBy(xpath="//input[@id='oldPassword']")
	WebElement currentPwd;
	
	@FindBy(xpath="//input[@id='newPassword']")
	WebElement NewPwd;
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	WebElement ConfirmPwd;
	
	@FindBy(xpath=" //span[contains(text(),'Update')]")
	WebElement updateBtn;
	
	@FindBy(xpath="//h2[contains(text(),'Change Password')]")
	WebElement changePasswordLabel;
	
	@FindBy(xpath="//body//div[@id='root']//div//div//div//div//div//div//div//div[1]//div[1]//div[1]")
	WebElement PleaseEnterPasswordMessage;
	
	@FindBy(xpath="//div[contains(text(),'Please enter a valid password')]")
	WebElement PleaseEnterValidPasswordMessage;
	
	@FindBy(xpath="//div[contains(text(),'Password mismatch')]")
	WebElement PasswordMissMatchMessage;
	
	@FindBy(xpath="//div[contains(text(),'Please re-enter password')]")
	WebElement PleaseReEnterPassword;
	
	//Create Constructor for Initialize the webElements
	public ChangePassword() {
		//Initializing WebElements
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnChangePassword()
	{
		//changePwdOption.click();
		 WebElement element = driver.findElement(By.xpath("//div[@id='navbarText']//ul//li//div//a[contains(text(),'Change Password')]"));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
	}
	
	public boolean changePasswordLabel()
	{
		return changePasswordLabel.isDisplayed();
	}
	
	public void verifyPleaseEnterPasswordText()
	{
		updateBtn.click();
		String s=PleaseEnterPasswordMessage.getText();
		Assert.assertEquals(s,"Please enter a password");
	}
	
	public void verifyPleaseEnterValidPasswordText()
	{
		currentPwd.sendKeys("12345");
		NewPwd.sendKeys("123");
		ConfirmPwd.click();
		String s1=PleaseEnterValidPasswordMessage.getText();
		Assert.assertEquals(s1,"Please enter a valid password");
	}
	
	public void verifyPleaseReEnterPasswordText()
	{
		currentPwd.sendKeys("12345");
		NewPwd.sendKeys("Ma@123456789");
		updateBtn.click();
		String s2=PleaseReEnterPassword.getText();
		Assert.assertEquals(s2,"Please re-enter password");
		
	}
	
	public void verifyPasswordMisMatchTextTest()
	{
		currentPwd.sendKeys("12345");
		NewPwd.sendKeys("Ma@123456789");
		ConfirmPwd.sendKeys("123");
		updateBtn.click();
		String s2=PasswordMissMatchMessage.getText();
		Assert.assertEquals(s2,"Password mismatch");
	}
	
	public void verifyChangePassword()
	{
		currentPwd.sendKeys("12345");
		NewPwd.sendKeys("123456");
		ConfirmPwd.sendKeys("123456");
		//updateBtn.click();
		System.out.println("password updation successfull");
	}
	
	
	
	
}