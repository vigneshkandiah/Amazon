package AmazonPOM.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import AmazonExcelUtil.LearnExcel;

public class projectSpecificmethod {
	public static ChromeDriver driver;
	public String excelFileName;
	
	
	@BeforeMethod
	public void login() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver =new ChromeDriver();
		driver.get("http://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	}
	
	
	@AfterMethod
	public void closeApp() {
		driver.close();

		}
	@DataProvider(name = "fetchData")
	public String[][] getData() throws IOException {
		LearnExcel readData = new LearnExcel();
		return readData.readExcel(excelFileName);
	}
	public void windowSwitch( int window) {
	
		Set<String> allWindowsSet= driver.getWindowHandles();
		List<String> windowsList= new ArrayList<String>();
		windowsList.addAll(allWindowsSet);
		driver.switchTo().window(windowsList.get(window));
	}
	}

