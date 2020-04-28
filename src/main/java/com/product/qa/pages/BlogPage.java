package com.product.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.apphosting.utils.config.ApplicationXml.Modules.Web;
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
	
	@FindBy(xpath = "//p[contains(text(),'Javascript')]")
	WebElement JavaScriptRelaterEvent;
	
	@FindBy(xpath="//a[contains(text(),'Android Development')]")
	WebElement AndroidDevelopmentTags;
	
	@FindBy(xpath="//textarea[@id='message']")
	WebElement Textbox;
	
	@FindBy(xpath="//button[@class='mt-4 btn btn-primary']")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//a[contains(text(),'Read more comments')]")
	WebElement ReadMoreLink;
	
	@FindBy(xpath="//button[1][@id='edit']")
	WebElement EditBtn;
	
	@FindBy(xpath = "//p[text()='Please Edit Your Comment:']/following::textarea")
	WebElement commentTextBox;
	
	@FindBy(xpath = "//button[text()='Submit' and @class='btn btn-primary btn-space-right']")
	WebElement EditBoxSubmitBtn;
	
	@FindBy(xpath="//button[text()='Yes']")
    WebElement YesBtnDoyouWantToEdit;
	
	@FindBy(xpath="//button[text()='No']")
    WebElement NoBtnDoyouWantToEdit;
   
	@FindBy(xpath="//div[@class='5ea5474dbb352818dc762b7c']//button[2]")
	WebElement DeleteComment;
	@FindBy(xpath="//button[@class='btn-danger btn btn-secondary' and text()='Delete']")
	WebElement DoyouWantToDeleteYesBtn;
	
	@FindBy(xpath="//p[@class='comment-error']")
	WebElement AbuseWordsError;
	
	
	//Create Constructor for Initialize the webElements
			public BlogPage() {
				//Initializing WebElements
				PageFactory.initElements(driver,this);
			}
			
						
			public boolean verifyBlogsLabel() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				Thread.sleep(2000);
				return BlogsLabel.isDisplayed();
			}
			
			public void verifyBlogOpenByLink() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				
				Thread.sleep(2000);
				AndroidAppDevelopmentBlogs.click();
				Thread.sleep(3000);
				System.out.println("Blog open by link");
			}
			
			public void verifyReadMoreBtn() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				
				Thread.sleep(2000);
				ReadMorebtn.click();
				Thread.sleep(3000);
				System.out.println("Blogs open by read more button");
			}
			public void verifyRelatedCourseOpen() throws InterruptedException, AWTException
			{
				
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				Thread.sleep(10000);
				ReadMorebtn.click();
				Thread.sleep(10000);
				AndroidRelatedCourse.click();
				Thread.sleep(10000);
				System.out.println("Related course open");
				
			}
			public void verifyRelatedEventsOpen() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				Thread.sleep(10000);
				ReadMorebtn.click();
				Thread.sleep(10000);
				JavascriptExecutor js= (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", JavaScriptRelaterEvent);
				Thread.sleep(10000);
				System.out.println("Related Event open");
				
			}
			public void verifyTagsOpen() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				Thread.sleep(10000);
				ReadMorebtn.click();
				Thread.sleep(10000);
				JavascriptExecutor js= (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", AndroidDevelopmentTags);
				Thread.sleep(4000);
				//AndroidDevelopmentTags.click();
				WebElement element1 = driver.findElement(By.xpath("//a[contains(text(),'Android Development')]"));
				JavascriptExecutor executor1= (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element1);
				
				Thread.sleep(10000);
				System.out.println(" Android appdevelopment tag open");
			}
			
			public void verifyAddingComment() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				Thread.sleep(5000);
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
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				
				Thread.sleep(5000);
				ReadMorebtn.click();
				Thread.sleep(5000);
				JavascriptExecutor js= (JavascriptExecutor)driver;
				//js.executeScript("window.scrollBy(0,1000)");
				js.executeScript("arguments[0].click();", EditBtn);
				
				//WebElement element = driver.findElement(By.xpath("//button[@id='edit'][1]")); 
				//Actions actions = new Actions(driver);
				//actions.moveToElement(element).click().perform();
	            //EditBtn.click();
				Thread.sleep(5000);
				commentTextBox.sendKeys("Edited Text");
				Thread.sleep(5000);
				EditBoxSubmitBtn.click();
				Thread.sleep(5000);
				YesBtnDoyouWantToEdit.click();
				System.out.println("Comment Edited");
			}
			
			public void verifyDeletComment() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				
				Thread.sleep(5000);
				ReadMorebtn.click();
				Thread.sleep(5000);
				JavascriptExecutor js= (JavascriptExecutor)driver;
				//js.executeScript("window.scrollBy(0,1000)");
				js.executeScript("arguments[0].click();", DeleteComment);
				
				//WebElement element = driver.findElement(By.xpath("//button[@id='edit'][1]")); 
				//Actions actions = new Actions(driver);
				//actions.moveToElement(element).click().perform();
	            //EditBtn.click();
				
				Thread.sleep(5000);
				DoyouWantToDeleteYesBtn.click();
				System.out.println("Comment Deleted");

				
			}
			
			public void verifyAbuseWords() throws InterruptedException
			{
				
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				
				Thread.sleep(5000);
				ReadMorebtn.click();
				Thread.sleep(3000);
				Textbox.sendKeys("Fuck");
				Thread.sleep(2000);
				SubmitBtn.click();
				Thread.sleep(2000);
				String s1=AbuseWordsError.getText();
				Assert.assertEquals(s1,"Your comment contains abusive words please remove them to proceed");
				Thread.sleep(2000);
				System.out.println("Waring message displayed");
				
			}
			

}
