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

public class CreateOrganization {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
//		1.	Get the Java Representation Object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/CommanData.properties");

//		2.	Use the load() of Properties class to load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);
		
//		3.	Use the getProperty(Key) and pass the key and get the value in String format
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		
//		Login
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		
		
//		Create Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		//org name
		FileInputStream fiss = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fiss);
		Sheet sh = wb.getSheet("a12");
		//Row rw = sh.createRow(11);
		//Cell cell = rw.createCell(0);
		//cell.setCellValue("googlechrome_");
		//save the changes
		//FileOutputStream fos = new FileOutputStream("./src/test/resources/TestScriptDataToSet.xlsx");
		//wb.write(fos);
		
		Row row = sh.getRow(5);
		
		Cell cell1 = row.getCell(0);
		
		String orgName = cell1.getStringCellValue() + (int)(Math.random()*9999);;
		
		System.out.println(orgName);
		
		wb.close();
		//String orgName = "qspiders_" + (int)(Math.random()*9999);
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);
		   //no of employee
				String empno = ""+ (int)(Math.random()*9999);
				 WebElement employe= driver.findElement(By.id("employees"));
				 employe.sendKeys(empno);
			
				 //industry
				 WebElement industryDropdown = driver.findElement(By.name("industry"));
			        Select select = new Select(industryDropdown);
			        select.selectByVisibleText("Banking");
			        String selectedIndustry = select.getFirstSelectedOption().getText();

			   	 driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
//				Verification
				
				String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
				String empcount = driver.findElement(By.id("mouseArea_Employees")).getText();
				String selectind = driver.findElement(By.id("mouseArea_Industry")).getText();
				if (actOrgName.trim().equals(orgName ) &&  empcount.trim().equals(empno) && selectind.trim().equals(selectedIndustry)) {
					System.out.println("Organization created successfully!!!");
				}else {
					System.out.println("Organization could not be created successfully!!!");
				}
				
//				Logout
				WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
				
				Actions act = new Actions(driver);
				act.moveToElement(profile).build().perform();
				
				driver.findElement(By.linkText("Sign Out")).click();
				
				Thread.sleep(3000);
				driver.quit();
		
	}

}
