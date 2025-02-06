package Utility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import CommonFunctions.AdminLoginPage;
import CommonFunctions.LogoutPage;

public class AppUtils {
	public static WebDriver driver;
	public static Properties p;
//	Open Browser
	@BeforeClass
	public void launchApp() throws Throwable{
		p = new Properties();
		p.load(new FileInputStream("ObjectRepositoy/OR.properties"));
		if(p.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(p.getProperty("Browser").equalsIgnoreCase("Edge")){
			driver = new EdgeDriver();
		}
		else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
	}
	
//	@Parameters({"userName", "Password"})
//	@BeforeClass
//	public void login(String userName, String Password) {
//		AdminLoginPage lp = PageFactory.initElements(driver, AdminLoginPage.class);
//		lp.login(userName, Password);
//	}
//	
//	@AfterClass
//	public void logout() {
//		LogoutPage lop = PageFactory.initElements(driver, LogoutPage.class);
//		lop.logoutFeature();
//		
//	}
	
	@AfterClass
	public void closeApp() {
		driver.quit();
	}
}
