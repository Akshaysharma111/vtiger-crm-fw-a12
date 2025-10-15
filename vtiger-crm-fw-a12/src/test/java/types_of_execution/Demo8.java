package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo8 {
	
	//here we create group and create one xml file groupsDemo.xml
	@Test(groups = "smoke")
	public void case7() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("case 7 smoke");
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(groups = "reg")
	public void case71() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(groups = "reg")
	public void case701() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.quit();
	}
	}

