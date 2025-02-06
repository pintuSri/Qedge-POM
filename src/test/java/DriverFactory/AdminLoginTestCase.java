package DriverFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonFunctions.AdminLoginPage;
import CommonFunctions.AdminModulePage;
import CommonFunctions.LogoutPage;
import Utility.AppUtils;

public class AdminLoginTestCase extends AppUtils{
	@FindBy(linkText = "Admin")
	WebElement objAdminModule;
	
	@Parameters({"userName","Password"})
	@Test(priority = 1, enabled = false)
	public void LoginPositiveTestCase(String userName, String Password) throws Throwable {
		AdminLoginPage adlp = PageFactory.initElements(driver, AdminLoginPage.class);
		adlp.LoginFeature(userName, Password);
		Thread.sleep(5000);
		AdminModulePage amp = PageFactory.initElements(driver, AdminModulePage.class);
		amp.getModulesList();
		LogoutPage lo = PageFactory.initElements(driver, LogoutPage.class);
		lo.logoutFeature();
	}
	
	@Parameters({"userName", "Password"})
	@Test(priority = 2, enabled = false)
	public void LoginNegetiveTestCase(String userName, String Password) throws Throwable {
		AdminLoginPage lp = PageFactory.initElements(driver, AdminLoginPage.class);
		lp.LoginFeature(userName, Password);
		lp.errorMessage();
	}
	
	@Parameters({"userName", "Password"})
	@Test(enabled = false)
	public void loginTest(String userName, String Password) throws Throwable {
		AdminLoginPage lp = PageFactory.initElements(driver, AdminLoginPage.class);
		lp.LoginFeature(userName, Password);
		
		try {
			WebElement adminMod=driver.findElement(By.linkText("Admin"));
			if(adminMod.isDisplayed()) {
				Reporter.log("Login Success");
				LogoutPage lop = PageFactory.initElements(driver, LogoutPage.class);
				lop.logoutFeature();
			}
			
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			lp.errorMessage();
		}

	}

}
