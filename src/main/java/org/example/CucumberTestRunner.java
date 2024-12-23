package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/org/example/features",
        glue = "org/example/stepdefinitions",
        tags = ""
)
public class CucumberTestRunner {
}
