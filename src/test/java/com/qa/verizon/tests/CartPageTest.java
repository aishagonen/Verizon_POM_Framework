package com.qa.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.CartPage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.pages.PhonePage;
import com.qa.verizon.pages.SmartphonesPage;

public class CartPageTest {

	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public HomePage homePage;
	public SmartphonesPage smartphonesPage;
	public PhonePage phonePage;
	public CartPage cartPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		homePage = new HomePage(driver);
		smartphonesPage = homePage.getPage();
		phonePage = smartphonesPage.goPageGetPhone();
		cartPage = phonePage.goPage();
	}
	
	@Test
	public void Test() {	
		System.out.println(cartPage.verifyPhone());	
	}
	
	@AfterMethod
	public void shutDown(){
		basePage.quitBrowser();
	}
		
}
