package DemoTheeCode;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class backOfficePageTest {
	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium WebDriver\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://saas.lendeasy.co/login");

		WebElement email1 = driver.findElement(By.id("email"));
		email1.sendKeys("venkatavarthan+3005@theecode.xyz");

		WebElement passwrd = driver.findElement(By.id("pass"));
		passwrd.sendKeys("Admin@123");

		WebElement submit = driver.findElement(By.className("Mainbutton"));
		submit.click();
		Thread.sleep(5000);

		WebElement backOffice = driver.findElement(By.xpath("//div[@class='backofficetext']"));
		backOffice.click();
		Thread.sleep(2000);

		Set<String> windowHandlesTwo = driver.getWindowHandles();
		for (String newWindowTwo : windowHandlesTwo) {
			driver.switchTo().window(newWindowTwo);

		}
		Thread.sleep(10000);

		String expectedUrl = driver.getCurrentUrl();

		String actualUrl = "https://lend2business.lendeasy.co/admin/dashboard";

		if (expectedUrl.equals(actualUrl)) {
			System.out.println("Current Url is:" + " " + expectedUrl);
			System.out.println();
			System.out.println("This " + expectedUrl + " is Matched with " + " " + actualUrl);
			System.out.println();
			System.out.println("Back Office page Test case Pass");

		} else {
			System.out.println("This " + expectedUrl + " is Not Matched with " + " " + actualUrl);
			driver.close();

		}

	}

}
