package org.example.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;
    private static final String Web_Driver_Type = "Chrome";

    private DriverManager(){
        switch (Web_Driver_Type.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The Chrome Driver is opened");
                break;
            case "EDGE":
                driver = new ChromeDriver();
                System.out.println("The Edge browser is opened");
                break;
            default:
                System.out.println("The Browser type is not recognize");
        }
    }

    public static DriverManager getInstance(){
        if (instance == null)
            instance = new DriverManager();
        return instance;
    }

    public WebDriver getDriver(){
        return driver;
    }
}
