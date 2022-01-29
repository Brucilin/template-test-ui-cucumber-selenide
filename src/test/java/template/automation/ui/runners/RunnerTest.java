package template.automation.ui.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        plugin = "pretty",
        glue = "template.automation.ui.step.definition"
)
public class RunnerTest {
    public void test() {
    }
}

