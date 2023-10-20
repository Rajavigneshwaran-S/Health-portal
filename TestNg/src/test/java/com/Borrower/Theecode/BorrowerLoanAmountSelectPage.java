package com.Borrower.Theecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BorrowerLoanAmountSelectPage {
	private WebDriver driver;

	public BorrowerLoanAmountSelectPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectLoan() throws InterruptedException {
		// Locate the slider element
		WebElement slider = driver.findElement(By.xpath("//input[@clasname='slider']"));

		// Get the minimum and maximum values of the slider
		int minValue = Integer.parseInt(slider.getAttribute("min"));
		int maxValue = Integer.parseInt(slider.getAttribute("max"));

		// Set the loan amount
		int loanAmount = 7000; // Change this value as needed

		// Validate the loan amount is within the slider range
		if (loanAmount < minValue || loanAmount > maxValue) {
			System.out.println("Loan amount is outside the valid range.");
			driver.quit();
			return;
		}

		// Calculate the position on the slider for the desired loan amount
		double position = (loanAmount - minValue) / (double) (maxValue - minValue);

		// Get the width of the slider element
		int sliderWidth = slider.getSize().getWidth();

		// Calculate the desired position on the slider
		int desiredPosition = (int) (sliderWidth * position);

		// Adjust the desired position by 1 to ensure accuracy
		desiredPosition -= 1;

		// Move the slider to the desired position
		org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
		actions.dragAndDropBy(slider, desiredPosition, 0).build().perform();

	}

	public void continuebutton() throws InterruptedException {

		WebElement conitnue = driver.findElement(By.xpath("//button[text()='Continue']"));
		conitnue.click();

	}

}
