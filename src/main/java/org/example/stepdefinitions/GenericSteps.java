package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the URL contains the following keyword {string}")
    public void theURLContainsTheFollowingKeyword(String collectKeyword) throws InterruptedException {
        Thread.sleep(2000);
        boolean containsKeyword = driver.getCurrentUrl().contains(collectKeyword);
        Assertions.assertTrue(containsKeyword, "The URL contains: " + collectKeyword);
    }
}
