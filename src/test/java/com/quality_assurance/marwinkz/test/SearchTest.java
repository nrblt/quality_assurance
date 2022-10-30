package com.quality_assurance.marwinkz.test;

import com.quality_assurance.marwinkz.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.Properties;
import static com.quality_assurance.marwinkz.constants.Constants.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Listeners(Listener.class)
public class SearchTest {
    private static Properties properties = PropertiesUtil.getInstance().getProperties();
    private static ActionsUtil actionsUtil = ActionsUtil.getInstance();

    private static WebDriverWaitUtil webDriverWaitUtil = WebDriverWaitUtil.getInstance();
    public DriverSettings driverSettings = new DriverSettings();
    private WebDriver webDriver;

    public void search(WebDriver webDriver){
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        WebElement searchInput = webDriver.findElement(By.id(properties.getProperty(SEARCH_INPUT_ID)));
        searchInput.sendKeys(properties.getProperty(SEARCH_KEY_EXAMPLE));
        searchInput.sendKeys(Keys.ENTER);

    }

    @Test
    public void searchTest(){
        driverSettings.initDriver();
        webDriver = driverSettings.getDriver();
        webDriver.get(properties.getProperty(WWW_MARWIN_KZ));
        search(webDriver);
    }
}
