package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Demo1 {
	@Test
	public void case1() throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "./resources/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		Thread.sleep(5000);
		driver.quit();
	}
	
}
