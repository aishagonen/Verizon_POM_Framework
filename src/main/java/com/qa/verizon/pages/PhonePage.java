package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.Constants;
import com.qa.verizon.util.ElementUtil;
import com.qa.verizon.util.JavaScriptUtil;

public class PhonePage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	HomePage homePage;
	SmartphonesPage smartphonesPage;
	WebDriverWait wait;
	
	By color = By.xpath("//div[@class='container-fluid pdp-main-container clearFixBanner noPad']//div[@class='row noSideMargin']//div[3]//div[1]");
	By storage = By.xpath("//p[contains(text(),'256GB')]");
	By payment = By.xpath("//div[@class='col-sm-12 noSidePad fontSize_16 fontDSStd-75Bd textAlignLeft contractDetail']//span[contains(text(),'$849.99')]");
	By continueBtn = By.xpath("//button[@id='ATC-Btn']");
	By zipcode = By.id("zipcode");
	By confirmBtn = By.xpath("//button[contains(@class,'defaultPrimaryCTA')]");
	By newCustomer = By.xpath("//button[@class='modalButton fontSize_12 NHaasDS55Rg background_FF onlyRightMargin margin8']");
		
	
	public PhonePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		homePage = new HomePage(driver);
		smartphonesPage = new SmartphonesPage(driver);
	}
	
	public CartPage goPage() {
		return new CartPage(driver);
	}
	
	public void verifyTitle() {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(Constants.PHONE_PAGE_TITLE));
		String title = driver.getTitle();
		Assert.assertEquals(title, Constants.PHONE_PAGE_TITLE, "Title is incorrect");	
	}
	
	public void selectPhone() {
		elementUtil.clickOn(color);
		elementUtil.clickOn(storage);
		elementUtil.clickOn(payment);
		elementUtil.clickOn(continueBtn);	
	}
	
	public void enterZipcode() {
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(zipcode)).clear();
		elementUtil.sendKeys(zipcode, "45040" );
		elementUtil.waitForElementClickable(confirmBtn);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newCustomer));
		elementUtil.waitForElementClickable(newCustomer);	
	}
	
	
}
