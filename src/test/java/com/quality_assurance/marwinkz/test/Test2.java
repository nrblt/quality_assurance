package com.quality_assurance.marwinkz.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.quality_assurance.marwinkz.util.PropertiesUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Properties;

public class Test2 {

    WebDriver driver;
    private Properties properties = PropertiesUtil.getInstance().getProperties();

    @Test
    public void Test1() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.marwin.kz/");
        driver.manage().window().maximize();
        WebElement login = driver.findElement(By.id("link-ajax-login"));
        login.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//label[text()='Email']")).click();

        driver.findElement(By.id("email-popup")).sendKeys("zhermuhanbetov@gmail.com");
        driver.findElement(By.id("pass-popup")).sendKeys("Qwerty123!");
        driver.findElement(By.name("send")).click();
        Thread.sleep(6000);

        find();

        driver.findElement(By.xpath("//a[text()='Ластик STABILO Fancy']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();

        driver.findElement(By.xpath("//a/div/div[text()='Корзина']")).click();
        driver.findElement(By.className("app-cart-total__button-to-checkout")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[text()='Алматы']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[text()='Астана']")).click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Thread.sleep(15000);
        driver.findElement(By.name("street")).sendKeys("Мангылык Ел");
        Thread.sleep(1000);
        driver.findElement(By.name("house")).sendKeys("51/6");
        Thread.sleep(1000);
        driver.findElement(By.name("flat")).sendKeys("171");
        Thread.sleep(1000);
        driver.findElement(By.name("entrance")).sendKeys("6");
        Thread.sleep(1000);
        driver.findElement(By.name("floor")).sendKeys("6");
        Thread.sleep(1000);
        driver.findElement(By.name("intercom")).sendKeys("Нет");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text() = 'Выбрать']"));

        Properties obj = new Properties();
        FileInputStream objfile = new FileInputStream("/Users/Microsoft/Desktop/quality_assurance/application.properties");
        obj.load(objfile);



        //driver.findElement(By.xpath("button/[text:'Картой или наличными при получении']"));
        driver.findElement(By.xpath(obj.getProperty("search")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("label/span/[text:'Картой или наличными при получении']"));

        driver.findElement(By.id("customer-data-phone")).sendKeys("7777777777");
        Thread.sleep(2000);
        driver.findElement(By.xpath("button/span/[text:'Подтвердить заказ']"));

//        driver.findElement(By.className("app-checkout-shipping-group-item app-checkout-shipping-method-group-list__item")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//div/div/div/p[text()='MARWIN ТРЦ «MEGA SilkWay»']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.className("app-checkout-shipping-next-step-button__button")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[text()='Картой или наличными при получении']")).click();
//        Thread.sleep(2000);

    }

    public void find(){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driver.findElement(By.id("search")).sendKeys("ластик");
        driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
    }

}
