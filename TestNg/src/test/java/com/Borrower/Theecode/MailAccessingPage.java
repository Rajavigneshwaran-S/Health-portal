package com.Borrower.Theecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailAccessingPage {
	private WebDriver driver;

	public MailAccessingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void outLook() throws InterruptedException {
		driver.get("https://outlook.office.com/mail/.com");
		Thread.sleep(1500);
	}

	public void enteroutLookEmail(String outLookEmail) {
		WebElement login = driver.findElement(By.xpath("//input[@type='email']"));
		login.sendKeys(outLookEmail);
	}

	public void nextButton() {
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
		login.click();
	}

	public void enterPassWord(String outLookPassWord) {
		WebElement PassWord = driver.findElement(By.xpath("//input[@type='password']"));
		PassWord.sendKeys(outLookPassWord);
	}
}