package com.certificates.Programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class program {
	
	
	public static String browser = "firefox";
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("chrome") == true) {
			
			//headless browser
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOption  = new ChromeOptions();
			chromeOption.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(chromeOption);
			
		} else if (browser.equals("firefox") == true) {
			
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOption = new FirefoxOptions();
			firefoxOption.setAcceptInsecureCerts(false);
			driver = new FirefoxDriver(firefoxOption);
			
		} else if (browser.equals("IE") == true) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.navigate().to("https://expired.badssl.com/");
		
		
		
	}

}
