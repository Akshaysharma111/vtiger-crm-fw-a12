package testng_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoForInvocation {
	// invocation 10 hai to 10 bar hello print hoga (total test run =10,passed=10,failed=0)
	
//@Test(invocationCount =10)
//public void create() {
//	System.out.println("hello");
//}
//		@Test(invocationCount =0)//run to hoga par print nhi hoga
//    	public void modify() {
//		System.out.println("hi");
//}
	@Test(invocationCount = 0)// ye stack me jaega par run nhi hoga
	public void case1() {
		System.out.println("Hey");
	}
	
	@Test(enabled = false)//ye stack me bhi nhi jaega or na run hoga
	public void case2() {
		System.out.println("hey");
	}
	@Test(invocationCount = 10, threadPoolSize = 3)//invocation 10 hai to ye 10 bar chalega par threadPollSize=3 hai to ek time pe 3 run honge isme group banege
	//3,3,3,1 ke 
	public void case3() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.quit();
	}
	
}
