package automationFramework;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNG_Framework {

	public WebDriver driver;
  @Test
  public void main() throws Exception {
	  SignIn_Action.Execute(driver);

		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  DOMConfigurator.configure("log4j.xml");

		Log.startTestCase("Selenium_Test_001");
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/vikrant.upadhayay/Downloads/chromedriver_win32/chromedriver.exe");
		Log.info("Vikrant has set system properties");

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");

		Log.info(" Excel sheet opened");

		driver = new ChromeDriver();

		Log.info("New driver instantiated");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Log.info("Implicit wait applied on the driver for 10 seconds");

		driver.get(Constant.URL);

		Log.info("Web application launched");
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  driver.quit();

		Log.info("Browser closed");

		ExcelUtils.setCellData("Pass", 1, 3);

		Log.endTestCase("Selenium_Test_001");
  }
}

