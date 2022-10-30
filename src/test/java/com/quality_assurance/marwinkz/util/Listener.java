package com.quality_assurance.marwinkz.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    private static DataBaseUtil dbUtil = DataBaseUtil.getInstance();
    private static final String FAIL_QUERY = "update  users set test_status='Failed'";
    private static final String SUCCESS_QUERY = "update  users set test_status='OK'";
    private static final String FAIL_QUERY_INSERT = "insert into  status(status_name) values ('FAILED');";
    private static final String SUCCESS_QUERY_INSERT = "insert into  status(status_name) values ('OK');";
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test Started " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println("Test Success " + iTestResult.getName());
        dbUtil.executeQuery(SUCCESS_QUERY);
        dbUtil.executeQuery(SUCCESS_QUERY_INSERT);

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test Failed " + iTestResult.getName());
        dbUtil.executeQuery(FAIL_QUERY);
        dbUtil.executeQuery(FAIL_QUERY_INSERT);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test Skipped " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Test finished " + iTestContext.getName());
    }
}