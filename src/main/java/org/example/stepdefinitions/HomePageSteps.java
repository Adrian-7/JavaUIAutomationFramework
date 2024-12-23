package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.managers.DriverManager;
import org.example.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("The Home Page is displayed")
    public void theHomePageIsDisplayed() {
        System.out.println("Code from first step");
        driver.get("https://tekwillacademy-opencart.online/");
    }

    @And("Register Page is accessed from the Home Page buttons")
    public void registerPageIsAccessedFromTheHomePageButtons() {
        homePage.navigateToRegisterPage();
        System.out.println("Code from step 2");
    }
}
