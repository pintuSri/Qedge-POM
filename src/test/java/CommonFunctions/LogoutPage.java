package CommonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	
//	Define Object Repository
	@FindBy(partialLinkText = "Suresh")
	WebElement objAdminUser;
	
	@FindBy(partialLinkText = "Saara")
	WebElement objUserEmployee;
	
	@FindBy(linkText = "Logout")
	WebElement objLogout;
	
//	Define Methods
	
	public void logoutFeature() {
		try {
			if(objAdminUser.isDisplayed()) {
				objAdminUser.click();
			}
			if(objUserEmployee.isDisplayed()) {
				objUserEmployee.click();
			}
			Thread.sleep(2000);
			objLogout.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
