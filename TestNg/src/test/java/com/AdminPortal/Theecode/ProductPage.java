package com.AdminPortal.Theecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	private WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;

	}

	public void trySandbox() throws InterruptedException {
		WebElement trysandbox = driver.findElement(By.xpath("//span[text()=' Try Sandbox ']"));
		trysandbox.click();
		Thread.sleep(3000);

		// Register Tab will be opened in New window so giving windows handling to
		// driver
		Set<String> windowhandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowhandles);
		driver.switchTo().window(list.get(1));

	}
}
