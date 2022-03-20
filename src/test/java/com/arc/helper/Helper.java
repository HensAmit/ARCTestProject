package com.arc.helper;

import com.arc.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Helper {

    public static String getFolderName(){
        return "TestFolder_" + getCurrentTimeStamp();
    }

    private static String getCurrentTimeStamp(){
        return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
    }

    public static String getScreenshot(){
        return ((TakesScreenshot)DriverManager.driver).getScreenshotAs(OutputType.BASE64);
    }
}
