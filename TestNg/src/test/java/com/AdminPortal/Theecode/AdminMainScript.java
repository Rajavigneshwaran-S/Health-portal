package com.AdminPortal.Theecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminMainScript {

	private WebDriver driver;

	/* Property set up Test cases.......................................... */
	/* 1.Setting up the environment for the driver */
	/* 2.system Driver path will be configured */

	@Test(priority = 1)
	private void propertySetUps() throws InterruptedException {

		// Chrome Driver Path Set-Up
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium WebDriver\\Chrome_Driver\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();

		// Opening duplicate driver for testing purpose
		driver.manage().window().maximize();
	}

	/* 1.Theecode official website will be opened */
	/* 2.when click on try sand box new register tab will will be opened */

	@Test(priority = 2)
	private void theecodeWebsite() throws InterruptedException {
		// Opening Theecode website
		driver.get("https://www.theecode.xyz/");
		Thread.sleep(5000);

		// validating The Result using Assertions
		String expectedProductPageURL = "https://www.theecode.xyz/";
		String actualProductPageURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedProductPageURL, actualProductPageURL);

		// Creating ProductPage object
		ProductPage productpage = new ProductPage(driver);

		// Clicking on Try sandbox
		productpage.trySandbox();

		// validating The Result using Assertions
		String expectedRegisterURL = "https://platform.theecode.co/register";
		String actualRegisterURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedRegisterURL, actualRegisterURL);

	}

	/* signUpLoginPage Test cases.......................................... */
	/* 1.When click on login button asked for valid credentials */
	/* 2.After entered valid credentials home page will be displayed */

	@Test(priority = 3, dataProvider = "loginData", dataProviderClass = TestData.class)
	private void loginTest(String email, String password) throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.loginbutton();
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickSubmitButton();
		Thread.sleep(3000);

		// validating The Result using Assertions
		String expectedURL = "https://platform.theecode.co/docs/home";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
	}

	/*
	 * backOfficeHome Test cases.......................................... /*1.After
	 * click on back office in home page a new admin dashboard page will be
	 * displayed
	 */

	@Test(priority = 4)
	private void backOfficeHome() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.backOffice();

		// Admin DashBoard Tab will be opened in New window so giving windows handling
		// to driver

		// validating The Result using Assertions
		String expectedURL = "https://theecode4platform.theecode.co/admin/dashboard";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
		Thread.sleep(1000);
	}

	/*
	 * 1.Click on Manage provider in adminPage - Manage provider, Loan Product
	 * Mapping ,Providers users will be displayed
	 */

	@Test(priority = 5)
	private void adminPage() throws InterruptedException {

		AdminPage adminPage = new AdminPage(driver);
		adminPage.provider();

	}

	/* AddProvider Test cases.......................................... */
	/* 1.Click on Manage Provider, Manage Providers page will be opened */
	/* 2.Click on add providers tab add providers tab will be opened */
	/* 3.Enter the valid inputs in all Mandatory fields */
	/* 4.Click on add button */
	/* 5.Provider will be added */

	@Test(priority = 6, dataProvider = "providerData", dataProviderClass = TestData.class)
	private void addProviderTest(String contactName, String website, String providerName, String email,
			String countryCode, String mobileNumber, String address, String city, String state, String zipCode,
			String layout, String pricingModel, String version) throws InterruptedException {

		ProvidersPage providerPage = new ProvidersPage(driver);

		providerPage.manageprovider();

		// validating The Result using Assertions
		String expectedURL = "https://theecode4platform.theecode.co/admin/practice-management";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
		Thread.sleep(1000);

		providerPage.addprovider();

		providerPage.enterBusinessContactName(contactName);
		providerPage.enterProviderWebsite(website);
		providerPage.enterProviderName(providerName);
		providerPage.enterBusinessEmail(email);
		providerPage.selectCountryCode(countryCode);
		providerPage.enterPhoneNumber(mobileNumber);
		providerPage.enterAddress(address);
		providerPage.enterCity(city);
		providerPage.selectState(state);
		providerPage.enterZipCode(zipCode);
		providerPage.selectLayout(layout);
		providerPage.selectPricingModel(pricingModel);
		providerPage.selectPricingModelVersion(version);
		providerPage.clickAddButton();

	}
}
