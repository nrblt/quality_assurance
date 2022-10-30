package com.quality_assurance.marwinkz.pages;

import com.quality_assurance.marwinkz.util.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import static com.quality_assurance.marwinkz.constants.Constants.*;

public class LoginPage {
    private static final Properties properties = PropertiesUtil.getInstance().getProperties();
    private static LoginPage instance;
    private static WebDriver webDriver;
    private WebElement usernameElement;
    private WebElement passwordElement;
    private WebElement enterButton;
    private static final String QUERY = "select * from users";
    private static List<Map<String, Object>> resultOfQuery;

    public LoginPage(WebDriver webDriver)
    {
        LoginPage.webDriver =webDriver;
    }

    public static LoginPage getInstance(WebDriver webDriver) {
        if (instance == null) {
            instance = new LoginPage(webDriver);
        }
        return instance;
    }

    public WebElement emailTab() {
        usernameElement = webDriver.findElement(By.xpath(properties.getProperty(EMAIL_TAB_XPATH)));
        return usernameElement;
    }

    public WebElement getUsernameElement() {
        usernameElement = webDriver.findElement(By.xpath(properties.getProperty(LOGIN_USERNAME_XPATH)));
        return usernameElement;
    }

    public WebElement getPasswordElement() {
        passwordElement = webDriver.findElement(By.xpath(properties.getProperty(LOGIN_PASSWORD_XPATH)));
        return passwordElement;
    }

    public WebElement getEnterButton() {
        enterButton = webDriver.findElement(By.xpath(properties.getProperty(ENTER_BUTTON_XPATH)));
        return enterButton;
    }
}
