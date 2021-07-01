package stepDefinitions;

import cucumber.api.java.en.*;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OpenAndPlayGameSampleTestSteps {
	private static WebDriver driver;

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
		System.setProperty("webdriver.chrome.driver", "dependencies/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");

		WebElement lucky = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[2]"));
		WebElement dismiss = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
		try {
			dismiss.click();
		} catch (Exception e) {

		}

		try {
			lucky.click();
		} catch (Exception e) {

		}
		Thread.sleep(3000);
		driver.quit();
	}

	@And("the user plays one round")
	public void theUserPlaysOneRound() {
	}

	@And("the user closes the game")
	public void theUserClosesTheGame() {
	}

	@Then("the user should have a lower balance than before playing the game")
	public void theUserShouldHaveALowerBalanceThanBeforePlayingTheGame() {
	}
}