package pages;

import core.BasePage;
import gherkin.lexer.Pa;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sikuli.script.*;
import org.sikuli.script.ImagePath;

import java.net.URISyntaxException;
import java.net.URL;

public class ZeusGamePage extends BasePage {

	private static final Logger LOG = LoggerFactory.getLogger(ZeusGamePage.class);
	private String basePath;
	Screen s = new Screen();
	Pattern gameTitle = new Pattern("GameTitle.png");
	Pattern continueButton = new Pattern("ContinueButton.png");

	@FindBy(xpath = "//a[@data-link-name='games']")
	private WebElement gamesButton;

	public ZeusGamePage(WebDriver driver) throws URISyntaxException {
		super(driver);
		URL resourceFolderURL = this.getClass().getClassLoader().getResource("images");
		basePath = resourceFolderURL.toURI().getPath() + "/";

	}

	public boolean isGameLoaded() throws FindFailed {
		LOG.info("Verifying image for loaded game");
		s.wait(basePath + "GameTitle.png", 20);
		s.find(basePath + "GameTitle.png");
		return true;
	}

	public ZeusGamePage clickContinue() throws FindFailed, URISyntaxException {
		LOG.info("Verifying image for loaded game");
		s.wait(basePath + "ContinueButton.png", 30);
		s.click(basePath + "ContinueButton.png");
		return new ZeusGamePage(driver);
	}



}
