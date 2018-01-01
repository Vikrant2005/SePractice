package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appModule.SignIn_Action;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;

public class Module_TC {
	private static WebDriver driver=null;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/vikrant.upadhayay/Downloads/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.store.demoqa.com");
		SignIn_Action.Execute(driver);  //SignIn --Is Clubbing 3 to 4 lines of statement
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		Home_Page.lnk_LogOut(driver).click(); 
		driver.quit();
	}

}
