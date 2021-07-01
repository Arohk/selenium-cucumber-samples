package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountLoginModal extends BasePage {
	private static final Logger LOG = LoggerFactory.getLogger(AccountLoginModal.class);

	@FindBy(xpath = "//input[@id='login_form[username]']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@id='login-modal-password-input']")
	private WebElement passwordField;

	@FindBy(xpath = "//div[@class='modal-action-bar']/button[@type='submit']")
	private WebElement loginButton;

	public AccountLoginModal(WebDriver driver) {
		super(driver);
	}

	public AccountLoginModal inputUsername(String userName) {
		LOG.info("Setting username");
		userNameField.click();
		userNameField.clear();
		userNameField.sendKeys(userName);
		return new AccountLoginModal(driver);
	}

	public AccountLoginModal inputPassword(String password) {
		LOG.info("Setting password");
		passwordField.click();
		passwordField.clear();
		passwordField.sendKeys(password);
		return new AccountLoginModal(driver);
	}

	public MainPage clickLogin() throws InterruptedException {
		LOG.info("Clicking Login");
		loginButton.click();
		Thread.sleep(5000);
		return new MainPage(driver);
	}
}
