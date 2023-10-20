package DemoJXL;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class loginTest {
	WebDriver driver;

	String[][] data = null;

	@DataProvider(name = "loginData")
	public String[][] loginDataProvider() throws BiffException, IOException {

		data = getExcelData();

		return data;

	}

	public String[][] getExcelData() throws BiffException, IOException {

		FileInputStream excel = new FileInputStream("C:\\Users\\Rajav\\OneDrive\\Documents\\QA\\QA_Automation\\Login_Test_Data.xls");
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

}
