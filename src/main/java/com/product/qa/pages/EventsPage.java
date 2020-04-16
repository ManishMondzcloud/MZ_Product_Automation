package com.product.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.product.qa.base.TestBase;

public class EventsPage extends TestBase {
	@FindBy(xpath="//a[@class='nav-link'][contains(text(),'Events')]")
	WebElement EventsTab;
	
	@FindBy(xpath="//a[contains(text(),'React JS')]")
	WebElement ReactjsEvent;
	
	@FindBy(xpath="//div[@id='root']//div//div//div//div//section//div//div//div//div//p//a")
	WebElement subscribeUnsubscribeBtn;
	
	@FindBy(xpath="//div[@id='navbarText']//a[@id='userDropdown']/span")
	@CacheLookup
	WebElement Profile;
	
	@FindBy(xpath="//div[@id='navbarText']//ul//li//div//a[contains(text(),'My Events')]")
	WebElement Myevents;
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	WebElement Yesbtn;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	WebElement NoBtn;
	
	@FindBy(xpath = "//div//p[text()='No Courses Found']")
	WebElement LinkDetails;
	
	@FindBy(xpath = "//div[@class='blog-info']//a[text()='View']")
	WebElement ViewLink;
	
	public EventsPage()
	{
		//Initializing WebElements
		PageFactory.initElements(driver,this);
	}
	
	
	public EventsPage ValidateFilterLinks() throws InterruptedException {
		  List<WebElement>  FilterLinks = driver.findElements(By.xpath("//div[@id='accordion']//li//a"));
		  System.out.println(FilterLinks.size());
		
		  for(int i=8; i<FilterLinks.size();i++) {
		         FilterLinks.get(i).click();
		         Thread.sleep(5000);
		         //System.out.println(i+"--" + LinkDetails);
		         //System.out.println(i+"--" + LinkDetails.toString().contains("Proxy"));
				
		         if(!LinkDetails.toString().contains("Proxy") && LinkDetails.getText().equalsIgnoreCase("No Events Found") ) {
		        	 //Thread.sleep(5000);
		        	 Assert.assertTrue(LinkDetails.isDisplayed(),"Events Found");
		        	 System.out.println("Events Not Found");
		         }
		         else{
			
		        	 //List<WebElement> ListViewlink= driver.findElements(By.xpath("//div[@class='blog-info']//a[text()='View']"));
		        	 //Thread.sleep(5000);
			
		        	 Assert.assertTrue(ViewLink.isDisplayed(),"No Events Found");
		        	 System.out.println("events Found");
			
		         }	
		  }
		return new EventsPage();
		
		}
	
	
	
	public void VerfyEventSubscribe() throws InterruptedException
	{
		//EventsTab.click();
		 WebElement element = driver.findElement(By.xpath("//a[@class='nav-link'][contains(text(),'Events')]"));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		
		Thread.sleep(5000);
		ReactjsEvent.click();
		Thread.sleep(5000);
		String  Btntext=subscribeUnsubscribeBtn.getText();
		if(Btntext.equals("Subscribe"))
		{
	// Subscribing the event
			subscribeUnsubscribeBtn.click();
			Thread.sleep(5000);
			Yesbtn.click();
			System.out.println("Event Subscribed");
			Thread.sleep(5000);
			
   //Checking subscribed event in MYEvent
			//Profile.click();
			WebElement element1 = driver.findElement(By.xpath("//div[@id='navbarText']//a[@id='userDropdown']/span"));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element1);
			
			Thread.sleep(5000);
			Myevents.click();
			Thread.sleep(5000);
			ReactjsEvent.isDisplayed();
			System.out.println("Subscribed event is displayed in MyEvent");
			
	//Unsubscribing the subscribe event 
			//EventsTab.click();
			 WebElement element2 = driver.findElement(By.xpath("//a[@class='nav-link'][contains(text(),'Events')]"));
			 JavascriptExecutor executor2 = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element2);
			
			Thread.sleep(5000);
			ReactjsEvent.click();
			Thread.sleep(5000);
			subscribeUnsubscribeBtn.click();
			Yesbtn.click();
			Thread.sleep(5000);
			System.out.println("Event is unsubscribed successful");
			
	//Check Unsubscribe event is removed from myEvent
			
			
			//Profile.click();
			
			WebElement element3 = driver.findElement(By.xpath("//div[@id='navbarText']//a[@id='userDropdown']/span"));
			JavascriptExecutor executor3= (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element3);
			
			Thread.sleep(5000);
			Myevents.click();
			Thread.sleep(5000);
		   // String m1=ReactjsEvent.getText();
			if(driver.getPageSource().contains("React JSS"))
			{
				System.out.println("Event is not removed from my event. Please check ");
			}
			else
			{
				System.out.println("Event is successfully removed from MyEvent");
			}
			
			
		}
  else
		{
	//Checking subscribed event in MyEvents
			//Profile.click();
	    WebElement element4 = driver.findElement(By.xpath("//div[@id='navbarText']//a[@id='userDropdown']/span"));
		JavascriptExecutor executor4= (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element4);
			Thread.sleep(5000);
			Myevents.click();
			Thread.sleep(5000);
			ReactjsEvent.isDisplayed();
			System.out.println("Subscribed event is displayed in MyEvent");
			
	//Unsubscribe the subscribed event
			//EventsTab.click();
			 WebElement element5 = driver.findElement(By.xpath("//a[@class='nav-link'][contains(text(),'Events')]"));
			 JavascriptExecutor executor5 = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element5);
			Thread.sleep(5000);
			ReactjsEvent.click();
			Thread.sleep(5000);
			subscribeUnsubscribeBtn.click();
			Yesbtn.click();
			Thread.sleep(5000);
			System.out.println("Event is unsubscribed successful");
			
	//Checking unsubscribe event is removed from MyEvents
			//Profile.click();
			WebElement element6 = driver.findElement(By.xpath("//div[@id='navbarText']//a[@id='userDropdown']/span"));
			JavascriptExecutor executor6= (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element6);
			
			Thread.sleep(5000);
			Myevents.click();
			Thread.sleep(5000);
		   // String m1=ReactjsEvent.getText();
			if(driver.getPageSource().contains("React JSS"))
			{
				System.out.println("Event is not removed from my event. Please check ");
			}
			else
			{
				System.out.println("Event is successfully removed from MyEvent");
			}
			
	 //Subscribe the event
			//EventsTab.click();
			 WebElement element7 = driver.findElement(By.xpath("//a[@class='nav-link'][contains(text(),'Events')]"));
			 JavascriptExecutor executor7 = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element7);
			Thread.sleep(3000);
			ReactjsEvent.click();
			Thread.sleep(3000);
			String  Btntext1=subscribeUnsubscribeBtn.getText();
			if(Btntext1.equals("Subscribe"))
			{
				subscribeUnsubscribeBtn.click();
				Thread.sleep(3000);
				Yesbtn.click();
				System.out.println("Event Subscribed");
				Thread.sleep(2000);
			}
			else
			{
				System.out.println("Event is not subscribed Please check");
			}
	
		
	}


	}
	}
