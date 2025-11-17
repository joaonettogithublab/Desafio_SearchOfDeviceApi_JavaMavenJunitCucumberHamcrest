package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber. class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@SmokeTest",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
)
public class CucumberTestRunner {
    // Nenhum método adicional necessário, JUnit cuida da execução
}