package com.product.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.BlogPage;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;
import com.product.qa.pages.MyEvents;

public class BlogsPageTest extends TestBase 
{
	
	LoginPage login;
	BlogPage blog;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, AWTException {
	
		initialization();
		login=new LoginPage();
		homepage= new HomePage();
		blog= new BlogPage();
		homepage=login.login();
		Thread.sleep(14000);
	}
	
	@Test(priority = 1,enabled = true)
    public void verifyBlogopenByLinkTest() throws InterruptedException
    {
     blog.verifyBlogOpenByLink();	
    }
	@Test(priority = 2,enabled = true)
    public void verifyReadMoreBtnTest() throws InterruptedException
    {
    	blog.verifyReadMoreBtn();
    }
	@Test(priority = 3,enabled = true)
    public void relatedCourseOpenTest() throws InterruptedException, AWTException
    {
    	blog.verifyRelatedCourseOpen();
    }
	@Test(priority = 4,enabled = true)
    public void relatedEventsOpenTest() throws InterruptedException
    {
    	blog.verifyRelatedEventsOpen();
    }
	@Test(priority = 5,enabled = true)
    public void relatedTagsOpenTest() throws InterruptedException
    {
    	blog.verifyTagsOpen();
    }
	@Test(priority = 6,enabled = true)
	public void addingCommentTest() throws InterruptedException
	{
		blog.verifyAddingComment();
	}
	@Test(priority = 7,enabled = true)
	public void EditCommentTest() throws InterruptedException
	{
		blog.verifyEditComment();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
}
	
}
