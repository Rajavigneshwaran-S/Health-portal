package com.AdminPortal.Theecode;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class TestData {
	private WebDriver driver;

	public TestData(WebDriver driver) {
		this.driver = driver;
	}

	@DataProvider(name = "loginData")
	public static Object[][] loginData() {
		// Can fetch test data from a data source (e.g., CSV, Excel, JSON, database)
		// providing static test data...
		return new Object[][] { { "rajavigneshwarans+health-qa-live-test01@theecode.xyz", "Admin@123" },
				{ "rajavigneshwarans+health-qa-test123@theecode.xyz", "Admin@123" },
				// Add more test data sets as needed
		};
	}

	@DataProvider(name = "providerData")
	public static Object[][] providerData() {
		// Similar to the login data, provide test data for the provider page here
		return new Object[][] {
				{ "DemoQATest", "www.google.in", "DemoQATestAutomation", "rajavigneshwarans+prv-at-002@theecode.xyz",
						"India", "8562413675", "New York", "california", "North Carolina", "60005",
						"Health Default Layout", "Risk Based Pricing-Income", "Version-1" },
				{ "DemoQATest", "www.google.in", "DemoQATestAutomation", "rajavigneshwarans+prv-at-003@theecode.xyz",
						"India", "8562413675", "New York", "california", "North Carolina", "60005",
						"Health Default Layout", "Risk Based Pricing-Income", "Version-1" }
				// Add more test data sets as needed
		};
	}
}
