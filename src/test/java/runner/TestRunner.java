package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/report.html"},
        monochrome = true,
        tags = "@Smoke"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}