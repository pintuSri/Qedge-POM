package CommonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import Utility.AppUtils;

public class AdminLoginPage extends AppUtils{
	
//	Define Object Repository
	@FindBy(id = "txtUsername")
	WebElement objUserName;
	
	@FindBy(id = "txtPassword")
	WebElement objPassword;
	
	@FindBy(name = "Submit")
	WebElement objSubmit;
	
	@FindBy(id = "spanMessage")
	WebElement objErrorMessage;
	
//	Define Methods
	
	public void LoginFeature(String userName, String Password) throws Throwable {
		objUserName.sendKeys(userName);
		objPassword.sendKeys(Password);
		objSubmit.click();
	}
	
	public void errorMessage() {
		String errmsg=objErrorMessage.getText();
		Reporter.log("Login failed message: "+errmsg, true);
	}

}
