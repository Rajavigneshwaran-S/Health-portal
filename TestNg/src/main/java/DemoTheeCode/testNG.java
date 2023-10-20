package DemoTheeCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class testNG {

	WebDriver driver;

	@Test(priority = 1)
	public void propertySetUps() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium WebDriver\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://site.lendeasy.co/");
		Thread.sleep(10000);
		WebElement trysandbox = driver.findElement(By.xpath("//span[text()=' Try Sandbox ']"));
		trysandbox.click();
		Thread.sleep(8000);
	}

	@Test(priority = 2)
	public void signUpLoginPage() throws InterruptedException {

		Set<String> windowhandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowhandles);
		driver.switchTo().window(list.get(1));

		WebElement login = driver.findElement(By.xpath("//a[@activeclassname='active']"));
		login.click();
		Thread.sleep(3000);

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("vickyrajas1997+theeco@gmail.com");
		Thread.sleep(1000);

		WebElement passwrd = driver.findElement(By.id("pass"));
		passwrd.sendKeys("Raja@1997");
		Thread.sleep(1000);

		WebElement submit = driver.findElement(By.className("Mainbutton"));
		submit.click();
		Thread.sleep(6000);

	}

	@Test(priority = 3)
	public void backOfficeHome() throws InterruptedException {
		WebElement backOffice = driver.findElement(By.xpath("//div[@class='backofficetext']"));
		backOffice.click();
		Thread.sleep(8000);
		Set<String> windowHandlesTwo = driver.getWindowHandles();
		for (String newWindowTwo : windowHandlesTwo) {
			driver.switchTo().window(newWindowTwo);

		}
		Thread.sleep(10000);
		WebElement provider = driver.findElement(By.xpath("//div[text()='Providers ']"));
		provider.click();
		Thread.sleep(3000);

		WebElement manageProvider = driver.findElement(By.xpath("//div[text()=' Manage Providers ']"));
		manageProvider.click();
		Thread.sleep(5000);

	}

	@Test(priority = 4)
	public void addProvider() throws InterruptedException {
		WebElement addproviders = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		addproviders.click();
		Thread.sleep(4000);

		Set<String> windowHandlesthree = driver.getWindowHandles();
		for (String newWindow3 : windowHandlesthree) {
			driver.switchTo().window(newWindow3);
		}

		WebElement businessContactName = driver.findElement(By.id("contactName"));
		businessContactName.sendKeys("VigneshKing");
		Thread.sleep(1000);

		WebElement provideWebsite = driver.findElement(By.id("practiceHomeUrl"));
		provideWebsite.sendKeys("www.google.in");
		Thread.sleep(1000);

		WebElement providerName = driver.findElement(By.id("practiceName"));
		providerName.sendKeys("Rakeshh Medic Agenyy");
		Thread.sleep(1000);

		WebElement bussinessEmail = driver.findElement(By.id("email"));
		bussinessEmail.sendKeys("vickyrajas1997+prv031@gmail.com");
		Thread.sleep(1500);

		Select countryCode = new Select(driver.findElement(By.xpath("//select[@name='phoneNumberCountry']")));
		countryCode.selectByVisibleText("India");
		Thread.sleep(1000);

		WebElement mobNum = driver.findElement(By.id("mobileNumber"));
		mobNum.sendKeys("8562413675");
		Thread.sleep(4000);

		WebElement address = driver.findElement(By.id("react-select-2-input"));
		address.click();
		Thread.sleep(2000);

		address.sendKeys("New York");
		Thread.sleep(2000);
		address.sendKeys(Keys.ENTER);

		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("california");
		Thread.sleep(1000);

		WebElement state = driver.findElement(By.id("stateCode"));
		Thread.sleep(1000);

		Select select = new Select(state);
		select.selectByVisibleText("North Carolina");
		Thread.sleep(1000);

		WebElement zipcode = driver.findElement(By.id("zipcode"));
		zipcode.sendKeys("60005");

		WebElement layouts = driver.findElement(By.id("layout_id"));
		Thread.sleep(1000);
		Select select1 = new Select(layouts);
		select1.selectByVisibleText("Health Default Layout");
		Thread.sleep(1000);

		WebElement pricingModel = driver.findElement(By.id("pricing_id"));
		Thread.sleep(1000);
		Select select2 = new Select(pricingModel);
		select2.selectByVisibleText("Risk Based Pricing-Income");
		Thread.sleep(1000);

		WebElement pricingModelVersion = driver.findElement(By.id("version_id"));
		Thread.sleep(1000);
		Select select3 = new Select(pricingModelVersion);
		select3.selectByVisibleText("Version-1");
		Thread.sleep(1000);

		WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
		addButton.click();
		Thread.sleep(2500);

	}

}
