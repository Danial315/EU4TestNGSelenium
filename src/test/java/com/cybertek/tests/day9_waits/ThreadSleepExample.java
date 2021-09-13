package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSleepExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        //static wait..completes it tym even if there is no need

        Thread.sleep(6000);
        //dynamic wait so that as code appears in htmp and web elemnt appears on page .it will stop waiting automatcly
       //nd move onwards in test case.u cn put the time lmit acrding to u..but it will folow this plan..as element
       //appers
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.id("username")).sendKeys("Mike Smith");

    }

}
