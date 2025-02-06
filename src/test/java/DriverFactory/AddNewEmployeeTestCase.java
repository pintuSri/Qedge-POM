package DriverFactory;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonFunctions.AdminLoginPage;
import CommonFunctions.AdminModulePage;
import CommonFunctions.LogoutPage;
import Utility.AppUtils;

public class AddNewEmployeeTestCase extends AppUtils{
	@Parameters({"userName","Password","firstName","lastName","uName","pword","cPassword"})
	@Test(enabled = false)
	public void addNewEmployee(String userName,String Password,String firstName, String lastName, String uName, String pword, String cPassword) throws Throwable {
		AdminLoginPage lp = PageFactory.initElements(driver, AdminLoginPage.class);
		lp.LoginFeature(userName, Password);
		AdminModulePage amp = PageFactory.initElements(driver, AdminModulePage.class);
		amp.addNewEmployee(firstName, lastName, uName, pword, cPassword);
		Thread.sleep(2000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("Screenshots/EmployeedAdd.png");
		LogoutPage lop = PageFactory.initElements(driver, LogoutPage.class);
		lop.logoutFeature();
	}

}
