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
	
	@FindBy(partialLinkText = "Future Opportunities")
	WebElement AndroidAppCourse;
	
	@FindBy(xpath="//time[contains(text(),'09 Jan 2020')]")
	WebElement OuterDate;
	
	@FindBy(xpath="//div[@class='blog-info']//div[@class='blog-info']//a[@class='blue-btn'][contains(text(),'Read More')]")
	WebElement ReadMorebtn;
	
	@FindBy(xpath="//p[contains(text(),'Android Development')]")
	WebElement AndroidRelatedCourse;
	
	@FindBy(xpath="//time[contains(text(),'09 Jan 2020')]")
	WebElement innerDate;
	
	@FindBy(xpath="//a[contains(text(),'Android Development')]")
	WebElement tags;
	
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
			
			public boolean VerifyBlogsLabel() {
				return BlogsLabel.isDisplayed();
			}
			
			
				

}
