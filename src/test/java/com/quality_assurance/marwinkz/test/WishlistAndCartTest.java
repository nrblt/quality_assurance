package com.quality_assurance.marwinkz.test;

import com.quality_assurance.marwinkz.util.DriverSettings;
import com.quality_assurance.marwinkz.util.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.TreeMap;

import static com.quality_assurance.marwinkz.constants.Constants.*;


public class WishlistAndCartTest {

    WebDriver driver;
    private Properties properties = PropertiesUtil.getInstance().getProperties();
    public DriverSettings driverSettings = new DriverSettings();

    public void detailProduct(WebDriver driver) throws InterruptedException {

        WebElement searchInput = driver.findElement(By.id(properties.getProperty(SEARCH_INPUT_ID)));
        searchInput.sendKeys(properties.getProperty(SEARCH_KEY_EXAMPLE));
        searchInput.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(properties.getProperty(PRODUCT_NAME_XPATH))).click();
    }

    public void addToWishlist(WebDriver driver) throws InterruptedException {
        Test1 login = new Test1();
        login.justLogin();
        Thread.sleep(6000);
        detailProduct(driver);

        driver.findElement(By.xpath(properties.getProperty(ADDED_FAVOURITES_XPATH))).click();
    }

    @Test
    public void addToWishlistTest() throws InterruptedException {
        driverSettings.initDriver();
        driver = driverSettings.getDriver();
        addToWishlist(driver);
    }

}
