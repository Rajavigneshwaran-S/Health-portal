package com.Borrower.Theecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLogin4BorrowerOnBoard {

	private WebDriver driver;

	public AdminLogin4BorrowerOnBoard(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmailLogin(String email) {

		WebElement emailLoginField = driver.findElement(By.xpath("//input[@id='email']"));
		emailLoginField.click();
		emailLoginField.sendKeys(email);
	}

	public void enterPassword(String passWord) {

		WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
		passwordField.click();
		passwordField.sendKeys(passWord);
	}

	public void loginButton() {

		WebElement loginField = driver.findElement(By.xpath("//button[text()='Login']"));
		loginField.click();
	}

	

}
