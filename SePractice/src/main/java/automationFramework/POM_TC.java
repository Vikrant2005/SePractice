package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.Home_Page;
import pageObjects.LogIn_Page;

public class POM_TC {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/vikrant.upadhayay/Downloads/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.store.demoqa.com");
		Home_Page.lnk_MyAccount(driver).click();
		LogIn_Page.txtbx_UserName(driver).sendKeys("testuser_1");
		LogIn_Page.txtbx_Password(driver).sendKeys("Test@123");
		LogIn_Page.btn_LogIn(driver).click();
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		Home_Page.lnk_LogOut(driver).click(); 
		driver.quit();
	}

}
