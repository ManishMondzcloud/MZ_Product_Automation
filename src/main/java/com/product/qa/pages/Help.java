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
	
	@FindBy(xpath="//textarea[@id='contactMessage']")
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
			System.out.println("Click on the help link");
			
			
			//Click on submit button
			  WebElement element1 = driver.findElement(By.xpath("//button[text()='Submit']"));
			  JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			  executor1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			  executor1.executeScript("arguments[0].click();",element1); 
			  element1.click();
			  System.out.println("Click on submit button");
			//Verify the warning message
			  String s=PleaseEnterYourMessage.getText();
			  System.out.println("Read the warning message");
			  Assert.assertEquals(s,"Please enter your message");
			  System.out.println("Compare the message");
		}
		
	   public void verifyContactUS() throws InterruptedException
	   {
		 
			  
			  
		       driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click();
			   Thread.sleep(1500);
			  
			  driver.findElement(By.id("contactMessage")).sendKeys("Test");
				Thread.sleep(1500);
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
		        //This will scroll the web page till end.		
		        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		        Thread.sleep(1500);
				driver.findElement(By.xpath("//button[@class='btn btn-primary-grd btn-round uppr btn-round-help']")).click();
				
				
				Thread.sleep(2000);
			  
			  
			 
	}
	
	
	   

}
