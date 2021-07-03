package cucumber.testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\Game PC-Maintake\\IdeaProjects\\KZAProject\\Feature\\kzacreate.feature",
        glue = "stepDefinitions",
        dryRun = false,
        plugin = {"pretty","html:test-output"}
)
public class TestRunner {
}
