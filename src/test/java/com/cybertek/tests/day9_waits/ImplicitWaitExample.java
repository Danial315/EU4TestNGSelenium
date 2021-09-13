package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//u cn put it anywhere..cz it works fr
        //all fin elemnts method n wait for them to be found..for all test cases..so cn put any where
        //not line dependent like thread.sleep
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
       // Thread.sleep(2000); coz we have put dynamic wait in test 1 test case already
        driver.quit();
    }
    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        //dynamic wait so that as code appears in htmp and web elemnt appears on page .it will stop waiting automatcly
        //nd move onwards in test case.u cn put the time lmit acrding to u..but it will folow this plan..as element
        //appers
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.cssSelector("#finish"));
        System.out.println(element.getText());


    }
}
