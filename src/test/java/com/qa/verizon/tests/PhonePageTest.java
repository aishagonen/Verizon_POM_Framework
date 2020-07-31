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
import com.qa.verizon.pages.PhonePage;
import com.qa.verizon.pages.SmartphonesPage;

public class PhonePageTest {
	
	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public HomePage homePage;
	public SmartphonesPage smartphonesPage;
	public PhonePage phonePage;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		homePage = new HomePage(driver);
		smartphonesPage = homePage.getPage();
		phonePage = smartphonesPage.goPageGetPhone();
	}
		
	@Test(priority=1) 
	public void Test2() {
		phonePage.verifyTitle();
	}
	
	@Test(priority=2) 
	public void Test3() {
		phonePage.goPage();
		phonePage.selectPhone();
		phonePage.enterZipcode();
	}
		
	@AfterTest
	public void shutDown(){
		basePage.quitBrowser();
	}
	
}
