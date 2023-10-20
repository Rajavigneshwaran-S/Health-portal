package DemoJXL;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class jxlDemoLogin {
	WebDriver driver;

	String[][] data = null;

	@DataProvider(name = "loginData")
	public String[][] loginDataProvider() throws BiffException, IOException {

		data = getExcelData();

		return data;

	}

	public String[][] getExcelData() throws BiffException, IOException {

		FileInputStream excel = new FileInputStream("C:\\Users\\Rajav\\Downloads\\Product_Login_Test_Data.xlsx");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet(0);

		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		String testdata[][] = new String[rowCount - 1][columnCount];
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				testdata[i - 1][j] = sheet.getCell(i, j).getContents();

			}

		}
		return testdata;

	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium WebDriver\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {
		driver.quit();

	}

	@Test(priority = 1, dataProvider = "loginData")
	public void loginTestCase(String eMail, String passWord) throws InterruptedException {
        
		driver.get("https://site.lendeasy.co/");
		Thread.sleep(5000);

		WebElement trysandbox = driver.findElement(By.xpath("//span[text()=' Try Sandbox ']"));
		trysandbox.click();
		Thread.sleep(1000);

		Set<String> windowhandles = driver.getWindowHandles();

		for (String newWind : windowhandles) {
			driver.switchTo().window(newWind);

		}
		Thread.sleep(1000);

		WebElement login = driver.findElement(By.xpath("//a[@activeclassname='active']"));
		login.click();
		Thread.sleep(2000);

		WebElement email1 = driver.findElement(By.id("email"));
		email1.sendKeys(eMail);
		Thread.sleep(1000);

		WebElement passwrd = driver.findElement(By.id("pass"));
		passwrd.sendKeys(passWord);
		Thread.sleep(1000);

		WebElement submit = driver.findElement(By.className("Mainbutton"));
		submit.click();

	}

}
