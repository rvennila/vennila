package org.global;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class  SeleniumBase{
	private static final CellType NUMERIC = null;
	public static WebDriver driver;
	public JavascriptExecutor javascriptExecutor;

	public void initDriver(String browserType) {

		switch (browserType) {
		case "Chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;

		case "Edge":

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;

		default:
			System.out.println("InValid Browser Type");
			break;
		}

	}

	public void applicationLaunch(String url) {
		driver.get(url);
	}

	public void windMax() {
		driver.manage().window().maximize();

	}

	public void sendKeysByJava(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);

	}

	public  void clickByJava(WebElement element) {
		element.click();

	}

	public void sendKeysByJSE(WebElement element, String keysToSend) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].setAttribute('value',' " + keysToSend + " ')", element);

	}

	public void clickByJSE(WebElement element) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click()", element);

	}

	// AccessPecifier returnType methodName() { }
	public String getAttributeByJava(WebElement element) {
		String attribute = element.getAttribute("value");

		return attribute;
	}

	public Object getAttributeByJSE(WebElement element) {
		javascriptExecutor = (JavascriptExecutor) driver;
		Object executeScript = javascriptExecutor.executeScript("return arguments[0].getAttribute('value')", element);

		return executeScript;
	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}
	public void waitimp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public void scrollByJSE(String up_down, WebElement element) {
		javascriptExecutor = (JavascriptExecutor) driver;

		switch (up_down) {
		case "down":
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
			break;

		case "up":
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", element);
			break;

		default:
			System.out.println("In Valid Scroll Type");
			break;
		}

	}

	public void screenCapture() {

		try {

			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

			File screenshotAs = takesScreenshot.getScreenshotAs(OutputType.FILE);
			File targetLocation = new File("ErrorImage\\" + System.currentTimeMillis() + ".jpeg");
			FileUtils.copyFile(screenshotAs, targetLocation);

		} catch (Exception e) {

		}
	}

	public void windowsHandling(int WindowIndex) {

		try {

			String currentWindowID = driver.getWindowHandle();

			Set<String> allWindowsID = driver.getWindowHandles();

			List<String> list = new LinkedList<>();
			list.addAll(allWindowsID);

			String requiredWindowsID = list.get(WindowIndex);

			driver.switchTo().window(requiredWindowsID);

		} catch (Exception e) {

		}

	}

	public String getWindowsID(int windowIndex) {

		String requiredWindowsID = null;

		try {

			String currentWindowID = driver.getWindowHandle();

			Set<String> allWindowsID = driver.getWindowHandles();

			List<String> list = new LinkedList<>();
			list.addAll(allWindowsID);

			requiredWindowsID = list.get(windowIndex);

		} catch (Exception e) {

		}

		return requiredWindowsID;
	}

	public static String getDataFromExcel(int rownum, int cellnum) {

		String value = null;

		try {

			// To Locate where the Excel will be
			File file = new File("Database\\Book1.xlsx");

			// To Get File as a INput Datas
			FileInputStream fileInputStream = new FileInputStream(file); // Throws FileNotFoundException

			// To Define Workbook
			Workbook book = new XSSFWorkbook(fileInputStream); // Throws IOExceptions

			// To get sheet from Book
			Sheet sheet = book.getSheet("LoginDatas");

			// To get Row From Sheet
			Row row = sheet.getRow(rownum);

			// To get Cell from Row
			Cell cell = row.getCell(cellnum);

			// To find Cell Type
			CellType cellType = cell.getCellType();

			switch (cellType) {
			case STRING:
				// To get String valuie from the Cell
				value = cell.getStringCellValue();

				break;

			case NUMERIC:
				

				if (DateUtil.isCellDateFormatted(cell)) {
					// to get Date Value from Cell >> IST format Date value will get
					Date dateCellValue = cell.getDateCellValue();

					// To Define Date Forfmat based on Our Requirements
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					value = simpleDateFormat.format(dateCellValue);

				} else {

					// To get Normal Numeric from Cell
					double numericCellValue = cell.getNumericCellValue();

					// To convert double into String By using BigDecimal
					BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
					value = valueOf.toString();

				}
				break;

			default:
				System.out.println("InValid Cell Format");
				break;
			}

		} catch (Exception e) {

		}

		return value;
	}

	public static String getDataFromPropertyFile(String propertyKey) {

		String propertyValue = null;
		try {

			// To Locate Where the File Will be (PropertyFile)
			File file = new File("DataBase\\Config.properties");

			// To get File as a Input
			FileReader fileReader = new FileReader(file); // Throws FileNotFound Exception

			// To Define PropertyFile
			Properties properties = new Properties();

			// To Load File into Property Class
			properties.load(fileReader); // Throws IOExceptions

			// To get Value Based on Key
			propertyValue = properties.getProperty(propertyKey);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return propertyValue;

	}

	public void confirmAlert(String values) {
		Alert altert = driver.switchTo().alert();
		switch (values) {
		case "accept":
			altert.accept();
			break;
		case"dismiss":
			altert.dismiss();
			break;
				
				default:
					break;
			}
			}
		
	public void selectByVisibleText(WebElement element, String readExcel) {
        Select select = new Select(element);
        select.selectByVisibleText(readExcel);
    }
}
