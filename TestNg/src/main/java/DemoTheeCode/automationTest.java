package DemoTheeCode;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class automationTest {
	static WebDriver driver;

	@BeforeTest
	public static void propertySetUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium WebDriver\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://site.lendeasy.co/");

	}

	@Test(priority = 1)
	public void signUpPage() throws InterruptedException {
		WebElement trysandbox = driver
				.findElement(By.xpath("//span[text()=' Try Sandbox ']"));
		trysandbox.click();
		Thread.sleep(5000);

		Set<String> windowhandles = driver.getWindowHandles();

		for (String newWind : windowhandles) {
			driver.switchTo().window(newWind);

		}
		WebElement login = driver.findElement(By.xpath("//a[@activeclassname='active']"));
		login.click();
		Thread.sleep(1000);

	}

	@Test(priority = 2)
	public void loginCredential() throws InterruptedException {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("vickyrajas1997+th@gmail.com");
		Thread.sleep(1000);

		WebElement passwrd = driver.findElement(By.id("pass"));
		passwrd.sendKeys("Raja@1997");
		Thread.sleep(1000);

		WebElement submit = driver.findElement(By.className("Mainbutton"));
		submit.click();
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void backOffice() throws InterruptedException {
		WebElement backOff = driver.findElement(By.className("backofficetext"));
		backOff.click();
		Thread.sleep(6000);

	}

	@Test(priority = 4)
	public void adminPortal() throws InterruptedException {
		Set<String> windowHandlesTwo = driver.getWindowHandles();
		for (String newWindowTwo : windowHandlesTwo) {
			driver.switchTo().window(newWindowTwo);
			Thread.sleep(4000);
		}

		WebElement provider = driver.findElement(By.xpath("//div[text()='Providers ']"));
		provider.click();
		Thread.sleep(2000);

	}

}
