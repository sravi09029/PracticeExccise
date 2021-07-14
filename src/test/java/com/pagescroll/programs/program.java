package com.pagescroll.programs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class program {
	
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		if (browser.equals("chrome") == true) {
			
			//headless browser
			WebDriverManager.chromedriver().setup();
			//ChromeOptions chromeOption = new ChromeOptions();
			//chromeOption.addArguments("headless");
			driver = new ChromeDriver();
			
		} else if (browser.equals("firefox") == true) {
			
			WebDriverManager.firefoxdriver().setup();
			//FirefoxOptions firefoxOption = new FirefoxOptions();
			//firefoxOption.setHeadless(true);
			driver = new FirefoxDriver();
			
		} else if (browser.equals("IE") == true) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.navigate().to("https://www.toolsqa.com/selenium-webdriver/selenium-interview-questions-part-1/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		Thread.sleep(6000);
		// This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,1000)");
	
	
	
	
   }

}
