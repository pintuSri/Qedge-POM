package DriverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonFunctions.AdminLoginPage;
import CommonFunctions.AdminModulePage;
import CommonFunctions.LogoutPage;
import Utility.AppUtils;

public class AdminLoginTestCase extends AppUtils{
	@Parameters({"userName","Password"})
	@Test
	public void LoginTest(String userName, String Password) throws Throwable {
		AdminLoginPage adlp = PageFactory.initElements(driver, AdminLoginPage.class);
		adlp.LoginFeature(userName, Password);
		Thread.sleep(5000);
		AdminModulePage amp = PageFactory.initElements(driver, AdminModulePage.class);
		amp.getModulesList();
		LogoutPage lo = PageFactory.initElements(driver, LogoutPage.class);
		lo.logoutFeature();
	}

}
