package com.product.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.product.qa.base.TestBase;

public class BlogPage extends TestBase{
	
	
	@FindBy(xpath="//a[contains(text(),'Blog')]")
	WebElement BlogsLink;
	
	@FindBy(xpath="//h2[contains(text(),'Blogs')]")
	WebElement BlogsLabel;
	
	@FindBy(xpath="//a[contains(text(),'Future Opportunities in Android App Development')]")
	WebElement AndroidAppDevelopmentBlogs;
	
	@FindBy(xpath="//div[@class='blog-info']//div[@class='blog-info']//a[@class='blue-btn']")
	WebElement ReadMorebtn;
	
	@FindBy(xpath="//p[contains(text(),'Android Development')]")
	WebElement AndroidRelatedCourse;
	
	@FindBy(xpath="//p[contains(text(),'React JS')]")
	WebElement ReactJSRelaterEvent;
	
	@FindBy(xpath="//a[contains(text(),'Android Development')]")
	WebElement AndroidDevelopmentTags;
	
	@FindBy(xpath="//textarea[@id='message']")
	WebElement Textbox;
	
	@FindBy(xpath="//button[@class='mt-4 btn btn-primary']")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//a[contains(text(),'Read more comments')]")
	WebElement ReadMoreLink;
	
	
	//Create Constructor for Initialize the webElements
			public BlogPage() {
				//Initializing WebElements
				PageFactory.initElements(driver,this);
			}
			
			public boolean verifyBlogsLabel() throws InterruptedException
			{
				BlogsLink.click();
				Thread.sleep(2000);
				return BlogsLabel.isDisplayed();
			}
			
			public void verifyBlogOpenByLink() throws InterruptedException
			{
				BlogsLink.click();
				Thread.sleep(2000);
				AndroidAppDevelopmentBlogs.click();
				Thread.sleep(3000);
				System.out.println("Blog open by link");
			}
			
			public void verifyReadMoreBtn() throws InterruptedException
			{
				BlogsLink.click();
				Thread.sleep(2000);
				ReadMorebtn.click();
				Thread.sleep(3000);
				System.out.println("Blogs open by read more button");
			}
			public void verifyRelatedCourseOpen() throws InterruptedException
			{
				BlogsLink.click();
				Thread.sleep(2000);
				ReadMorebtn.click();
				Thread.sleep(5000);
				AndroidRelatedCourse.click();
				Thread.sleep(3000);
				System.out.println("Related course open");
				
			}
			public void verifyRelatedEventsOpen() throws InterruptedException
			{
				BlogsLink.click();
				Thread.sleep(5000);
				ReadMorebtn.click();
				Thread.sleep(5000);
				ReactJSRelaterEvent.click();
				Thread.sleep(5000);
				System.out.println("Related Event open");
				
			}
			public void verifyTagsOpen() throws InterruptedException
			{
				BlogsLink.click();
				Thread.sleep(5000);
				ReadMorebtn.click();
				Thread.sleep(5000);
				AndroidDevelopmentTags.click();
				Thread.sleep(5000);
				System.out.println(" Android appdevelopment tag open");
			}
			
			public void verifyAddingComment() throws InterruptedException
			{
				ReadMorebtn.click();
				Thread.sleep(3000);
				Textbox.sendKeys("Test11");
				Thread.sleep(2000);
				SubmitBtn.click();
				Thread.sleep(2000);
				System.out.println("New Comment added");
			}
			public void verifyEditComment() throws InterruptedException
			{
				ReadMorebtn.click();
				Thread.sleep(5000);
				Textbox.sendKeys("Test11");
				Thread.sleep(5000);
				SubmitBtn.click();
				Thread.sleep(5000);
				System.out.println("New Comment added");
			}
			
		

}
