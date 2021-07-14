package com.TestNg.Programs;

import org.junit.BeforeClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class program {

	@BeforeClass
	public void ride_bike() {

		System.out.println("@Beforeclass --- ride the bike");
	}

	@BeforeClass
	public void stopRide() {

		System.out.println("@AfterClass --- stop the ride");
	}

	@BeforeGroups
	public void write_exam() {

		System.out.println("@beforeGrops --- write the exam");
	}

	@AfterGroups
	public void write_stop() {

		System.out.println("@AfterGrops --- stop the exam");
	}

	@BeforeSuite
	public void conectDB() {

		System.out.println("@beforeSuite --- connected DB");
	}

	@AfterSuite
	public void disconnectDB() {

		System.out.println("@AfterSuite --- disconnect DB");
	}
	
	@Test
	public void method() {
		
		System.out.println("@Test ---- Method is started");
	}
	
	
	@Test
	public void method1() {
		
		System.out.println("@Test ---- Method1 is started");
	}

}
