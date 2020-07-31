package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;
import com.qa.verizon.util.JavaScriptUtil;

public class CartPage extends BasePage {

	public WebDriver driver;
	public ElementUtil elementUtil;
	public HomePage homePage;
	public SmartphonesPage smartphonesPage;
	public PhonePage phonePage;
	public JavaScriptUtil js;

	By deviceInfo1 = By.xpath("//span[contains(text(),'Apple')]");
	By deviceInfo2 = By.xpath("//span[contains(text(),'iPhone 11')]");

	public CartPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		homePage = new HomePage(driver);
		smartphonesPage = homePage.getPage();
		phonePage = new PhonePage(driver);
	}
	
	public void goPage() {
		phonePage.goPage();
		phonePage.selectPhone();
		phonePage.enterZipcode();
	}
	
	public String verifyPhone() {
		String info1 = elementUtil.verifyGetText(deviceInfo1, "Apple");
		String info2 = elementUtil.verifyGetText(deviceInfo2, "iPhone 11");
		String deviceInfo = info1 + " " + info2; 
		return deviceInfo;
	}
	
}
