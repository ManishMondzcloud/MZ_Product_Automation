package com.product.qa.pages;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.product.qa.base.TestBase;

public class CoursesPage extends TestBase {

	@FindBy(xpath = "//li[@class='nav-item linkmenu']//a[text()='Courses']")
	WebElement CoursesLink;
	
	@FindBy(xpath = "//div[@class='section-title']//h2[text()='Courses']")
	WebElement Courseslabel;
	
	@FindBy(xpath = "//div[@class='section-title']/following::h2[text()='Filters'][2]")
	WebElement FiltersTitle;
	
	@FindBy(xpath="(//div[@id='accordion']//li//a[text()='Business'])[2]")
	WebElement BussinessLink;
	
	@FindBy(xpath="(//div[@id='accordion']//li//a[text()='Design'])[2]")
	WebElement DesignLink;
	
	@FindBy(xpath = "//div[@class='section-title']//h2[text()='Blogs']")
	WebElement BlogsTitle;
	
	@FindBy(xpath = "//div//p[text()='No Courses Found']")
	WebElement LinkDetails;
	
	@FindBy(xpath = "//div[@class='blog-info']//a[text()='View']")
	WebElement ViewLink;
	
	@FindBy(xpath = "//div//h2[text()='Sessions']")
	WebElement Sessions;
	
	
	public CoursesPage() {
		//initializing WebElement
		PageFactory.initElements(driver ,this);
	}
	
	
	public boolean VerifyCoursesLabel() {
		return Courseslabel.isDisplayed();
	}
	
	
	
	public CoursesPage ValidateFilterLinks() throws InterruptedException {
		  
		List<WebElement>  FilterLinks = driver.findElements(By.xpath("//div[@id='accordion']//li//a"));
		  System.out.println(FilterLinks.size());
		
		  for(int i=8; i<FilterLinks.size();i++) {
		         FilterLinks.get(i).click();
		         Thread.sleep(10000);
		         //System.out.println(i+"--" + LinkDetails);
		         //System.out.println(i+"--" + LinkDetails.toString().contains("Proxy"));
				
		         if(!LinkDetails.toString().contains("Proxy") && LinkDetails.getText().equalsIgnoreCase("No Courses Found") ) {
		        	 //Thread.sleep(5000);
		        	 Assert.assertTrue(LinkDetails.isDisplayed(),"Courses Found");
		        	 System.out.println("Course Not Found");
		         }
		         else{
			
		        	 //List<WebElement> ListViewlink= driver.findElements(By.xpath("//div[@class='blog-info']//a[text()='View']"));
		        	 //Thread.sleep(5000);
			
		        	 Assert.assertTrue(ViewLink.isDisplayed(),"No Courses Found");
		        	 System.out.println("Courses Found");
			
		         }	
		  }
		return new CoursesPage();
		
		}
	
	public void VerifyCourses(String session) throws InterruptedException {
		WebElement ListViewlink = driver.findElement(By.xpath("//div[@class='blog-info']//a[text()='View']"));
			//for(int j=0; j<ListViewlink.size();j++) {
		boolean ismatch=false;		
		Thread.sleep(5000);
		ListViewlink.click();
		Thread.sleep(5000);
		List<WebElement> SessionList=driver.findElements(By.xpath("//div[@class='card-header collapsed']//a[@class=\"card-title font-weight-bold\"]"));
				for(int k=0; k<SessionList.size();k++) {
						//System.out.println(SessionList.get(k).getText());
					//	System.out.println(session);
						if(session.equalsIgnoreCase(SessionList.get(k).getText())) {
							System.out.println("Matched");
							ismatch=true;
							break;
							}
					}
						if(!ismatch) {
							Assert.fail();
							}
					
					
					/*
		 * Thread.sleep(5000); CoursesLink.click();
		 * 
		 * 
		 * WebElement ListViewLink2= driver.findElement(By.xpath(
		 * "//div[@class='course-head']/following::div[@class='blog-info'][2]//a[text()='View']"
		 * )); WebElement element = ListViewLink2; JavascriptExecutor executor =
		 * (JavascriptExecutor)driver; executor.executeScript("arguments[0].click();",
		 * element);
		 * 
		 * // ListViewLink2.click(); Thread.sleep(5000);
		 * //Assert.assertTrue(Sessions.isDisplayed(),"No Courses Found");
		 * List<WebElement> SessionList2=driver.findElements(By.
		 * xpath("//div[@class='card-header collapsed']//a[@class=\"card-title font-weight-bold\"]"
		 * )); for(int p=0; p<SessionList2.size();p++) {
		 * System.out.println(SessionList2.get(p).getText()); }
		 */			
		}
			
		//return new CoursesPage();
	//}
	
}
