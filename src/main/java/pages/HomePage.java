package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Home Page, which is accessed right after hitting the website.
 */
public class HomePage extends BasePage {

	private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

	@FindBy(xpath = "//button[@data-target='#login-guest-modal']")
	private WebElement loginButton;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Clicks the login button
	 *
	 * @return AccountLoginModal
	 */
	public AccountLoginModal clickLogin() {
		LOG.info("Clicking on the login button");
		loginButton.click();
		return new AccountLoginModal(driver);
	}
}
