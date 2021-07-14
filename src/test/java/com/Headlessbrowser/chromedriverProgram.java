package com.Headlessbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.errorprone.annotations.ForOverride;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chromedriverProgram {

	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("chrome") == true) {
			
			//headless browser
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOption = new ChromeOptions();
			chromeOption.addArguments("headless");
			driver = new ChromeDriver(chromeOption);
			
		} else if (browser.equals("firefox") == true) {
			
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOption = new FirefoxOptions();
			firefoxOption.setHeadless(true);
			driver = new FirefoxDriver(firefoxOption);
			
		} else if (browser.equals("IE") == true) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.navigate().to("http://google.com");

		String current_title = driver.getCurrentUrl();
		System.out.println(current_title);

		String title = driver.getTitle();
		System.out.println(title);
	}

}
