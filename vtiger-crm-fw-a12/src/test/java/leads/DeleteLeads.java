package leads;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;

public class DeleteLeads {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fUtil = new FileUtility();
//		Get the data from properties file
		
		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");
		
//		Get the data from excel file
		String lastName = fUtil.getStringDataFromExcelFile("lead", 1, 0);
		String compName = fUtil.getStringDataFromExcelFile("lead", 5, 1);
		
//		Open Browser 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
//		Login
		driver.get(URL);
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(USERNAME);
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		

		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(2000);
		
		
//select  leads
		driver.findElement(By.id("32")).click();
		driver.findElement(By.cssSelector("input[value='Delete']")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
//Logout
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();

//Close browser
		Thread.sleep(3000);
		driver.quit();

		
		
}
}
