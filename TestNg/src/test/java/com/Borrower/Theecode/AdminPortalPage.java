package com.Borrower.Theecode;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPortalPage {
	private WebDriver driver;

	public AdminPortalPage(WebDriver driver) {
		this.driver = driver;
	}

	public void brandPage() throws InterruptedException {

		WebElement brandPage = driver.findElement(By.xpath("//div[text()=' Go To Brand Page']"));
		brandPage.click();
		Thread.sleep(1000);

		Set<String> borrowerWindows = driver.getWindowHandles();
		for (String borNewWindowone : borrowerWindows) {
			driver.switchTo().window(borNewWindowone);
		}

	}

}
