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
	//@FindBy(xpath="//body/div[@id='root']/div/div[2]")
	WebElement SuccessMsg;
	
	@FindBy(xpath="//span[contains(text(),'Welcome Back !')]")
	WebElement WelcomeBackText;
	
	@FindBy(xpath="//h5[contains(text(),'Submit Your Feedback')]")
	WebElement FeedbackLabel;
	
	
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
			
			public void submitFeedback() {
				
				messageBox.sendKeys("Test");
				Submitbtn.click();
				System.out.println("Feedback given is successful");
				
			}
				

}
