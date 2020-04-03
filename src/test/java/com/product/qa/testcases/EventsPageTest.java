package com.product.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.EventsPage;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;


public class EventsPageTest extends TestBase{
	LoginPage login;
	EventsPage event;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
	
		initialization();
		login=new LoginPage();	
		homepage= new HomePage();
		event= new EventsPage();
		homepage=login.login();
		Thread.sleep(9000);
	}
	
	
	@Test(priority=1,enabled=true)
	public void VerifyMyEvent() throws InterruptedException
	{
		event.VerfyEventSubscribe();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}