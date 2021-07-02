package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Text;

import java.net.URISyntaxException;

/*
 * Main Page, accessible after the user has logged in from the Home Page
 */
public class MainPage extends BasePage {
	private static final Logger LOG = LoggerFactory.getLogger(MainPage.class);

	private static Integer initialBalance;

	@FindBy(xpath = "//a[@data-link-name='games']")
	private WebElement gamesButton;

	@FindBy(xpath = "//i[@class='ds-icon-material search-icon casino-search-icon']")
	private WebElement searchButton;

	@FindBy(xpath = "//input[@name='search_game']")
	private WebElement inputGameField;

	@FindBy(xpath = "//img[@alt='Ancient Fortunes: Zeus']")
	private WebElement zeusGameImage;

	@FindBy(xpath = "//span[@class='user-balance-item-label'][text()='Balance']/following-sibling::span")
	private WebElement balanceField;

	@FindBy(xpath = "//span[@class='user-balance-item-label'][text()='Balance']/following-sibling::span")
	private WebElement logoButton;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Clicks the games button
	 *
	 * @return MainPage
	 */
	public MainPage clickGames() {
		LOG.info("Clicking games");
		waitForElementToBeClickable(gamesButton);
		gamesButton.click();
		return new MainPage(driver);
	}

	/**
	 * Clicks the search button
	 *
	 * @return MainPage
	 */
	public MainPage clickSearch() {
		LOG.info("Clicking search");
		searchButton.click();
		return new MainPage(driver);
	}

	/**
	 * Inputs the game name
	 *
	 * @return MainPage
	 */
	public MainPage inputGameName(String gameName) {
		LOG.info("Setting Game Name");
		inputGameField.clear();
		inputGameField.sendKeys(gameName);
		return new MainPage(driver);
	}

	/**
	 * Clicks the Zeus game
	 *
	 * @return MainPage
	 */
	public ZeusGamePage clickZeusGame() throws URISyntaxException {
		LOG.info("Clicking Zeus Game");
		zeusGameImage.click();
		return new ZeusGamePage(driver);
	}

	/**
	 * Notes the current money balance
	 *
	 * @return MainPage
	 */
	public MainPage noteCurrentBalance(){
		LOG.info("Checking for current balance");
		initialBalance = Integer.valueOf(balanceField.getText().replaceAll("[^a-zA-Z0-9]", ""));
		LOG.info("Initial balance is: {}", initialBalance);
		return new MainPage(driver);
	}

	/**
	 * Notes the current money balance
	 *
	 * @return MainPage
	 */
	public boolean isBalanceAdjusted(){
		LOG.info("Checking for adjustment in balance");
		waitForElementToBeClickable(balanceField);
		Integer adjustedBalance = Integer.valueOf(balanceField.getText().replaceAll("[^a-zA-Z0-9]", ""));
		LOG.info("Adjusted balance is: {}", adjustedBalance);
		return  adjustedBalance < initialBalance;
	}

}
