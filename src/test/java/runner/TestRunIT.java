package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepdef"},
		tags = "@SearchTest",
		plugin = { "pretty", "html:results/cucumber-reports/WebTestReport.html",
		"json:results/cucumber-reports/CucumberTestReport.json" }
		)

public class TestRunIT {
	
}
