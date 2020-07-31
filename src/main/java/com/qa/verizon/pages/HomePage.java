package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class HomePage extends BasePage{

	public WebDriver driver;
	public ElementUtil elementUtil;
	
	By phones = By.xpath("//button[contains(text(),'Phones list')]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public WebDriver moveClick() {
		WebElement smarty = driver.findElement(By.id("thirdLevel00"));	
		elementUtil.mouseOverClick(phones, smarty);
		return driver;
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public SmartphonesPage getPage() {
		return new SmartphonesPage(driver);
	}
	
}
