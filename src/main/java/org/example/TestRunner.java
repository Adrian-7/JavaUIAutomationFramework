package org.example;

import org.example.managers.DriverManager;
import org.example.managers.RandomDataManager;
import org.example.managers.ScrollManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://google.com/");
        System.out.println("The driver is on page: " + driver.getCurrentUrl());

        String  theNameOfTheFirstTab = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("The driver is on page: " + driver.getCurrentUrl());
        Thread.sleep(2000);

        WebElement myAccountDropDown = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccountDropDown.click();

        WebElement registerLink = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Register']"));
        registerLink.click();
        System.out.println("The driver is on page: " + driver.getCurrentUrl());
        Thread.sleep(1000);

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        String firstNameData = RandomDataManager.getRandomFirstName();
        System.out.println("First Name: " + firstNameData);
        firstNameInput.sendKeys(RandomDataManager.getRandomFirstName());

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        String lastNameData = RandomDataManager.getRandomLastName();
        System.out.println("Last Name: " + lastNameData);
        lastNameInput.sendKeys(RandomDataManager.getRandomLastName());

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String emailData = RandomDataManager.getRandomEmail();
        System.out.println("Email: " + emailData);
        emailInput.sendKeys(RandomDataManager.getRandomEmail());

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String passwordData = RandomDataManager.getRandomPassword();
        System.out.println("Password: " + passwordData);
        passwordInput.sendKeys(RandomDataManager.getRandomPassword());

        WebElement privacyToggleBar = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        ScrollManager.scrollToElement(privacyToggleBar);
        Thread.sleep(500);
        privacyToggleBar.click();

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        Thread.sleep(10000);
        driver.close();

        driver.switchTo().window(theNameOfTheFirstTab);
        driver.get("https://www.friv.com/");
        driver.quit();
    }
}