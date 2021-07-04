package stepDefinitions;

import org.sikuli.script.FindFailed;
import org.testng.Assert;
import pages.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.ZeusGamePage;

import java.net.URISyntaxException;

public class OpenAndPlayGameSampleTestSteps {
	WebDriver driver;
	HomePage homePage;
	ZeusGamePage zeusGamePage;
	MainPage mainPage;

	@Before
	public void setUp() throws URISyntaxException {
		System.setProperty("webdriver.chrome.driver", "dependencies/chromedriver.exe");
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
		zeusGamePage = new ZeusGamePage(driver);
		mainPage = new MainPage(driver);
		driver.get("https://www.1000000bet.com/");
		driver.manage().window().maximize();
	}

	@Given("the user logs in with \"([^\"]*)\" and password \"([^\"]*)\"")
	public void the_user_logs_in_with_and_default_password(String userName, String password) throws InterruptedException {
		homePage.clickLogin()
				.inputUsername(userName)
				.inputPassword(password)
				.clickLogin();
	}

	@When("the user searches for \"([^\"]*)\" game and opens it")
	public void the_user_searches_for_game_and_opens_it(String gameName) throws URISyntaxException {
		mainPage.clickGames()
				.clickSearch()
				.inputGameName(gameName)
				.clickZeusGame();
	}

	@Then("the selected game should be opened successfully")
	public void the_selected_game_should_be_opened_successfully() throws FindFailed {
		Assert.assertTrue(zeusGamePage.isGameLoaded());
	}

	@When("the user's current balance is noted before playing the game")
	public void theUserSCurrentBalanceIsNotedBeforePlayingTheGame() {
		mainPage.noteCurrentBalance();
	}

	@And("the user plays one round")
	public void theUserPlaysOneRound() throws URISyntaxException, FindFailed {
		zeusGamePage.clickContinue()
				.clickPlay();
	}

	@And("the user closes the game")
	public void theUserClosesTheGame() {
		zeusGamePage.clickClose();
	}

	@Then("the user should have a lower balance than before playing the game")
	public void theUserShouldHaveALowerBalanceThanBeforePlayingTheGame() {
		Assert.assertTrue(mainPage.isBalanceAdjusted());
	}

	@After public void tearDown() {
		driver.quit();
	}
}
