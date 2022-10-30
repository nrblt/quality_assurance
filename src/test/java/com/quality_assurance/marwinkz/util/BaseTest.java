package com.quality_assurance.marwinkz.util;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.quality_assurance.marwinkz.constants.Constants;
import com.quality_assurance.marwinkz.pages.LoginPage;
import com.quality_assurance.marwinkz.pages.MainPage;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.source.tree.SynchronizedTree;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static com.quality_assurance.marwinkz.constants.Constants.*;

public class BaseTest {
    DriverSettings driverSettings = new DriverSettings();
    PropertiesReader propertiesReader = ConfigFactory.create(PropertiesReader.class);
    public static ExtentReports extent;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest extentTest;

    private static Properties properties = PropertiesUtil.getInstance().getProperties();
    private static ActionsUtil actionsUtil = ActionsUtil.getInstance();
    private static WebDriverWaitUtil webDriverWaitUtil = WebDriverWaitUtil.getInstance();
    private WebDriver webDriver;

    @BeforeTest
    public void setUp() {
        extent = new ExtentReports();
        Constants.HTML_REPORT_PATH = "target//html/MarwinKzAutomationReport" + System.currentTimeMillis() + ".html";
        htmlReporter = new ExtentHtmlReporter(Constants.HTML_REPORT_PATH);
        extent.attachReporter(htmlReporter);

        String pathToExcel = System.getProperty("user.dir") + "//test-output//test.xlsx";

        extent.setSystemInfo("Hostname", "marwin.kz");
        extent.setSystemInfo("Execution Environment", "Staging");
        extent.setSystemInfo("Browser", propertiesReader.browser());
    }

    @AfterTest
    public void endReport() throws  IOException {
        extent.flush();
    }

    @Test
    public void justLogin()
    {
        driverSettings.initDriver();
        webDriver = driverSettings.getDriver();
        webDriver.navigate().to(properties.getProperty(WWW_MARWIN_KZ));
        logIn(webDriver);
    }

    public static void logIn(WebDriver webDriver1) {
        MainPage mainPage = MainPage.getInstance(webDriver1);
        mainPage.getProfileHoverElement().click();
        LoginPage loginPage = LoginPage.getInstance(webDriver1);
        loginPage.getUsernameElement().sendKeys(properties.getProperty(RIGHT_LOGIN));
        loginPage.getPasswordElement().sendKeys(properties.getProperty(RIGHT_PASSWORD));
        loginPage.getEnterButton().click();
    }
}
