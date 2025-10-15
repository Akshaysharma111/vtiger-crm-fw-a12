package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo4 {
	@Parameters("bro")
	@Test
	public void case4(String Browser) {
		WebDriver driver = null;
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("edge")) {
			
			System.setProperty("webdriver.edge.driver", "./resources/msedgedriver.exe");
			 driver = new EdgeDriver();
		} else if (Browser.equals("FireFox")) {
			driver = new FirefoxDriver();
		}
		driver.quit();
	}
}
