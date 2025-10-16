package organization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import object_repository.HomePage;
import object_repository.OrgPage;
import object_repository.VerifyOrgPage;

public class CreateOrganization extends BaseClass{
	
		
		
@Test
public void createOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {

//	Create Organization
	HomePage hp = new HomePage(driver);
	hp.getOrgLink().click();

	OrgPage op = new OrgPage(driver);

	op.getOrgPlusIcon().click();

	FileUtility fUtil = new FileUtility();
	String orgName = fUtil.getStringDataFromExcelFile("org", 3, 0) + JavaUtility.generateRandomNum();

	WebElement orgField = op.getOrgField();
	orgField.sendKeys(orgName);

//	Save 
	op.getSaveBtn().click();

//	Verification
	VerifyOrgPage vop = new VerifyOrgPage(driver);
	String actOrgName = vop.getActOrgName().getText();

	Assert.assertEquals(actOrgName, orgName);
	
//	if (actOrgName.equals(orgName + "abc")) {
//		System.out.println("Created Organization successfully!!!!");
//	} else {
//		System.out.println("Failed....");
//	}

}

}
