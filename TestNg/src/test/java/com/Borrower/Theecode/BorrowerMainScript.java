package com.Borrower.Theecode;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BorrowerMainScript {

	private WebDriver driver;

	@Test(priority = 1)
	public void propertySetUpsBorrower() throws InterruptedException {

		// Chrome Driver Path Set-Up
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium WebDriver\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		// Opening duplicate driver for testing purpose
		driver.manage().window().maximize();
		driver.get("https://trend2business.theecode.co/admin/login");
	}

	@Test(priority = 2)
	public void adminLogin() throws InterruptedException {

		AdminLogin4BorrowerOnBoard adminLogin4borrower = new AdminLogin4BorrowerOnBoard(driver);

		adminLogin4borrower.enterEmailLogin("rajavigneshwarans+demo100@theecode.xyz");

		adminLogin4borrower.enterPassword("Admin@123");

		adminLogin4borrower.loginButton();
		Thread.sleep(3000);

		String expectedLoginDashpageURL = "https://trend2business.theecode.co/admin/dashboard";
		String actualLoginDashpageURL = driver.getCurrentUrl();

		Assert.assertEquals(expectedLoginDashpageURL, actualLoginDashpageURL);
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void adminPortal() throws InterruptedException {
		AdminPortalPage adminPage = new AdminPortalPage(driver);
		adminPage.brandPage();
		Thread.sleep(3000);

		String expectedBorrowerLandpageURL = "https://trend2business.theecode.co/";
		String actualBorrowerLandpageURL = driver.getCurrentUrl();

		Assert.assertEquals(expectedBorrowerLandpageURL, actualBorrowerLandpageURL);
		Thread.sleep(1000);

	}

	@Test(priority = 4)
	public void borrowerLandingPage() throws InterruptedException {

		BorrowerLandingPage borLandPage = new BorrowerLandingPage(driver);
		borLandPage.landingPage();
		Thread.sleep(2000);

		String expectedLoanpageUrl = "https://trend2business.theecode.co/select-loan";
		String actualLoanpageUrl = driver.getCurrentUrl();

		Assert.assertEquals(expectedLoanpageUrl, actualLoanpageUrl);

	}

	@Test(priority = 5)
	public void borrowerLoanSelectingPage() throws InterruptedException {
		BorrowerLoanAmountSelectPage loanSelect = new BorrowerLoanAmountSelectPage(driver);
		loanSelect.selectLoan();
		Thread.sleep(1000);
		loanSelect.continuebutton();
		Thread.sleep(2000);

	}

	@Test(priority = 6)

	public void borrowerEmailNumberPage() throws InterruptedException {
		BorrowerEmailMobNumPage borEmilNum = new BorrowerEmailMobNumPage(driver);
		borEmilNum.enterBorrowerEmail("rajavigneshwarans+demo-qa-at-002@theecode.xyz");
		borEmilNum.enterBorrowerMobileNumber("4544566546");
		borEmilNum.continueButton();
		Thread.sleep(2000);

		String expectedVerifypageURl = driver.getCurrentUrl();
		String actualVerifypageURl = driver.getCurrentUrl();

		Assert.assertEquals(expectedVerifypageURl, actualVerifypageURl);
	}

	@Test(priority = 7)
	public void mailLinkAccess() throws MessagingException, IOException {

		MailAccessingPage mailPage = new MailAccessingPage(driver);
		

	}

}
