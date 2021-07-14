package com.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener extends Testclass implements ITestListener {

	public void onTestStart(ITestResult result) {

		System.out.println("onTeststart the browser-----" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {

	System.out.println("onTestsuccess resuls ----"+result.getName());

	}

	public void onTestFailure(ITestResult result) {

		//capture screen shoot program
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(":", "_") + ".jpg";
		File screenshoot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshoot, new File(".//screenshoot//"+filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("Test Skipped ---" + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("Failed but with success percentage ---" + result.getName());

	}

	public void onStart(ITestContext result) {

		System.out.println("onstart the browser ---" + result.getName());
	}

	public void onFinish(ITestContext result) {

		System.out.println("onfinisg the browser ---" + result.getName());
	}

}
