package CommonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import Utility.AppUtils;

public class AdminLoginPage extends AppUtils{
	
//	Define Object Repository
	@FindBy(id = "txtUsername")
	WebElement objUserName;
	
	@FindBy(id = "txtPassword")
	WebElement objPassword;
	
	@FindBy(name = "Submit")
	WebElement objSubmit;
	
//	Define Methods
	
	public void LoginFeature(String userName, String Password) throws Throwable {
		objUserName.sendKeys(userName);
		objPassword.sendKeys(Password);
		objSubmit.click();
	}

}
