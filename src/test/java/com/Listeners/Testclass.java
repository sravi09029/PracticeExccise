package com.Listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(com.Listeners.Listener.class)
public class Testclass {

	public static String browser = "chrome";
	public static WebDriver driver;

	@BeforeTest
	public void openbrowser() {

		if (browser.equals("chrome")== true) {

			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")== true) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equals("IE")== true) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		// maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
	}

	@Test(priority=1)
	public void VerifyTitle() throws InterruptedException {

		driver.get("https://www.ajio.com/login");
		String actual_title = driver.getTitle();
		System.out.println(actual_title);

		String expected_title = "AJIO";

		if (actual_title.equals(expected_title) == true) {

			System.out.println("Title Test is passed");
		} else {

			System.out.println("Title test is failed");
		}
	}

	@Test(priority=2)
	public void enterUsername() {

		// verify username text
		boolean UN = driver.findElement(By.name("usename")).isDisplayed();

		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("sampathiravikumar@gmail.com");

	}

	@Test(priority=3)
	public void clickOnContinue() {
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(6000);
		driver.close();
	}
}
