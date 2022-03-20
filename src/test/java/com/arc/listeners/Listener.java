package com.arc.listeners;

import com.arc.helper.Helper;
import com.arc.report.ExtentReport;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ISuiteListener, ITestListener {

    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }

    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentReport.extentTest.pass(result.getMethod().getMethodName()+" is Passed", MediaEntityBuilder.createScreenCaptureFromBase64String(Helper.getScreenshot()).build());
    }

    public void onTestFailure(ITestResult result) {
        ExtentReport.extentTest.pass(result.getMethod().getMethodName()+" is Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(Helper.getScreenshot()).build());
    }
}
