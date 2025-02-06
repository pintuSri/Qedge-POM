package CommonFunctions;




import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AdminModulePage {
	
//	Define Object Repository
	
	
	@FindBy(id = "mainMenuFirstLevelUnorderedList")
	WebElement objModuleList;

	@FindBy(linkText = "PIM")
	WebElement objPIM;
	
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
	

}
