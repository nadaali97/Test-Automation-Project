package base;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.JSWaiter;

public class PageBase {
	protected final WebDriver driver;
	protected final WebDriverWait wait;
	protected final JSWaiter jsWaiter;

	private static final Logger LOGGER = Logger.getLogger(PageBase.class);

	public PageBase(WebDriver driver) {
		this(driver, 60);
	}

	public PageBase(WebDriver driver, long waitInSeconds) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, waitInSeconds);
		this.jsWaiter = new JSWaiter(driver);
	}
	
	public boolean isElementVisible(By elementLocator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
			LOGGER.info("Element matching this locator [ " + elementLocator + " ] is visible");
			return true;
		} catch (Exception e) {
			LOGGER.error("Element matching this locator [ " + elementLocator + " ] is not visible");
			return false;
		}
	}
	
	public boolean isElementClickable(By elementLocator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			LOGGER.info("Element matching this locator [" + elementLocator + "] is Clickable.");
			return true;
		} catch (Exception e) {
			LOGGER.error("Element matching this locator [" + elementLocator + "] is not Clickable.");
			return false;
		}
	}
	public void setElement( By elementLocator, String value) {

		isElementVisible(elementLocator);
		try {
			driver.findElement(elementLocator).clear();
			driver.findElement(elementLocator).sendKeys(value);
			LOGGER.info("Type " + value);
		} catch (Exception e) {
			LOGGER.error("Can't type :" + value);
		}

	}
	
	public void clickElement( By elementLocator) {

		if (isElementClickable(elementLocator)) {
			WebElement element = driver.findElement(elementLocator);
			element.click();
			LOGGER.info("Click on element locator: " + elementLocator);
		} else {
			LOGGER.error("Cannot Click on element locator: " + elementLocator);
		}
	}
	public void controlClick( WebElement link) {
		
		try {
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.LEFT_CONTROL).click(link).keyUp(Keys.LEFT_CONTROL).build().perform();
			LOGGER.info("[Control +Click] successfully performed ");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("[Control +Click] : failed due to  " + e.getMessage());

		}
	}
	
	public void pressEnter( By elementLocator) {
		WebElement element = driver.findElement(elementLocator);
		try {
			Actions actions = new Actions(driver);
			element.sendKeys(Keys.ENTER);
			LOGGER.info("[press ENTER] successfully performed ");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("[press ENTER] : failed due to  " + e.getMessage());

		}
	}
	
	public void selectTab(String window) {
		
		driver.switchTo().window(window);
	}
	
	public String getCurrentWindow() {
		
		return driver.getWindowHandle();
		
	}
	

	public  Set<String> getAllWindows() {
		
		return driver.getWindowHandles();
		
	}

}
