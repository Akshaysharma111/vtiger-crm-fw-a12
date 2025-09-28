package contact;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/index.php?action=index&module=Home");

//			Login
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));

		username.sendKeys("admin");
		password.sendKeys("manager");

		driver.findElement(By.id("submitButton")).click();

		// create contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		WebElement lastnamefield = driver.findElement(By.name("lastname"));
		lastnamefield.sendKeys("kumar");
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		// verification
		String actuallastname = driver.findElement(By.id("mouseArea_Last Name")).getText();
		if (actuallastname.equals(lastnamefield)) {
			System.out.println("contact created succesfully");
		} else
			System.out.println("failed");

		// logout
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();

		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
