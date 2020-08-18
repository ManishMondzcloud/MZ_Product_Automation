package com.product.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.product.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	 private static final Logger logger = LogManager.getLogger(LoginPage.class);

	@FindBy(xpath = "//div//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//div//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//div//button[@type='submit']")
	WebElement loginBtn;
	@FindBy(xpath="//img[@class=\"logo1\"]")
	WebElement MzLogo;
	
	@FindBy(xpath="//button[@id='unblocked-allow']")
	WebElement PopUpContinueBtn;
	
	
	@FindBy(xpath="//button[@id='onesignal-slidedown-allow-button']")
	WebElement popUpAllow;
	
	@FindBy(xpath="//button[@id='onesignal-slidedown-cancel-button']")
	WebElement Nothanks;
	 
	
	@FindBy(xpath="//*[name()='path' and contains(@fill,'currentCol')]")
	WebElement CloseGuide;
	
	
	
	
	//Create Constructor for Initialize the webElements
		public LoginPage() {
			//Initializing WebElements
			PageFactory.initElements(driver,this);
		}
		
		public String ValidateLoginpageTitle() throws InterruptedException {
			Thread.sleep(5000);
			return driver.getTitle();
			
		}
		
		public boolean ValidateMzLogo() throws InterruptedException {
			Thread.sleep(5000);
			return MzLogo.isDisplayed();
		
		}
		
		
		public HomePage login() throws InterruptedException, AWTException {
			email.sendKeys(prop.getProperty("username"));
			logger.info("---------Send User Name -------------");
			password.sendKeys(prop.getProperty("password"));
			logger.info("---------Send Password -------------");
			loginBtn.click();
			logger.info("---------Click on login button-------------");
			Thread.sleep(15000);
		
			
			// Allowing the notification pop-up
		
		
		
		/*
		 * String MainWindow=driver.getWindowHandle();
		 * 
		 * // To handle all new opened window. Set<String> s1=driver.getWindowHandles();
		 * Iterator<String> i1=s1.iterator();
		 * 
		 * while(i1.hasNext()) { String ChildWindow=i1.next();
		 * 
		 * if(!MainWindow.equalsIgnoreCase(ChildWindow)) {
		 * 
		 * //Switching to Child window driver.switchTo().window(ChildWindow);
		 * Thread.sleep(8000); //System.out.println("switched to child window");
		 * PopUpContinueBtn.click(); //System.out.println("Click on Continue button");
		 * Thread.sleep(4000); Robot robot = new Robot(); robot.delay(3000);
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyPress(KeyEvent.VK_TAB);
		 * Thread.sleep(2000); robot.keyPress(KeyEvent.VK_ENTER); Thread.sleep(5000);
		 * 
		 * 
		 * // Switching to Parent window i.e Main Window.
		 * driver.switchTo().window(MainWindow); Thread.sleep(3000);
		 * //popUpAllow.click(); Nothanks.click(); Thread.sleep(5000);
		 * 
		 * 
		 * 
		 * 
		 * } }
		 * 
		 * 
		 */ 
		  if(CloseGuide.isDisplayed())
	        {
			Thread.sleep(3000);
			CloseGuide.click();
	        }
		       
				Thread.sleep(3000);
				return new HomePage();
		        
				
		}
}
