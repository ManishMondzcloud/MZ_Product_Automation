package com.product.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

	@FindBy(xpath="//li[@class='nav-item linkmenu']/a[text()='Dashboard']")
	@CacheLookup
	WebElement DashboardLink;
	
	
}
