package com.AdminPortal.Theecode;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginbutton() {
		WebElement loginButton = driver.findElement(By.xpath("//a[text()='LOGIN']"));
		loginButton.click();
	}

	public void enterEmail(String email) {
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(email);
	}

	public void enterPassword(String password) {
		WebElement passwordField = driver.findElement(By.id("pass"));
		passwordField.sendKeys(password);
	}

	public void clickSubmitButton() {
		WebElement submitButton = driver.findElement(By.className("Mainbutton"));
		submitButton.click();

		Set<String> toDashBoard = driver.getWindowHandles();
		for (String homePage : toDashBoard) {
			driver.switchTo().window(homePage);
		}
	}
}
