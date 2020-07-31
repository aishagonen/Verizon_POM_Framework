package com.qa.verizon.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.pages.SmartphonesPage;

public class SmartphonesPageTest {

	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public HomePage homePage;
	public SmartphonesPage smartphonesPage;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		homePage = new HomePage(driver);
		smartphonesPage = homePage.getPage();	
	}
	
	@Test(priority=1) 
	public void Test1() {
		smartphonesPage.goPageGetPhone();
	}
	
	@Test(priority=2) 
	public void Test2() {
		smartphonesPage.verifyTitle();
	}
	
	@AfterTest
	public void shutDown(){
		basePage.quitBrowser();
	}
	
	
	
}
