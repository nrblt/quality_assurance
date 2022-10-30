package com.quality_assurance.marwinkz.bdd.steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.quality_assurance.marwinkz.pages.LoginPage;
import com.quality_assurance.marwinkz.pages.MainPage;
import com.quality_assurance.marwinkz.util.DataBaseUtil;
import com.quality_assurance.marwinkz.util.DriverSettings;
import com.quality_assurance.marwinkz.util.PropertiesUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.quality_assurance.marwinkz.constants.Constants.EXCEL_FILE_PATH;
import static com.quality_assurance.marwinkz.constants.Constants.HTML_REPORT_FILE_PATH;
import static com.quality_assurance.marwinkz.constants.Constants.WWW_MARWIN_KZ;
import static com.quality_assurance.marwinkz.util.BaseTest.extent;

public class LoginTestSteps {
    private static final Properties properties = PropertiesUtil.getInstance().getProperties();
    public DriverSettings driverSettings = new DriverSettings();

    private WebDriver webDriver;
    private Workbook workbook;
    private static Sheet sheet;
    private FileInputStream fileInputStream;
    private static MainPage mainPage;
    private static LoginPage loginPage;
    ExtentHtmlReporter htmlReporter;

    private static DataBaseUtil dbUtil = DataBaseUtil.getInstance();

    @Before
    public void startReport() throws IOException {

        fileInputStream = new FileInputStream(System.getProperty("user.dir") + properties.getProperty(EXCEL_FILE_PATH));
        workbook = WorkbookFactory.create(fileInputStream);
        sheet = workbook.getSheetAt(0);

        driverSettings.initDriver();
        webDriver = driverSettings.getDriver();
        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + properties.getProperty(HTML_REPORT_FILE_PATH));
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Simple Automation Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        mainPage = MainPage.getInstance(webDriver);
        loginPage = LoginPage.getInstance(webDriver);
        dbUtil.createConnection();
    }

    @Given("^user is on home page$")
    public void user_is_on_home_page() {
        webDriver.navigate().to(properties.getProperty(WWW_MARWIN_KZ));
        webDriver.manage().window().maximize();
    }

    @When("^user navigate to log in page$")
    public void user_navigate_to_log_in_page() {
        mainPage.toLogIn();
    }

    @When("^user navigate to email tab$")
    public void user_navigate_to_email_tab() {
        loginPage.emailTab().click();
    }

    @And("^user enters email (.*)$")
    public void user_enters_username(String email) {
        loginPage.getUsernameElement().sendKeys(email);
    }

    @And("^user enters password (.*)$")
    public void user_enters_password_and_submit(String password) {
        loginPage.getPasswordElement().sendKeys(password);
    }

    @And("^user clicks login button$")
    public void user_clicks_login_button() {
        loginPage.getEnterButton().click();
    }


    @After
    public void tearDown() {
        webDriver.quit();
    }
}
