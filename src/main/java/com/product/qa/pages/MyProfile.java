package com.product.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.product.qa.base.TestBase;

public class MyProfile extends TestBase{
	
	@FindBy(xpath="//div[@id='navbarText']//ul//li//div//a[contains(text(),'My Profile')]")
	WebElement MyProfileOption;
	
	@FindBy(xpath="//div[contains(text(),'Test Admin')]")
	WebElement FullName;
	
	@FindBy(xpath="//div[contains(text(),'8833445555')]")
	WebElement Phone;
	
	@FindBy(xpath="//div[@id='pills-home']//div//div//div//div[contains(text(),'admin@gmail.com')]")
	WebElement email;
	
	@FindBy(xpath="//div[@id='pills-tabContent']//div[2]//div[2]//div[2]")
	WebElement location;
	
	@FindBy(xpath="//div[contains(text(),'MindZcloud Technologies')]")
	WebElement college;
	
	@FindBy(xpath="//div[contains(text(),'Information Technology')]")
	WebElement Department;
	
	@FindBy(xpath="//body/div[@id='root']/div/div/div/div/div/div/div/div/div[2]/div[2]/div[1]")
	WebElement ContactEmail;
	
	@FindBy(xpath="//div[3]//div[2]//div[1]")
	WebElement contactLocation;
	
	@FindBy(xpath="//body/div/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]")
	WebElement ContactMobile;
	
	@FindBy(xpath="//button[contains(text(),'Choose image')]")
	WebElement chooseimageBtn;
	
	@FindBy(xpath="//a[contains(text(),'Edit Profile')]")
	WebElement Editbwt;
	
	@FindBy(xpath="//*[@id=\"country\"]")
	WebElement state;
	
	@FindBy(xpath="//select[@id='city']")
	WebElement city;
	
	@FindBy(xpath="")
	WebElement UptBwn;
	
	@FindBy(xpath = "//button[contains(text(),'Choose image')]")
	WebElement UploadImage;
	
	//Create Constructor for Initialize the webElements
			public MyProfile() {
				//Initializing WebElements
				PageFactory.initElements(driver,this);
			}
			
			public void ClickOnMyProfileOption() {
				MyProfileOption.click();
			}
			
			public boolean verifyFirstName()
			{
				return FullName.isDisplayed();
			}
			public boolean verifyPhoneNumber()
			{
				return Phone.isDisplayed();
			}
			public boolean verifyEmail()
			{
				return email.isDisplayed();
			}
			public boolean verifyLocation()
			{
				return location.isDisplayed();
			}
			public boolean verifyCollege()
			{
				return college.isDisplayed();
			}
			public boolean verifyDept()
			{
				return Department.isDisplayed();
			}
			public boolean verifyContactMobile()
			{
				return ContactMobile.isDisplayed();
			}
			public boolean verifyContactEmail()
			{
				return ContactEmail.isDisplayed();
			}
			public boolean verifyContactLocation()
			{
				return contactLocation.isDisplayed();
			}
			
			public void UpdateProfile() throws InterruptedException, AWTException
			{
				Editbwt.click();
				Thread.sleep(5000);
				chooseimageBtn.click();
				Thread.sleep(5000);
				
			//Uploading image
				Robot r= new Robot();
				r.setAutoDelay(5000);
				StringSelection s= new StringSelection("C:\\img_1.jpg");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_V);
				r.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(10000);
				System.out.println("Profile Image Selected");
				
			//Selecting states
				Select s1= new Select(state);
				s1.selectByVisibleText("Maharashtra");
				System.out.println("Maharashtra state selected");
				Select s2= new Select(city);
				Thread.sleep(2000);
				s2.selectByVisibleText("Akola");
				System.out.println("City is state selected");
				UptBwn.click();
				Thread.sleep(10000);
				System.out.println("Profile Updated Successfuly");
				
					
			}
	
			
	

}
