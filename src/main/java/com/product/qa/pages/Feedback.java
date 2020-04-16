package com.product.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.product.qa.base.TestBase;

public class Feedback extends TestBase {
	
	
	@FindBy(xpath="//div[@id='navbarText']//ul//li//div//a[contains(text(),'Feedback')]")
	WebElement feedbackOption;
	
	@FindBy(xpath="//textarea[@id='message']")
	WebElement messageBox;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement Submitbtn;
	
	@FindBy(xpath="//button[@class='btn btn-secondary']")
	WebElement CancelBtn;
	
	@FindBy(xpath = "//div[@class='notification-container-top-right']")
	WebElement SuccessMsg;
	
	@FindBy(xpath="//span[contains(text(),'Welcome Back !')]")
	WebElement WelcomeBackText;
	
	@FindBy(xpath="//h5[contains(text(),'Submit Your Feedback')]")
	WebElement FeedbackLabel;
	
	@FindBy(xpath="//body//form//p[1]")
	WebElement CharecterLimit;
	
	
	//Create Constructor for Initialize the webElements
			public Feedback() {
				//Initializing WebElements
				PageFactory.initElements(driver,this);
			}
			
			
			public void clickOnFeedbackOption()
			{
				feedbackOption.click();
			}
			
			public boolean validateFeedbackLabel()
			{
				return FeedbackLabel.isDisplayed();
				
			}
			
			public void validateCancleButton()
			{
				CancelBtn.click();
				Assert.assertTrue(WelcomeBackText.isDisplayed(),"Cancel button is not working");
				
			}
			public void submitFeedbackWith500Charecter() throws InterruptedException
			{
				
				messageBox.sendKeys("Most people infected with the COVID-19 virus will experience mild to moderate respiratory illness and recover without requiring special treatment.  Older people, and those with underlying medical problems like cardiovascular disease, diabetes, chronic respiratory disease, and cancer are more likely to develop serious illness.\r\n" + 
						"\r\n" + 
						"The best way to prevent and slow down transmission is be well informed about the COVID-19 virus, the disease it causes and how it spreads. Protect yourself and others from");
				Thread.sleep(3000);
				Submitbtn.click();
				System.out.println("Feedback given is successful and take 500 charecter");
				
				
			}
			
			public void submitFeedbackWith501Charecter() throws InterruptedException
			{
				
				messageBox.sendKeys("Most people infected with the COVID-19 virus will experience mild to moderate respiratory illness and recover without requiring special treatment.  Older people, and those with underlying medical problems like cardiovascular disease, diabetes, chronic respiratory disease, and cancer are more likely to develop serious illness.\r\n" + 
						"\r\n" + 
						"The best way to prevent and slow down transmission is be well informed about the COVID-19 virus, the disease it causes and how it spreads. Protect yourself and others from1234567");
				Thread.sleep(3000);
				Submitbtn.click();
				System.out.println("Send more than 500 charecter but taken only 500 charecter");
				
				
			}
			
			public void countCharecter()
			{
				messageBox.sendKeys("12345");
				String s=CharecterLimit.getText();
				System.out.println("After sending 5 charecter 495 charecter should be left."+s);
			}

}
