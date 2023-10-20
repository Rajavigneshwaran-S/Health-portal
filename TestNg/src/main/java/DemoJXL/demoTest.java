package DemoJXL;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class demoTest {

	public static void main(String[] args) throws InterruptedException {

		// Chrome Driver Path Set-Up
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium WebDriver\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Opening duplicate driver for testing purpose
		driver.manage().window().maximize();

		driver.get("https://trend2business.theecode.co/select-loan");
		// Wait for the page to load
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

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
}
