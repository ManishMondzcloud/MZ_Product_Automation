package com.product.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.product.qa.base.TestBase;

public class Help extends TestBase{
	
	
	@FindBy(xpath="//a[@class='nav-link active active']")
	WebElement HelpLink;
	
	@FindBy(xpath="//input[@id='contactName']")
	WebElement ContactName;
	
	@FindBy(xpath="//input[@id='contactEmail']")
	WebElement ContactEmail;
	
	@FindBy(xpath="//input[@id='contactPhone']")
	WebElement ContactPhone;
	
	@FindBy(xpath="//textarea[@placeholder='Your message']")
	WebElement Messsage;
	
	@FindBy(xpath="//button[@class='btn btn-primary-grd btn-round uppr btn-round-help']")
	WebElement SubmitButton;
	
	@FindBy(xpath="//div[contains(text(),'Please enter your message')]")
	WebElement PleaseEnterYourMessage;
	
	@FindBy(xpath="//body//form//p[1]")
	WebElement charecterLimit;
	
	
	
	//Create Constructor for Initialize the webElements
		public Help() {
			//Initializing WebElements 
			PageFactory.initElements(driver,this);
		}
		
		
		
		public void verifyPleaseEnterYourMessage() throws InterruptedException
		{
			//Click on the help link
			Thread.sleep(5000);
			WebElement element = driver.findElement(By.xpath("//li[@class='nav-item linkmenu']//a[@class='nav-link']"));        
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element);
		
			//Click on submit button
			  WebElement element1 = driver.findElement(By.xpath("//button[text()='Submit']"));
			  JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			  executor.executeScript("arguments[0].click();",element1); 
			  element1.click();
			//Verify the warning message
			  String s=PleaseEnterYourMessage.getText();
			  Assert.assertEquals(s,"Please enter your message");
		}
		public void verifyCharecterCount() throws InterruptedException
		{
			//Click on the help link
			Thread.sleep(5000);
			WebElement element = driver.findElement(By.xpath("//li[@class='nav-item linkmenu']//a[@class='nav-link']"));        
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element);
			Messsage.sendKeys("Test");
			String s=charecterLimit.getText();
			System.out.println(s);
		
		}
		
	   public void verifyContactUS() throws InterruptedException
	   {
		//Click on the help link
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//li[@class='nav-item linkmenu']//a[@class='nav-link']"));        
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		//HelpLink.click();
		
		//Enter the message
	     Messsage.sendKeys("Test");
		
		Thread.sleep(3000);
		//Click on submit button
		  //WebElement element1 = driver.findElement(By.xpath("//button[text()='Submit']"));
		  //JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		  //executor.executeScript("arguments[0].click();",element1); 
		  //element1.click();
		 
		//SubmitButton.click();
		SubmitButton.submit();
		Thread.sleep(3000);
		
	}
	
	

}
