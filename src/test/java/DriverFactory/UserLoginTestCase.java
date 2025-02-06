package DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonFunctions.AdminLoginPage;
import CommonFunctions.LogoutPage;
import Utility.AppUtils;

public class UserLoginTestCase extends AppUtils{
	
	@Parameters({"userName","Password"})
	@Test
	public void userLoginTest(String userName, String Password) throws Throwable {
		AdminLoginPage lp = PageFactory.initElements(driver, AdminLoginPage.class);
		lp.LoginFeature(userName, Password);
		
		String eInfo=driver.findElement(By.linkText("My Info")).getText();
		System.out.println(eInfo+" Module Displayed");
		
		LogoutPage lop = PageFactory.initElements(driver, LogoutPage.class);
		lop.logoutFeature();

	}

}
