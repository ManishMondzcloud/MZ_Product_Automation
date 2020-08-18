	
package com.product.qa.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.CoursesPage;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;
import com.product.qa.util.TestUtil;

public class CoursesPageTest extends TestBase {

	CoursesPage coursespage;
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	String sheetName2="Courses";
	public CoursesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException, AWTException{
		initialization();
		coursespage=new CoursesPage();
		loginpage=new LoginPage();
		homepage=loginpage.login();
		testutil=new TestUtil();
		coursespage=homepage.ClickOnCoursesLink();
	}
	
	@Test(priority=2,enabled=true)
	public void VerifyCoursesPageLabelTest() {
		Assert.assertTrue(coursespage.VerifyCoursesLabel());
	}
	
	@Test(priority=1, enabled=true)
	public void VerifyCoursesPageFilterLinksTest() throws InterruptedException {
		coursespage.ValidateFilterLinks();
	}	
	
	@Test(priority=3, enabled=true)
	public void VerifyCoursesReviewTest() throws InterruptedException {
		coursespage.verifyCourseReviewButton();
	}	
	
	@Test(priority=4, enabled=true)
	public void VerifyDoubtTest() throws InterruptedException {
		coursespage.verifyAskYourDoubt();
	}	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
}
}
