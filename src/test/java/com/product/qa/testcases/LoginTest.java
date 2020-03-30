package com.product.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.product.qa.util.TestUtil;
import com.product.qa.base.TestBase;
import com.product.qa.pages.ForgotPasswordPage;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;

public class LoginTest extends TestBase{
	LoginPage login;
	ForgotPasswordPage forgotPasswordPage;
	HomePage homepage;
	TestUtil testUtil;
	String sheetName="Login";
	
	 public LoginTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
	
		initialization();
		login=new LoginPage();
		forgotPasswordPage=new ForgotPasswordPage();
		homepage= new HomePage();
		testUtil= new TestUtil();
	}
	
	 @Test(priority=1, enabled = true)
	 public void LoginPageTitletest() throws InterruptedException {
		String title=login.ValidateLoginpageTitle();
		Assert.assertEquals(title,"MZ Training Portal - Login");
	 }
	 
	 @Test(priority=2, enabled=true)
	 public void MzLogoImagetest() throws InterruptedException {
		boolean logo= login.ValidateMzLogo();
	  Assert.assertTrue(logo);
	 }
	
	 	
	@Test(priority=3,enabled=true)
	public void ValidateLogin() {
		homepage=login.login();
	}
	
	@Test(enabled=false,priority=4) 
	  public void ValidateForgotPassword() throws InterruptedException 
	  {
	  forgotPasswordPage.VerifyForgotPassword();
	  
	  }
	//InValid Login UserName and Password
	@DataProvider
	public Object[][] getTestData() { 
		Object data[][]=TestUtil.getTestData(sheetName);
		return data; 
	}
	
	@Test(priority=1,dataProvider = "getTestData", enabled = true)
	public void ValidateLoginTest(String Username,String Password) {
		//call login method to send the values in username and password.
	    homepage=login.login1(Username, Password);  
		
	}
	@Test(enabled = false)
	public void ValidateLogin2() {
		login.login2();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
}
}
