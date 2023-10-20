package com.Borrower.Theecode;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BorrowerLandingPage {
	private WebDriver driver;

	public BorrowerLandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void landingPage() throws InterruptedException {

		WebElement startNow = driver.findElement(By.xpath("//div[text()='Start Now']"));
		startNow.click();

		Set<String> borrowerWindows2 = driver.getWindowHandles();
		for (String borNewWindowTwo : borrowerWindows2) {
			driver.switchTo().window(borNewWindowTwo);
		}

	}

}
