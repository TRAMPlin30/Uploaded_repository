package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"steps"},
        tags = "@smoke",
        monochrome = false,
        dryRun = false)
public class MainRunnerTest extends AbstractTestNGCucumberTests { }
