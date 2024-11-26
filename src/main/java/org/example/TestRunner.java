package org.example;

import org.example.managers.DriverManager;
import org.openqa.selenium.WebDriver;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");

        Thread.sleep(5000);
        DriverManager.getInstance().getDriver().quit();
    }
}