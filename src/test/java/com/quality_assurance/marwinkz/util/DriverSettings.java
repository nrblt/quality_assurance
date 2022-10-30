package com.quality_assurance.marwinkz.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSettings {
    PropertiesReader configFactory = ConfigFactory.create(PropertiesReader.class);
    WebDriver driver;
    public void initDriver() {
        switch (configFactory.browser())
        {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }
    public WebDriver getDriver()
    {
        return driver;
    }
}
