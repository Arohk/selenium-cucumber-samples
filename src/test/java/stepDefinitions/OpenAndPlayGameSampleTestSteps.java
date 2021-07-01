package stepDefinitions;

import org.testng.reporters.jq.Main;
import pages.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class OpenAndPlayGameSampleTestSteps {
	WebDriver driver;
	HomePage homePage;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "dependencies/chromedriver.exe");
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
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
	public void the_user_searches_for_game_and_opens_it(String gameName) throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickGames()
				.clickSearch()
				.inputGameName(gameName)
				.clickZeusGame();

	}

	@Then("the selected game should be opened successfully")
	public void the_selected_game_should_be_opened_successfully() {
	}

	@When("the user's current balance is noted before playing the game")
	public void theUserSCurrentBalanceIsNotedBeforePlayingTheGame() throws InterruptedException {

	}

	@And("the user plays one round")
	public void theUserPlaysOneRound() throws InterruptedException {

	}

	@And("the user closes the game")
	public void theUserClosesTheGame() {
	}

	@Then("the user should have a lower balance than before playing the game")
	public void theUserShouldHaveALowerBalanceThanBeforePlayingTheGame() {
	}

	@After public void tearDown() {
		driver.quit();
	}
}
