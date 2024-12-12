package org.example;

import org.example.managers.DriverManager;
import org.example.managers.RandomDataManager;
import org.example.pageobjects.AccountPage;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.LoginPage;
import org.example.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegisterFlowWithJunit {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeAll
    public static void beforeAllTheTest(){
        System.out.println("This method is run before all the test");
    }

    @BeforeEach
    public void beforeEachTest(){
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");

        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("User is redirected to Account page when registering with valid data")
    public void registerFlowWithValidDataRedirectsTheUserToAccountPage() throws InterruptedException {

        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
        registerPage.enableTheToggleBar();
        registerPage.clickOnTheContinueBtn();

        Thread.sleep(3000);

        boolean urlContainSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainSuccessKeyword, "The URL of the page contain the success keyword");
    }

        @Test
        @DisplayName("The user remains on the Register page when registering without accepting the terms and conditions")
        public void userRemainOnRegisterPageWhenRegisteringWithoutAcceptingPrivacyRules() throws InterruptedException {
            String firstName = RandomDataManager.getRandomFirstName();
            String lastName = RandomDataManager.getRandomLastName();
            String email = RandomDataManager.getRandomEmail();
            String password = RandomDataManager.getRandomPassword();

            registerPage.completeTheRegisterForm(firstName, lastName, email, password);
            registerPage.clickOnTheContinueBtn();

            Thread.sleep(3000);

            Assertions.assertTrue(driver.getCurrentUrl().contains("register"), "The page url has the keyword register");
        }

        @Test
        @DisplayName("Navigate to Login page from Register  Page")
        public void navigateToLoginPageFromRegisterPage(){
        registerPage.navigateToLoginPage();
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"));
        }

        @AfterEach
        public void afterEachTest(){
            DriverManager.getInstance().quiteTheDriver();
        }

        @AfterAll
        public static void afterAllTheTests(){
            System.out.println("This methods is executed after all the tests");
        }
    }
