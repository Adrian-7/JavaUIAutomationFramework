package org.example;

import org.example.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String  theNameOfTheFirstTab = driver.getWindowHandle();
        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://999.md/");
        Thread.sleep(3000);
        driver.close();

        driver.switchTo().window(theNameOfTheFirstTab);
        driver.get("https://www.friv.com/");
        Thread.sleep(3000);
        driver.quit();
    }
}