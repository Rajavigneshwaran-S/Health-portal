package com.AdminPortal.Theecode;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	public void backOffice() throws InterruptedException {
		WebElement backOffice = driver.findElement(By.xpath("//div[@class='backofficetext']"));
		backOffice.click();
		Thread.sleep(8000);

		Set<String> windowHandlesTwo = driver.getWindowHandles();
		for (String newWindowTwo : windowHandlesTwo) {
			driver.switchTo().window(newWindowTwo);
		}
		Thread.sleep(10000);

	}

}
