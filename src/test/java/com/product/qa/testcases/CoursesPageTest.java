package com.product.qa.testcases;

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
	TestUtil testUtil;
	String sheetName="Courses";
	
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
	
	@Test(priority=1,enabled=false)
	public void VerifyCoursesPageLabelTest() {
		Assert.assertTrue(coursespage.VerifyCoursesLabel());
	}
	
	@Test(priority=2, enabled=true)
	public void VerifyCoursesPageFilterLinksTest() throws InterruptedException {
		coursespage.ValidateFilterLinks();
	}
	
	@DataProvider
	public Object[] getTestData1() { 
		Object data[]=TestUtil.getTestData1(sheetName);
		return data; 
	}
	@Test(priority=3,dataProvider = "getTestData1", enabled=true)
	public void VerifyCoursesTest(String session) throws InterruptedException {
		coursespage.VerifyCourses(session);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
}
}
