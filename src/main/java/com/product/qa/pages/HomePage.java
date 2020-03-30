package com.product.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.product.qa.base.TestBase;

public class HomePage extends TestBase {

	
	   @FindBy(xpath = "//a[@class=\"navbar-brand active\"]//img")
	   WebElement MzLogo;
	   
	   @FindBy(xpath = "//a[text()=\"Dashboard\"]")
	   WebElement DashboardLink;
	   
	   @FindBy(xpath = "//a[text()=\"Courses\"]")
	   WebElement CoursesLink;
	   
	   @FindBy(xpath = "//a[text()=\"Events\"]")
	   WebElement EventsLink;
	   
	   public HomePage() {
		   PageFactory.initElements(driver, this);
	   }
	   
	   public String VerifyHomepageTitle()  {
		   
		   return driver.getTitle();
	   }
	   
	   public boolean VerifyMzLogo() throws InterruptedException {
		   Thread.sleep(5000);
		 return MzLogo.isDisplayed();
	   }
	   public DashboardPage ClickOnDashboardLink() {
		   DashboardLink.click();
		   return new DashboardPage();
	   }
	   
	   public CoursesPage ClickOnCoursesLink() {
		   CoursesLink.click();
		   return new CoursesPage();
	   }
	   
	   
	   public EventsPage ClickOnEventsLink() {
		   EventsLink.click();
		   return new EventsPage();
	   }
}
