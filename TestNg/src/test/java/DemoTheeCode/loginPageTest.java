package DemoTheeCode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPageTest {

	private WebDriver driver;

	static List<String> userNameList = new ArrayList<String>();
	static List<String> passWordList = new ArrayList<String>();

	public void readExcle() throws IOException {
		FileInputStream excel = new FileInputStream(
				"C:\\Users\\Rajav\\OneDrive\\Documents\\QA\\QA_Automation\\Test_Data_Login_data.xlsx");

		Workbook workbook = new XSSFWorkbook(excel);

		Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {
			Row rowValue = rowIterator.next();

			Iterator<Cell> columnIterator = rowValue.iterator();
			int i = 2;
			while (columnIterator.hasNext()) {
				if (i % 2 == 0) {
					userNameList.add(columnIterator.next().getStringCellValue());
				} else {
					passWordList.add(columnIterator.next().getStringCellValue());

				}
				i++;

			}

		}

	}

	public void loginPage(String uName, String pWord) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium WebDriver\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://saas.lendeasy.co/login");

		WebElement email1 = driver.findElement(By.id("email"));
		email1.sendKeys(uName);

		WebElement passwrd = driver.findElement(By.id("pass"));
		passwrd.sendKeys(pWord);

		WebElement submit = driver.findElement(By.className("Mainbutton"));
		submit.click();
		Thread.sleep(3000);

		String expectedUrl = driver.getCurrentUrl();

		String actualUrl = "https://saas.lendeasy.co/docs/home";

		if (expectedUrl.equals(actualUrl)) {
			System.out.println();
			System.out.println("Current Url is:" + expectedUrl);

			System.out.println("Login Successfull" + " " + uName + " & " + pWord + " are Valid");
		} else {

			System.out.println("Login UnSuccessfull" + " " + uName + " & " + pWord + " are Not Valid");
			driver.quit();
		}

	}

	public void execute() throws InterruptedException {

		for (int i = 0; i < userNameList.size(); i++) {
			loginPage(userNameList.get(i), passWordList.get(i));

		}

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		loginPageTest usingPOi = new loginPageTest();
		usingPOi.readExcle();
		System.out.println("userName List" + userNameList);
		System.out.println();
		System.out.println("passWord List" + passWordList);
		usingPOi.execute();
		
		System.out.println();
		System.out.println("Login page Test case Pass");

	}

}
