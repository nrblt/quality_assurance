package com.quality_assurance.marwinkz.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.quality_assurance.marwinkz.pages.LoginPage;
import com.quality_assurance.marwinkz.pages.MainPage;
import com.quality_assurance.marwinkz.util.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.quality_assurance.marwinkz.constants.Constants.*;

@Listeners(Listener.class)
public class Test1 {
    private static Properties properties = PropertiesUtil.getInstance().getProperties();
    private static ActionsUtil actionsUtil = ActionsUtil.getInstance();

    private static WebDriverWaitUtil webDriverWaitUtil = WebDriverWaitUtil.getInstance();
    public DriverSettings driverSettings = new DriverSettings();
    private WebDriver webDriver;
    ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter("report.html");
    ExtentReports extentReports = new ExtentReports();

    private WebDriver driver;
    private Workbook workbook;
    private static Sheet sheet;
    private static Cell cell;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private static final String QUERY = "select * from users";
    private static List<Map<String, Object>> resultOfQuery;

    private static DataBaseUtil dbUtil = DataBaseUtil.getInstance();

//    ExtentHtmlReporter htmlReporter;
//
//    ExtentReports reports;
//
//    ExtentTest test;


//    @BeforeTest
//    public void startReport() throws IOException {
//
//        fileInputStream = new FileInputStream(System.getProperty("user.dir") + properties.getProperty(EXCEL_FILE_PATH));
//        workbook = WorkbookFactory.create(fileInputStream);
//        sheet = workbook.getSheetAt(0);
//
//        driverSettings.initDriver();
//        webDriver = driverSettings.getDriver();
//        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//        webDriver.navigate().to(properties.getProperty(WWW_MARWIN_KZ));
//        webDriver.manage().window().maximize();
//
//    }


    @Test

    public void justLogin() throws InterruptedException
    {
        extentReports.attachReporter(extentHtmlReporter);
        ExtentTest extentTest = extentReports.createTest("Login Test", "description");
        extentTest.log(Status.INFO, "Starting test case");


        driverSettings.initDriver();
        webDriver = driverSettings.getDriver();
        webDriver.navigate().to(properties.getProperty(WWW_MARWIN_KZ));
        extentTest.pass("Opening page");
        logIn(webDriver,extentTest);
        extentTest.pass("Closed");
        extentTest.info("Completed");
        extentReports.flush();
    }

    public static void logIn(WebDriver webDriver1, ExtentTest extentTest) throws InterruptedException {

        MainPage mainPage = MainPage.getInstance(webDriver1);
        mainPage.getProfileHoverElement().click();
        Thread.sleep(2000);
        extentTest.pass("Open login tab");
        LoginPage loginPage = LoginPage.getInstance(webDriver1);
        loginPage.emailTab().click();
        extentTest.pass("Choosing email tab");

        Thread.sleep(2000);
        resultOfQuery = dbUtil.getQueryResultMap(QUERY);
        String email = (String) resultOfQuery.get(0).get("email");
        String password = (String) resultOfQuery.get(0).get("password");
        loginPage.getUsernameElement().sendKeys(email);
        loginPage.getPasswordElement().sendKeys(password);
        extentTest.pass("Sending keys");
        loginPage.getEnterButton().click();

        Thread.sleep(6000);
    }
}
