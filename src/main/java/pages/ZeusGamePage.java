package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sikuli.script.*;

import java.net.URISyntaxException;
import java.net.URL;

public class ZeusGamePage extends BasePage {

	private static final Logger LOG = LoggerFactory.getLogger(ZeusGamePage.class);

	private String basePath;
	private Screen sikuliScreen = new Screen();

	@FindBy(xpath = "//button[@id='game-frame-close']")
	private WebElement closeButton;

	public ZeusGamePage(WebDriver driver) throws URISyntaxException {
		super(driver);
		URL resourceFolderURL = this.getClass().getClassLoader().getResource("images");
		basePath = resourceFolderURL.toURI().getPath() + "/";

	}

	/**
	 * Checks if the game is loaded correctly by displaying the title in the canvas
	 *
	 * @return true if the game is loaded correctly.
	 */
	public boolean isGameLoaded() throws FindFailed {
		LOG.info("Verifying image for loaded game");
		sikuliScreen.wait(basePath + "GameTitle.png", 20);
		sikuliScreen.find(basePath + "GameTitle.png");
		return true;
	}

	/**
	 * Clicks the continue image
	 *
	 * @return ZeusGamePage
	 */
	public ZeusGamePage clickContinue() throws FindFailed, URISyntaxException {
		LOG.info("Clicking continue");
		sikuliScreen.wait(basePath + "ContinueButton.png", 30);
		sikuliScreen.click(basePath + "ContinueButton.png");
		return new ZeusGamePage(driver);
	}

	/**
	 * Clicks the play image
	 *
	 * @return ZeusGamePage
	 */
	public ZeusGamePage clickPlay() throws FindFailed, URISyntaxException {
		LOG.info("Clicking play");
		sikuliScreen.wait(basePath + "PlayButton.png", 10);
		sikuliScreen.click(basePath + "PlayButton.png");
		return new ZeusGamePage(driver);
	}

	/**
	 * Clicks the close button
	 *
	 * @return MainPage
	 */
	public MainPage clickClose() {
		LOG.info("Clicking close");
		closeButton.click();
		return new MainPage(driver);
	}

}
