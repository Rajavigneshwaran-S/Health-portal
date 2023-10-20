package com.Borrower.Theecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BorrowerEmailMobNumPage {
	private WebDriver driver;

	public BorrowerEmailMobNumPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterBorrowerEmail(String email) {
		WebElement emailFieldBrowr = driver.findElement(By.xpath("//input[@id='email']"));

		emailFieldBrowr.sendKeys(email);
	}

	public void enterBorrowerMobileNumber(String num) {
		WebElement numFieldBrowr = driver.findElement(By.xpath("//input[@id='phone']"));
		numFieldBrowr.sendKeys(num);
	}

	public void continueButton() {
		WebElement continue1 = driver.findElement(By.xpath("//button[text()='Continue']"));
		continue1.click();

	}
}
