 package com.product.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;





public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {

		try {
			// create an object reference for properties class.
			prop = new Properties();
			// By using fileInputStream we have to give Path of config.properties file
			// fileInputStream making a Streaming between your java code and
			// config.properties file.
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Rushikesh Chauhan\\Documents\\MZProduct\\MZ\\src\\main\\java\\com\\product\\qa\\config\\config.properties");
			try {
				// Load all the properties which are available in config.properties file.
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
    
	public static void initialization() throws InterruptedException {
		// by using getProperty we are using the value of 'browser' from
		// config.properties file.
		// and saving into String Variable 'browserName'.
		// we have to use exact name('browser') to pass which are mentioned in the
		// config file.

		String browserName = prop.getProperty("Browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			// set the path for ChromeDriver
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			// Create object for ChromeDriver

			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
			//		"--ignore-certificate-errors", "--silent");
			driver = new ChromeDriver();

		} else if (browserName.equals("edge")) {
			// Set the path for EdgeDriver
			System.setProperty("webdriver.edge.driver",
					"C:\\Project\\Crm\\PortfolioCRMTest\\driver\\MicrosoftWebDriver.exe");
			// Create Object for EdgeDriver
			driver = new EdgeDriver();
		}

		

		// Maximize the window
		driver.manage().window().maximize();
		// Delete all Cookies
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
}
}
