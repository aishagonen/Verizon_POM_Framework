package com.qa.verizon.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.util.Constants;

public class HomePageTests {

	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public HomePage homePage;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		homePage = new HomePage(driver);				
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: "+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "Title is incorrect");
	}
	
	@Test(priority=2)
	public void clickTest() {
		homePage.moveClick();
	}
	
	@AfterTest
	public void shutDown(){
		basePage.quitBrowser();
	}
	
	
}
