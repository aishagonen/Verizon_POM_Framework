package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.Constants;
import com.qa.verizon.util.ElementUtil;

public class SmartphonesPage extends BasePage{

	public WebDriver driver;
	public ElementUtil elementUtil;
	public HomePage homePage;
	public SmartphonesPage smartphonesPage;
	
	By element = By.xpath("//div[@id='tile_dev12360040']//div[contains(@class,'NHaasTX75Bd marginBottom5')]//span[1]");
	
	public SmartphonesPage(WebDriver driver) {
		this.driver = driver;
		homePage = new HomePage(driver);
		elementUtil = new ElementUtil(driver);
	}
	
	public PhonePage goPageGetPhone() {
		//homePage.moveClick();
		elementUtil.waitGetElementDefault(element).click();
		return new PhonePage(driver);
	}
	
	public void verifyTitle() {
		//homePage.moveClick();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(Constants.SMARTPHONE_PAGE_TITLE));
		String title =  driver.getTitle();
		Assert.assertEquals(title, Constants.SMARTPHONE_PAGE_TITLE, "Title is incorrect");	
	}
}
