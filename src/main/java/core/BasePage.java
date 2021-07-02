package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private static final int TIMEOUT = 10;
	private static final int POLLING = 100;

	protected WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	protected void waitForElementToAppear(WebElement locator) {
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	protected void waitForElementToBeClickable(WebElement locator) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
		Actions actions = new Actions(driver);
		actions.moveToElement(locator);
		actions.click(locator);
		Action action = actions.build();
		action.perform();
	}

}
