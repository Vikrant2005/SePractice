package automationFramework;

import org.testng.annotations.Test;

import appModule.SignIn_Action;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.xml.serializer.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;


public class UDF_TC{

		public WebDriver driver;
	    private String sTestCaseName;
	    private int iTestCaseRow;
	    
	    
	  @Test
	  public void main() throws Exception {
		  SignIn_Action.Execute(driver);

			System.out.println("Login Successfully, now it is the time to Log Off buddy.");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  DOMConfigurator.configure("log4j.xml");

		  sTestCaseName = this.toString();
		  sTestCaseName = utility.Utils.getTestCaseName(this.toString());
		  Log.startTestCase(sTestCaseName);
		  
ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
driver = utility.Utils.openBrowser(iTestCaseRow);
}

	  @AfterMethod
	  public void afterMethod() throws Exception {
		  driver.quit();

	  }
	



}

