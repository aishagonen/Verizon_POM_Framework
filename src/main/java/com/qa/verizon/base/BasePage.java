package com.qa.verizon.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initialize_driver(Properties prop) { 	
		String browser = prop.getProperty("browser");
		String headless = prop.getProperty("headless");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "/Users/aishagonen/Documents/Drivers/chromedriver"); 
			if(headless.equals("yes")){
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} 
			else{
				driver = new ChromeDriver();
			}
		} else if (browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver","/Users/aishagonen/Documents/Drivers/geckodriver");
			if(headless.equals("yes")){
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("--headless");
				driver = new FirefoxDriver(fo);
			} else{
				driver = new FirefoxDriver();
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));	
		return driver;
	}
		
		public Properties initialize_properties(){
			prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream("/Users/aishagonen/eclipse-workspacep/Verizon_Pom/src/main/java/com/qa/verizon/config/config.properties");
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return prop;	
		}
	
		public void quitBrowser() {
			try {
				driver.quit();
			} catch (Exception e) {
				System.out.println("Some exception occured while quitting the browser.");
			}
		}
		
		public void closeBrowser() {
			try {
				driver.close();
			} catch (Exception e) {
				System.out.println("Some exception occured while closing the browser.");
			}
		}	
		
		
}
