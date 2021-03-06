package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty", "html:target/cucumber-report.html" },
		features = { "src/test/resources/functionalTests/OpenAndPlayGameSampleTest.feature" },
		glue = {"stepDefinitions"}
)

public class OpenAndPlayGameSampleTest {
}
