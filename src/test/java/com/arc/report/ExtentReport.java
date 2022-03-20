package com.arc.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {

    private static ExtentReports extent;
    public static ExtentTest extentTest;

    public static void initReport(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("test-result//index.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("ARC Test Report");
        spark.config().setReportName("ARC Test Report");
    }

    public static void createTest(String testName){
        extentTest = extent.createTest(testName);
    }

    public static void flushReports(){
        extent.flush();
    }
}
