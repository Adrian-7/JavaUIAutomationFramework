package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.example.managers.DriverManager;

public class Hooks {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("The execution of the test suite started");
    }

    @Before
    public void executedBeforeEachTest(){
        System.out.println("Test started");
    }

    @After
    public void executeAfterEachTest(){
        System.out.println("The test is completed");
        DriverManager.getInstance().quiteTheDriver();
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("The test execution finished");
    }
}
