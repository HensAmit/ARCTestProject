package com.arc.tests;

import com.arc.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.arc.driver.DriverManager.driver;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
        DriverManager.initDriver();
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
