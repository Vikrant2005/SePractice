package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appModule.SignIn_Action;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;

public class Apache_POI_TC {
	private static WebDriver driver=null;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/vikrant.upadhayay/Downloads/chromedriver_win32/chromedriver.exe");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constant.URL);
		SignIn_Action.Execute(driver); //Passing Parameters through CONSTANTS
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		//Home_Page.lnk_LogOut(driver).click(); 
		driver.quit();
		ExcelUtils.setCellData("Pass", 1, 3);
}
}
