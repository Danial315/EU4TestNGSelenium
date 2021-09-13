package com.cybertek.tests.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Popups {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.findElement(By.xpath("//button[1]")).click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
}
