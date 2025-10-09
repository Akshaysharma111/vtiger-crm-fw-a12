package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
		WebDriver driver;
		Actions act;
		

		public WebDriverUtility(WebDriver driver) {
			this.driver = driver;
			this.act = new Actions(driver);
	
		}
		// Maximizes the browser window.
		 
		public void maximizeWindow() {
			driver.manage().window().maximize();
		}

		
		// Makes the browser full screen.
		
		public void fullscreenWindow() {
			driver.manage().window().fullscreen();
		}
		
		public void openUrl() {
			driver.get("http://localhost:8888/");
		}
		
		//Applies implicit wait for the page to load.
		 
		public void waitForPageLoad() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		}

		// ===== Dropdown Select Methods =====
		  //Selects dropdown option by index.
		 
		public void select(WebElement element, int index) {
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}

		// Selects dropdown option by value.
		
		public void select(WebElement element, String value) {
			Select sel = new Select(element);
			sel.selectByValue(value);
		}

		//Selects dropdown option by visible text.
		 
		public void select(String visibleText, WebElement element) {
			Select sel = new Select(element);
			sel.selectByVisibleText(visibleText);
		}
		// ===== Basic Mouse Actions =====

		/**
		 * Performs mouse hover on the given element.
		 * 
		 * @param element The target WebElement
		 */
		public void hover(WebElement element) {
			act.moveToElement(element).build().perform();
		}

		/**
		 * Performs right-click on the given element.
		 * 
		 * @param element The target WebElement
		 */
		public void rightClick(WebElement element) {
			act.contextClick(element).build().perform();
		}

		/**
		 * Performs double-click on the given element.
		 * 
		 * @param element The target WebElement
		 */
		public void doubleClickOnElement(WebElement element) {
			act.doubleClick(element).perform();
		}

		/**
		 * Clicks and holds the given element.
		 * 
		 * @param element The target WebElement
		 */
		public void clickAndHold(WebElement element) {
			act.clickAndHold(element).perform();
		}

		/**
		 * Drags source element and drops onto target element.
		 * 
		 * @param source Source element to drag
		 * @param target Target element to drop onto
		 */
		public void dragAndDrop(WebElement source, WebElement target) {
			act.dragAndDrop(source, target).perform();
		}

		/**
		 * Moves slider input element by offset.
		 * 
		 * @param slider  WebElement slider
		 * @param xOffset Horizontal offset to move
		 */
		public void moveSliderByOffset(WebElement slider, int xOffset) {
			act.clickAndHold(slider).moveByOffset(xOffset, 0).release().perform();
		}

		// ===== Browser Navigation Utilities =====

		/**
		 * Navigates back in browser history.
		 */
		public void navigateBack() {
			driver.navigate().back();
		}

		/**
		 * Navigates forward in browser history.
		 */
		public void navigateForward() {
			driver.navigate().forward();
		}

		/**
		 * Refreshes the current page.
		 */
		public void refreshPage() {
			driver.navigate().refresh();
		}
		// ===== Alert Handling =====

				/**
				 * Accepts alert popup.
				 */
				public void acceptAlert() {
					driver.switchTo().alert().accept();
				}

				/**
				 * Dismisses alert popup.
				 */
				public void dismissAlert() {
					driver.switchTo().alert().dismiss();
				}

				/**
				 * Returns alert text.
				 * 
				 * @return Alert text
				 */
				public String getAlertText() {
					return driver.switchTo().alert().getText();
				}

				/**
				 * Sends text to alert prompt.
				 * 
				 * @param text Text to send
				 */
				public void sendTextToAlert(String text) {
					driver.switchTo().alert().sendKeys(text);
				}

}
