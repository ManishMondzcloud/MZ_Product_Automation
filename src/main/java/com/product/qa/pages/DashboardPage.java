package com.product.qa.pages;


//import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.product.qa.base.TestBase;

import junit.framework.Assert;

 public class DashboardPage extends TestBase
 {

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
	WebElement JavaScripteventsName;
	
	@FindBy(xpath="//section[4]//div[1]//div[3]//div[1]//a[1]")
	WebElement EventsViewAllBtn;
	
	@FindBy(xpath="//h2[contains(text(),'Latest Blogs')]")
	WebElement LatestblogsLabel;
	
	@FindBy(xpath="//a[contains(text(),'Future Opportunities in Android App De...')]")
	WebElement AndroidAppBlogs;
	
	@FindBy(xpath="//section[@class='latest-blogs']//a[@class='blue-btn w-100']")
	WebElement BlogsViewAllBtn;
	
	@FindBy(xpath="//a[@class='latst-add-block latest-courses']//h2")
	WebElement coursesCount;
	
	@FindBy(xpath="//a[@class='latst-add-block new-blogs animated']//h2")
	WebElement BlogsCount;
	
	@FindBy(xpath="//a[@class='latst-add-block new-events animated']//h2")
	WebElement eventCount;
	
	@FindBy(xpath = "//li[@class='nav-item linkmenu']//a[text()='Courses']")
	@CacheLookup
	WebElement CoursesLink;
	
	@FindBy(xpath="//a[@class='nav-link'][contains(text(),'Events')]")
	WebElement EventsTab;
	
	@FindBy(xpath="//a[contains(text(),'Blog')]")
	WebElement BlogsLink;
	
	
	//Create Constructor for Initialize the webElements
	public DashboardPage() {
		//Initializing WebElements 
		PageFactory.initElements(driver,this);
	}
	
	
	public void verifyCoursesCount() throws InterruptedException
	{
	// Counting course on dashboard
		Thread.sleep(9000);
		WebElement countCourse= driver.findElement(By.xpath("//a[@class='latst-add-block new-blogs animated']//h2"));
		String actual=countCourse.getText();
		int n1= Integer.parseInt(actual);
		System.out.println("Courses count on dashboard=" + n1);
		
	//Counting course on courses page
		CoursesLink.click();
		Thread.sleep(4000);
		List<WebElement> m1= driver.findElements(By.xpath("//a[@class='blue-btn']"));
		int n2=m1.size();
		System.out.println("Courses available on course page =" + n2);
		Assert.assertEquals(n1,n2);
		
		
	}
	
	public void verifyBlogsCount() throws InterruptedException
	{
	// Counting blogs on dashboard
		Thread.sleep(9000);
		WebElement countCourse= driver.findElement(By.xpath("//a[@class='latst-add-block latest-courses']//h2"));
		String actual=countCourse.getText();
		int n1= Integer.parseInt(actual);
		System.out.println("Blogs count on dashboard=" + n1);
		
	//Counting blogs on blogs page
		BlogsLink.click();
		Thread.sleep(4000);
		List<WebElement> m1= driver.findElements(By.xpath("//a[@class='blue-btn']"));
		int n2=m1.size();
		System.out.println("Blogs available on blogs page =" + n2);
		Assert.assertEquals(n1,n2);
		
	}
	
	public void verifyEventsCount() throws InterruptedException
	{
	// Counting events on dashboard
		Thread.sleep(9000);
		WebElement countCourse= driver.findElement(By.xpath("//a[@class='latst-add-block new-events animated']//h2"));
		String actual=countCourse.getText();
		int n1= Integer.parseInt(actual);
		System.out.println("Events count on dashboard=" + n1);
		
	//Counting events on events page
		EventsTab.click();
		Thread.sleep(4000);
		List<WebElement> m1= driver.findElements(By.xpath("//a[@class='blue-btn']"));
		int n2=m1.size();
		System.out.println("Events available on events page =" + n2);
		Assert.assertEquals(n1,n2);
		
	}
	
	public boolean verifyLearningPathLabel()
	{
		return LearningPathLabel.isDisplayed();
	}

//Verifying the resume button
	
	public void verifyResumeCourse() throws InterruptedException
	{
		ResumeBtn.click();
		Thread.sleep(3000);
		driver.getPageSource().contains("Course Content");
		System.out.println("Resume button work properly");
	}
//Verify start button
	
	public void verifyStartCourse() throws InterruptedException
	{
		StartBtn.click();
		Thread.sleep(3000);
		driver.getPageSource().contains("Course Content");
		System.out.println("Start button work properly");
	}
	
	public boolean verifyUpcomingEventlabel()
	{
		return upcomingEventsLabels.isDisplayed();
	}
	
//Verify single javascript event open	
	public void verifyEventOpen() throws InterruptedException
	{
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Javascript')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		Thread.sleep(9000);
		System.out.println("Event is open");
		
	}
	
//verify all events open through view all button
	public void verifyEventViewAllBtn() throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath("//section[4]//div[1]//div[3]//div[1]//a[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		Thread.sleep(9000);
		System.out.println("View All events button working fine");
	}
	
	public boolean verifyLettestBlogsLabel()
	{
		return LatestblogsLabel.isDisplayed();
	}
	
// verify a single blog open
	public void verifyBlogOpen() throws InterruptedException
	{
		Thread.sleep(6000);
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Future Opportunities in Android App De...')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		Thread.sleep(9000);
		System.out.println("Blogs is open");
	}
	
//verify all blogs open through view all button
	public void verifyBlogsViewAllBtn() throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath("//section[@class='latest-blogs']//a[@class='blue-btn w-100']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		Thread.sleep(9000);
		System.out.println("View All blogs button working fine");
	}
	
	
	
}
