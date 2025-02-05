package CommonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	
//	Define Object Repository
	@FindBy(partialLinkText = "Suresh")
	WebElement objAdminUser;
	
	@FindBy(linkText = "Logout")
	WebElement objLogout;
	
//	Define Methods
	
	public void logoutFeature() {
		objAdminUser.click();
		objLogout.click();
	}

}
