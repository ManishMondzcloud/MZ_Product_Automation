package com.product.qa.testcases;

import org.testng.annotations.BeforeMethod;

import com.product.qa.pages.DashboardPage;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;


public class DashboardPageTest {
	LoginPage login;
	DashboardPage dashboard;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
	
		initialization();
		login=new LoginPage();	
		homepage= new HomePage();
		dashboard= new DashboardPage();
		homepage=login.login();
		Thread.sleep(9000);
	}

}
