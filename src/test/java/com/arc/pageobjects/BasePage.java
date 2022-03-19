package com.arc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static com.arc.driver.DriverManager.*;

public class BasePage {
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public void click(By by){
        driver.findElement(by).click();
    }
}
