package leads;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;

public class CreateLeads {
public static void main(String[] args) throws IOException, InterruptedException {
	FileUtility fUtil = new FileUtility();
//	Get the data from properties file
	
	String BROWSER = fUtil.getDataFromPropertiesFile("bro");
	String URL = fUtil.getDataFromPropertiesFile("url");
	String USERNAME = fUtil.getDataFromPropertiesFile("un");
	String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");
	
//	Get the data from excel file
	String lastName = fUtil.getStringDataFromExcelFile("lead", 1, 0);
	String compName = fUtil.getStringDataFromExcelFile("lead", 5, 1);
	
//	Open Browser 
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
//	Login
	driver.get(URL);
	WebElement username = driver.findElement(By.name("user_name"));
	username.sendKeys(USERNAME);
	WebElement password = driver.findElement(By.name("user_password"));
	password.sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(3000);
	
// create leads
	driver.findElement(By.linkText("Leads")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
	
//	Filling data to the form
	WebElement lastnameField = driver.findElement(By.name("lastname"));
	lastnameField.sendKeys(lastName);
	WebElement compnameField = driver.findElement(By.name("company"));
	compnameField.sendKeys(compName);
	Thread.sleep(3000);
	
//	Save 
	driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
	
//	Verification
	String actlastName = driver.findElement(By.id("dtlview_Last Name")).getText();
	String actcompName = driver.findElement(By.id("dtlview_Company")).getText();

	if (actlastName.equals(lastName) && actcompName.equals(compName)) {
		System.out.println("Created lead successfully!!!!");
	} else {
		System.out.println("Failed....");
	}
//	Logout
	WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

	Actions act = new Actions(driver);
	act.moveToElement(profilePic).build().perform();

	Thread.sleep(2000);
	driver.findElement(By.linkText("Sign Out")).click();

//	Close browser
	Thread.sleep(3000);
	driver.quit();

}





}
}
