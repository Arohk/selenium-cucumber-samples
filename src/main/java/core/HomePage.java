package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage doStuff() throws InterruptedException {

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
		return new HomePage(driver);
	}

	public HomePage click() throws InterruptedException {
		WebElement click = driver.findElement(By.xpath("//*[@id=\"archive-link-link\"]"));
		click.click();
		Thread.sleep(3000);
		return new HomePage(driver);

	}
}
