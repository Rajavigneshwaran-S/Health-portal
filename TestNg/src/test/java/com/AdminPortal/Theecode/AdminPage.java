package com.AdminPortal.Theecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {

	private WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public void provider() throws InterruptedException {
		WebElement provider = driver.findElement(By.xpath("//div[text()='Providers ']"));
		provider.click();
		Thread.sleep(3000);

	}
}
