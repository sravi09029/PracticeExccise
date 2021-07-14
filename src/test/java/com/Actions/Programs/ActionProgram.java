package com.Actions.Programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.inject.Key;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionProgram {

	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		if (browser.equals("chrome") == true) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox") == true) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("IE") == true) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		
		WebElement rightClick = driver.findElement(By.xpath("//button[normalize-space()='Right Click Me']"));
		action.contextClick(rightClick).perform();
		
		String actual_text = driver.findElement(By.xpath("//p[@id='rightClickMessage']")).getText();
		System.out.println("after clicks on the right button text is: "+actual_text);
		
		String expected_text = "You have done a right click";
		
		if(actual_text.equals(expected_text) == true) {
			
			System.out.println("Text is passed");
		} else {
			
			System.out.println("Test is not passed");
		}
		
		
		
		
		
		

	}

}
