package CommonFunctions;




import java.io.File;
import java.io.FileWriter;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Utility.AppUtils;

public class AdminModulePage extends AppUtils{
	
//	Define Object Repository
	
	
	@FindBy(id = "mainMenuFirstLevelUnorderedList")
	WebElement objModuleList;

	@FindBy(linkText = "PIM")
	WebElement objPIM;
	
	@FindBy(id = "btnAdd")
	WebElement objAddEmployeeButton;
	
	@FindBy(id = "firstName")
	WebElement objFirstName;
	
	@FindBy(id = "lastName")
	WebElement objLastName;
	
	@FindBy(id = "chkLogin")
	WebElement objCreateLoginDetailsCheckBox;
	
	@FindBy(id = "user_name")
	WebElement objUserName;
	
	@FindBy(id = "user_password")
	WebElement objUserPassword;
	
	@FindBy(id = "re_password")
	WebElement objConfirmPassword;
	
	@FindBy(id = "btnSave")
	WebElement objSaveButton;
	
	@FindBy(linkText = "Admin")
	WebElement objAdminModule;

//	Define Methods
	
	public void getModulesList() throws Throwable {
	 	List<WebElement> mList=objModuleList.findElements(By.className("firstLevelMenu"));
	 	File fi = new File("OutputFiles/ModuleList.txt");
	 	fi.createNewFile();
	 	FileWriter fw = new FileWriter(fi);
	 	fw.write("Module List\n");
	 	for(int i=0; i<mList.size(); i++) {
	 		String mName=mList.get(i).getText();
	 		System.out.println(mName);
	 		fw.write(mName+"\n");
	 		Reporter.log((i+1)+": "+"Module Name: "+mName+"\n");
	 	}
	 	fw.close();
	 	System.out.println();
	 	Reporter.log("Login Successfull");
		
	}
	
	public void addNewEmployee(String firstName, String lastName, String userName, String password, String confrimPwd) throws Throwable {
		objPIM.click();
		Thread.sleep(2000);
		objAddEmployeeButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(objFirstName));
		objFirstName.sendKeys(firstName);
		objLastName.sendKeys(lastName);
		objCreateLoginDetailsCheckBox.click();
		objUserName.sendKeys(userName);
		objUserPassword.sendKeys(password);
		objConfirmPassword.sendKeys(confrimPwd);
		objSaveButton.click();
	}
	

}
