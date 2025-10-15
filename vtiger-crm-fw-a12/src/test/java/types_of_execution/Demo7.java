package types_of_execution;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
public class Demo7 {
	//here we create group and create one xml file groupsDemo.xml
	@Test(groups = "smoke")
	public void case6() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("case 6 smoke");
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(groups = "reg")
	public void case61() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(groups = "reg")
	public void case601() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.quit();
	}
}
