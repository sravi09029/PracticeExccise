package com.TestNg.Programs;

import org.junit.BeforeClass;
import org.testng.SkipException;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnatonsPrograms {
	
	
	@BeforeSuite
	public void conectDB() {
		
		System.out.println("@beforeSuite --- connected DB");
	}
	
	@AfterSuite
	public void disconnectDB() {
		
		System.out.println("@AfterSuite --- disconnect DB");
	}
	
	
	@BeforeTest
	public void conectLP() {
		
		System.out.println("@beforeTest --- connect LP");
	}
	
	@AfterTest
	public void disconnectLP() {
		
		System.out.println("@AfterTest --- Disconect Lp");
	}
	
	@BeforeGroups
	public void write_exam() {
		
		System.out.println("@beforeGrops --- write the exam");
	}
	
	@AfterGroups
	public void write_stop() {
		
		System.out.println("@AfterGrops --- stop the exam");
	}
	
	@BeforeClass
	public void ride_bike() {
		
		System.out.println("@Beforeclass --- ride the bike");
	}
	
	@BeforeClass
	public void stopRide() {
		
		System.out.println("@AfterClass --- stop the ride");
	}
	
	@BeforeMethod
	public void start_bike() {
		
		System.out.println("@BeforeMethod --- start the bike");
	}
	
	@AfterMethod
	public void stop_bike() {
		
		System.out.println("@AfterMethod --- stop the bike");
	}
	
	
	@Test(priority=1, groups = {"demo"})
	public void method1() {
		
		System.out.println("@Test ---- Method1 is started");
	}
	
	
	@Test(priority=1, groups = {"demo"}, dependsOnMethods = {"method1"})
	public void method() {
		
		System.out.println("@Test ---- Method is started");
	}
	

}
