package com.product.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.product.qa.base.TestBase;

public class MyEvents extends TestBase{
	
	
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
	
	public MyEvents()
	{
		//Initializing WebElements
		PageFactory.initElements(driver,this);
	}
	public void VerfyEventSubscribe() throws InterruptedException
	{
		EventsTab.click();
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
			Profile.click();
			Thread.sleep(5000);
			Myevents.click();
			Thread.sleep(5000);
			ReactjsEvent.isDisplayed();
			System.out.println("Subscribed event is displayed in MyEvent");
			
	//Unsubscribing the subscribe event 
			EventsTab.click();
			Thread.sleep(5000);
			ReactjsEvent.click();
			Thread.sleep(5000);
			subscribeUnsubscribeBtn.click();
			Yesbtn.click();
			Thread.sleep(5000);
			System.out.println("Event is unsubscribed successful");
			
	//Check Unsubscribe event is removed from myEvent
			
			
			Profile.click();
			Thread.sleep(5000);
			Myevents.click();
			Thread.sleep(5000);
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
			Profile.click();
			Thread.sleep(5000);
			Myevents.click();
			Thread.sleep(5000);
			ReactjsEvent.isDisplayed();
			System.out.println("Subscribed event is displayed in MyEvent");
			
	//Unsubscribe the subscribed event
			EventsTab.click();
			Thread.sleep(5000);
			ReactjsEvent.click();
			Thread.sleep(5000);
			subscribeUnsubscribeBtn.click();
			Yesbtn.click();
			Thread.sleep(5000);
			System.out.println("Event is unsubscribed successful");
			
	//Checking unsubscribe event is removed from MyEvents
			Profile.click();
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
			EventsTab.click();
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
