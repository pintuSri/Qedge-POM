package Utility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AppUtils {
	public static WebDriver driver;
	public static Properties p;
//	Open Browser
	@BeforeSuite
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
	
	@AfterSuite
	public void closeApp() {
		driver.quit();
	}
}
