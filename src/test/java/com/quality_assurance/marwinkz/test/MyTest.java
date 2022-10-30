package com.quality_assurance.marwinkz.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyTest {
    WebDriver driver;

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.marwin.kz/");
//
        WebElement human = driver.findElement(By.className("customer-ajax-login-link"));
        new Actions(driver).click(human).perform();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement email = driver.findElement(By.xpath("//*[@id=\"login-form-popup\"]/fieldset/label[2]"));
        new Actions(driver).click(email).perform();
        driver.findElement(By.xpath("//*[@id=\"email-popup\"]")).sendKeys("nurboturbont@mail.ru");////*[@id="pass-popup"]
        driver.findElement(By.xpath("//*[@id=\"pass-popup\"]")).sendKeys("Qwer-78-ger");
        WebElement login = driver.findElement(By.xpath("//*[@id=\"send-popup\"]"));
        new Actions(driver).click(login).perform();


    }
    @Test
    public void loginTest(){
        setUp();
//
        WebElement product = driver.findElement(By.xpath("//*[@id=\"visibility-dy\"]/div/div[1]/ol/li[1]/div/div/strong/a[2]"));
        new Actions(driver).click(product).perform();
        WebElement wishlist = driver.findElement(By.xpath("/html/body/div[4]/header/div/div/div[2]/div[2]/div/div[2]/div[2]/a/svg"));
        wishlist.click();
//        new Actions(driver).click(wishlist).perform();
//        WebElement deleteLove = driver.findElement(By.xpath("//*[@id=\"item_1180182\"]/div/a[2]"));
//        new Actions(driver).click(deleteLove).perform();

    }
    @Test
    public void searchTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.marwin.kz/");
        driver.findElement(By.id("search")).sendKeys("ластик");
        driver.findElement(By.id("search")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//a[text()='Ластик STABILO Fancy']")).click();
    }
}