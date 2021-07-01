package stepDefinitions;

import core.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class OpenAndPlayGameSampleTestSteps {
	WebDriver driver;
	HomePage homePage;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "dependencies/chromedriver.exe");
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
	}

	@Given("the user logs in with \"([^\"]*)\" and default password")
	public void the_user_logs_in_with_and_default_password(String arg1) {

	}

	@When("the user searches for \"([^\"]*)\" game and opens it")
	public void the_user_searches_for_game_and_opens_it(String arg1) {

	}

	@Then("the selected game should be opened successfully")
	public void the_selected_game_should_be_opened_successfully() {

	}

	@When("the user's current balance is noted before playing the game")
	public void theUserSCurrentBalanceIsNotedBeforePlayingTheGame() throws InterruptedException {
		homePage.doStuff();
	}

	@And("the user plays one round")
	public void theUserPlaysOneRound() throws InterruptedException {
		homePage.click();
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
