package com.AdminPortal.Theecode;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProvidersPage {

	private WebDriver driver;

	public ProvidersPage(WebDriver driver) {
		this.driver = driver;
	}

	public void manageprovider() throws InterruptedException {
		WebElement manageProvider = driver.findElement(By.xpath("//div[text()=' Manage Providers ']"));
		manageProvider.click();
		Thread.sleep(3000);
	}

	public void addprovider() throws InterruptedException {
		WebElement addproviders = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		addproviders.click();
		Thread.sleep(2000);

		Set<String> windowHandlesthree = driver.getWindowHandles();
		for (String newWindow3 : windowHandlesthree) {
			driver.switchTo().window(newWindow3);
		}
	}

	public void enterBusinessContactName(String contactName) {
		WebElement businessContactName = driver.findElement(By.id("contactName"));
		businessContactName.sendKeys(contactName);
	}

	public void enterProviderWebsite(String website) {
		WebElement providerWebsite = driver.findElement(By.id("practiceHomeUrl"));
		providerWebsite.sendKeys(website);
	}

	public void enterProviderName(String providerName) {
		WebElement providerNameField = driver.findElement(By.id("practiceName"));
		providerNameField.sendKeys(providerName);
	}

	public void enterBusinessEmail(String email) {
		WebElement businessEmail = driver.findElement(By.id("email"));
		businessEmail.sendKeys(email);
	}

	public void selectCountryCode(String countryCode) {
		Select selectCountryCode = new Select(driver.findElement(By.xpath("//select[@name='phoneNumberCountry']")));
		selectCountryCode.selectByVisibleText(countryCode);
	}

	public void enterPhoneNumber(String mobileNumber) {
		WebElement phoneNum = driver.findElement(By.id("mobileNumber"));
		phoneNum.sendKeys(mobileNumber);
	}

	public void enterAddress(String address) throws InterruptedException {
		WebElement addressField = driver.findElement(By.id("react-select-2-input"));
		addressField.click();
		addressField.sendKeys(address);
		Thread.sleep(2000);
		addressField.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	public void enterCity(String city) {
		WebElement cityField = driver.findElement(By.id("city"));
		cityField.sendKeys(city);
	}

	public void selectState(String state) {
		Select selectState = new Select(driver.findElement(By.id("stateCode")));
		selectState.selectByVisibleText(state);
	}

	public void enterZipCode(String zipCode) {
		WebElement zipcode = driver.findElement(By.id("zipcode"));
		zipcode.sendKeys(zipCode);
	}

	public void selectLayout(String layout) {
		Select selectLayout = new Select(driver.findElement(By.id("layout_id")));
		selectLayout.selectByVisibleText(layout);
	}

	public void selectPricingModel(String pricingModel) {
		Select selectPricingModel = new Select(driver.findElement(By.id("pricing_id")));
		selectPricingModel.selectByVisibleText(pricingModel);
	}

	public void selectPricingModelVersion(String version) {
		Select selectPricingModelVersion = new Select(driver.findElement(By.id("version_id")));
		selectPricingModelVersion.selectByVisibleText(version);
	}

	public void clickAddButton() {
		WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
		addButton.click();
	}
}
