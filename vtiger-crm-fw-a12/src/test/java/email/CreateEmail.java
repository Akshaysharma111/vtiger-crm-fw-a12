package email;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateEmail {
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
		//email
		WebElement email = driver.findElement(By.linkText("Email"));
		email.click();
		Thread.sleep(2000);
		WebElement compose = driver.findElement(By.linkText("Compose"));
		compose.click();
		Thread.sleep(2000);
		WebElement selected = driver.findElement(By.name("parent_type"));
		 Select select = new Select(selected);
	        select.selectByVisibleText("Leads");
	        WebElement plus = driver.findElement(By.cssSelector("img[alt='Select']"));
	        plus.click();
	   
}
}
