package com.product.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.CoursesPage;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;

public class CoursesPageTest extends TestBase {

	CoursesPage coursespage;
	LoginPage loginpage;
	HomePage homepage;
	public CoursesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization();
		coursespage=new CoursesPage();
		loginpage=new LoginPage();
		homepage=loginpage.login();
		coursespage=homepage.ClickOnCoursesLink();
	}
	
	@Test(priority=2,enabled=false)
	public void VerifyCoursesPageLabelTest() {
		Assert.assertTrue(coursespage.VerifyCoursesLabel());
	}
	
	@Test(priority=1, enabled=true)
	public void VerifyCoursesPageFilterLinksTest() throws InterruptedException {
		coursespage.ValidateFilterLinks();
	}
	
	@Test(priority=3)
	public void VerifyCoursesLinkTest() throws InterruptedException {
		coursespage.VerifyCoursesLink();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
}
}
