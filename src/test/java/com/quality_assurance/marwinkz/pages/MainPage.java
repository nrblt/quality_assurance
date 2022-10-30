package com.quality_assurance.marwinkz.pages;

import com.quality_assurance.marwinkz.util.ActionsUtil;
import com.quality_assurance.marwinkz.util.PropertiesUtil;
import com.quality_assurance.marwinkz.util.WebDriverWaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Properties;

import static com.quality_assurance.marwinkz.constants.Constants.*;

public class MainPage {

    private static final Properties properties = PropertiesUtil.getInstance().getProperties();
    private static WebDriverWaitUtil webDriverWaitUtil = WebDriverWaitUtil.getInstance();
    private static ActionsUtil actionsUtil = ActionsUtil.getInstance();
    private static MainPage instance;
    private static WebDriver webDriver;
    private WebElement profileHoverElement;
    private WebElement logOutButton;
    private WebElement firstProductElement;
    private List<WebElement> productsElements;


    public MainPage(WebDriver webDriver)
    {
        MainPage.webDriver = webDriver;
    }

    public static MainPage getInstance(WebDriver webDriver) {
        if (instance == null) {
            instance = new MainPage(webDriver);
        }
        return instance;
    }

    public WebElement getProfileHoverElement() {
        profileHoverElement = webDriver.findElement(By.id(properties.getProperty(PROFILE_HOVER_ELEMENT)));
        return profileHoverElement;
    }
    public void toLogIn() {
        instance.getProfileHoverElement().click();
    }



}
