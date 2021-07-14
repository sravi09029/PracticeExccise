package com.ExtentReports;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.MacroDef.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class reportsClass {

	public WebDriver driver;
	public static String browser = "chrome";

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void setExtent() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Reporter");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "localhost");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Tester Name", "Ravikumar");
		extent.setSystemInfo("Browser", "Chrome");

	}

	@AfterTest
	public void endReport() {
		
		extent.flush();
	}

	@BeforeMethod
	public void openbrowser() {

		if (browser.equals("chrome") == true) {

			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox") == true) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equals("IE") == true) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		// maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		driver.get("https://www.ajio.com/login");
	}

	@Test(priority=1)
	public void VerifyTitle() throws InterruptedException {

		test = extent.createTest("VerifyTitle");
		String actual_title = driver.getTitle();
		System.out.println(actual_title);
		Assert.assertEquals(actual_title, "AJIO");
	}

	@Test(priority=2)
	public void verifUserNameText() {

		test = extent.createTest("verifUserNameText");
		boolean username = driver.findElement(By.xpath("//input[@name='username']")).isDisplayed();
		Assert.assertTrue(username);	
	}
	
	@Test(priority=3)
	public void clickonContinue() {
		
		test = extent.createTest("clickonContinue");
		boolean contine =driver.findElement(By.xpath("//input[@value='Continue']")).isDisplayed();
		Assert.assertTrue(contine);
		
		driver.findElement(By.xpath("//input[@value='Contnue']")).click();
		
	}
	
	

	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "test case failed is  " + result.getName());
			test.log(Status.FAIL, "test case failed is  " + result.getThrowable());

			String screenshootpath = reportsClass.getScreenShoot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshootpath);
			
		} else if (result.getStatus() == ITestResult.SKIP) {

			test.log(Status.SKIP, "test case skipped  is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(Status.PASS, "Test Case Passed is " + result.getName());
		}
		
		driver.close();
		driver.quit();

	}

	public static String getScreenShoot(WebDriver driver, String screenhotName){

		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(":", "_") + ".jpg";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty(("user.dir"), ".//screenshoot//"+ screenhotName +filename);
		File finaidestination = new File(destination);
		try {
			FileUtils.copyFile(source, finaidestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;

	}

}
