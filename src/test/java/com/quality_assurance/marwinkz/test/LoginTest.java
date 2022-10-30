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


public class LoginTest {
    WebDriver driver;

    public void justLogin(WebDriver driver){
        WebElement human = driver.findElement(By.className("customer-ajax-login-link"));
        human.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement email = driver.findElement(By.xpath("//*[@id=\"login-form-popup\"]/fieldset/label[2]"));
        email.click();
        driver.findElement(By.xpath("//*[@id=\"email-popup\"]")).sendKeys("nurboturbont@mail.ru");////*[@id="pass-popup"]
        driver.findElement(By.xpath("//*[@id=\"pass-popup\"]")).sendKeys("Qwer-78-ger");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"send-popup\"]"));
        loginButton.click();

    }
    @Test
    public void loginTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.marwin.kz/");
        justLogin(driver);
    }
    @Test
    public void logoutTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.marwin.kz/");
        justLogin(driver);
        WebElement logoutButton = driver.findElement(By.xpath("//a[@href='https://www.marwin.kz/customer/account/logout/']"));
        logoutButton.click();
    }
    @Test
    public void wrongUsernameTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.marwin.kz/");
        WebElement human = driver.findElement(By.className("customer-ajax-login-link"));
        human.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement email = driver.findElement(By.xpath("//*[@id=\"login-form-popup\"]/fieldset/label[2]"));
        email.click();
        driver.findElement(By.xpath("//*[@id=\"email-popup\"]")).sendKeys("1234erfgergew@mail.ru");////*[@id="pass-popup"]
        driver.findElement(By.xpath("//*[@id=\"pass-popup\"]")).sendKeys("erwgreghe5ywe5");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"send-popup\"]"));
        loginButton.click();
    }


}
