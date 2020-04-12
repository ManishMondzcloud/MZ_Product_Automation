package com.product.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.DashboardPage;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;


public class DashboardPageTest extends TestBase {
	LoginPage login;
	DashboardPage dashboard;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, AWTException {
	
		initialization();
		login=new LoginPage();	
		homepage= new HomePage();
		dashboard= new DashboardPage();
		homepage=login.login();
		Thread.sleep(9000);
	}
	@Test(priority = 1,enabled = true)
	public void courseCountTest() throws InterruptedException 
	{
		dashboard.verifyCoursesCount();
	}
	@Test(priority = 2,enabled = true)
	public void BlogsCountTest() throws InterruptedException 
	{
		dashboard.verifyBlogsCount();
	}
	@Test(priority = 3,enabled = true)
	public void EventsCountTest() throws InterruptedException 
	{
		dashboard.verifyEventsCount();
	}
	
	
	@Test(priority=1,enabled=true)
	public void LearnigPathLabelTest()
	{
		dashboard.verifyLearningPathLabel();
	}
	@Test(priority=2,enabled=true)
	public void resumeButtonTest() throws InterruptedException
	{
	   dashboard.verifyResumeCourse();
	}
	@Test(priority=3,enabled=true)
	public void startButtonTest() throws InterruptedException
	{
		dashboard.verifyStartCourse();
	}
	
	@Test(priority=4, enabled = true)
	public void upcomingEventLabelTest() 
	{
      dashboard.verifyUpcomingEventlabel();
	}
	
	@Test(priority=5,enabled= true)
	public void verifyEventOpenTest() throws InterruptedException
	{
		dashboard.verifyEventOpen();
	}
	@Test(priority=6,enabled = true)
	public void EventViewAllBtnTest() throws InterruptedException
	{
		dashboard.verifyEventViewAllBtn();
	}
	
	@Test(priority = 6,enabled = true)
	public void BlogsLabelTest()
	{
		dashboard.verifyLettestBlogsLabel();
	}
	@Test(priority = 7,enabled = true)
	public void BlogsOpenTest() throws InterruptedException
	{
		dashboard.verifyBlogOpen();
	}
	@Test(priority = 8,enabled = true)
	public void BlogsViewAllBtnTest() throws InterruptedException
	{
		dashboard.verifyBlogsViewAllBtn();
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	

}
}


