package runner;

import Utils.Controlers;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import maps.LoginMap;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@all",
        glue = "steps",
        plugin = {"json:target/reports/CucumberReports.json","pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class RunnerTest {
    @BeforeClass
    public static void beforeClass() throws Exception {
        Controlers.setBaseURI("http://localhost:8080");
    }
}
