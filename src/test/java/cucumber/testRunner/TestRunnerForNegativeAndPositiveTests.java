package cucumber.testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Feature/Login.feature",
        glue = "stepDefinitions",
        dryRun = false,
        plugin = {"pretty","html:test-output"}
)
public class  TestRunnerForNegativeAndPositiveTests{
}
