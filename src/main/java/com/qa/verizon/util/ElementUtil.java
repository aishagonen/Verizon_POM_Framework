package com.qa.verizon.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;

public class ElementUtil extends BasePage{
	
	WebDriver driver;
	
	public ElementUtil(WebDriver driver){
		this.driver = driver;
	}

	public void mouseOverClick(By element, WebElement elementClicked) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement mouseOverAction = driver.findElement(element);
		action.moveToElement(mouseOverAction).click(elementClicked).build().perform();	
	}

	public WebElement waitGetElementDefault(By locator) {	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		return element; 
	}
	
	public void waitForElementClickable(By locator){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public void clickOn(By locator) {
		driver.findElement(locator).click();
	}
	
	public void sendKeys(By locator, String key) {
		driver.findElement(locator).click();
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(key);	
	}
	
	public String  verifyGetText(By locator, String verifyText ) {
		String text = driver.findElement(locator).getText();
		if (text.equals(verifyText)) {
			System.out.println("Text is correct.");
		} else {
			System.out.println("Text is not correct.");
		}
		return text;
	}
	
	
	
	
	
	
	
	
}






















