package com.product.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

	@FindBy(xpath="//a[@class='nav-link active active']")
	@CacheLookup
	WebElement DashboardLink;
	
	@FindBy(xpath="//div[@class='container']//div[1]//div[1]//div[2]//div[1]//a[1]")
	WebElement StartBtn;
	
	@FindBy(xpath="//div[@class='row']//div[2]//div[1]//div[2]//div[1]//a[1]")
	WebElement ResumeBtn;
	
	@FindBy(xpath="//h2[contains(text(),'Learning Paths')]")
	WebElement LearningPathLabel;
	
	@FindBy(xpath="//h2[contains(text(),'Upcoming Events')]")
	WebElement upcomingEventsLabels;
	
	
	@FindBy(xpath="//a[contains(text(),'Javascript')]")
	WebElement eventsName;
	
	@FindBy(xpath="//section[4]//div[1]//div[3]//div[1]//a[1]")
	WebElement EventsViewAllBtn;
	
	@FindBy(xpath="//h2[contains(text(),'Latest Blogs')]")
	WebElement LatestblogsLabel;
	
	@FindBy(xpath="//a[contains(text(),'Future Opportunities in Android App De...')]")
	WebElement AndroidAppBlogs;
	
	@FindBy(xpath="//body/div[@id='root']/div/div/div/section[5]/div[1]/div[3]/div[1]/a[1]")
	WebElement BlogsViewAllBtn;
	
	
	
	
	
}
