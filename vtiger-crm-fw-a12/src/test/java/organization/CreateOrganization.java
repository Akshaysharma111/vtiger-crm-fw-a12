package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganization {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
		
//		Login
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		
		username.sendKeys("admin");
		password.sendKeys("manager");
		
		driver.findElement(By.id("submitButton")).click();

//		Create Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		//org name
		String orgName = "qspiders_" + (int)(Math.random()*9999);
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
