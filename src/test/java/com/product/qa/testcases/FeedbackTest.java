package com.product.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.Feedback;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;

public class FeedbackTest extends TestBase{
	LoginPage login;
	Feedback feedback;
	HomePage homepage;
	
	public FeedbackTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
	
		initialization();
		login=new LoginPage();	
		homepage= new HomePage();
		feedback= new Feedback();
		homepage=login.login();
		homepage.clickOnProfile();
		feedback.clickOnFeedbackOption();
		Thread.sleep(9000);
	}
	 	
	@Test(priority=1,enabled=true)
	public void validateFeedbackLabelTest()
	{
		Assert.assertTrue(feedback.validateFeedbackLabel());
	}
	@Test(priority = 2,enabled=true)
	public void cancelButtonTest()
	{
		feedback.validateCancleButton();
		
	}
	@Test(priority = 3,enabled=true)
	public void submitFeedbackTest()
	{
		feedback.submitFeedback();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
}


}
