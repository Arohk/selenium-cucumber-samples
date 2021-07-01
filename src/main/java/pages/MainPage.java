package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Main Page, accessible after the user has logged in from the Home Page
 */
public class MainPage extends BasePage {
	private static final Logger LOG = LoggerFactory.getLogger(MainPage.class);

	@FindBy(xpath = "//a[@data-link-name='games']")
	private WebElement gamesButton;

	@FindBy(xpath = "//i[@class='ds-icon-material search-icon casino-search-icon']")
	private WebElement searchButton;

	@FindBy(xpath = "//input[@name='search_game']")
	private WebElement inputGameField;

	@FindBy(xpath = "//img[@alt='Ancient Fortunes: Zeus']")
	private WebElement zeusGameImage;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public MainPage clickGames() {
		LOG.info("Clicking games");
		gamesButton.click();
		return new MainPage(driver);
	}

	public MainPage clickSearch() {
		LOG.info("Clicking search");
		searchButton.click();
		return new MainPage(driver);
	}

	public MainPage inputGameName(String gameName) {
		LOG.info("Setting Game Name");
		inputGameField.clear();
		inputGameField.sendKeys(gameName);
		return new MainPage(driver);
	}

	public MainPage clickZeusGame() throws InterruptedException {
		LOG.info("Clicking Zeus Game");
		zeusGameImage.click();
		Thread.sleep(5000);
		return new MainPage(driver);
	}

}
