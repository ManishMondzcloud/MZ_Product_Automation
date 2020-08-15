package com.product.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.DashboardPage;
import com.product.qa.pages.Help;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;

public class HelpTest extends TestBase {

	LoginPage login;
	Help help;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, AWTException {
	
		initialization();
		login=new LoginPage();	
		homepage= new HomePage();
		help= new Help();
		homepage=login.login();
		Thread.sleep(9000);
	}
	@Test(priority = 1,enabled = false)
	public void verifyPleaseEnterYourMessage() throws InterruptedException
	{
		help.verifyPleaseEnterYourMessage();
	}
	
	@Test(priority = 2,enabled = false)
	public void verifyCharecterCount() throws InterruptedException
	{
		help.verifyCharecterCount();
	}
	
	@Test(priority = 3,enabled = false)
	public void VerifyHelpTest() throws InterruptedException 	
	
	{
		help.verifyContactUS();
			
	}
	
	
}
