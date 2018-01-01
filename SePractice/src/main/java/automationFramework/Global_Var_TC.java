package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appModule.SignIn_Action;
import pageObjects.Home_Page;
import utility.Constant;

public class Global_Var_TC {

	
	private static WebDriver driver=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/vikrant.upadhayay/Downloads/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constant.URL);
		SignIn_Action.Execute(driver,Constant.Username,Constant.Password); //Passing Parameters through CONSTANTS
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		Home_Page.lnk_LogOut(driver).click(); 
		driver.quit();
	}
}
