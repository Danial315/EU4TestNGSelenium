package com.cybertek.tests.HomeWork;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class VyTrackHomework extends TestBase {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {

        driver.get("https://qa3.vytrack.com/calendar/event");

        WebElement dropBox = driver.findElement(By.cssSelector("[class='btn dropdown-toggle ']"));

        List<WebElement> dropdownoptions = driver.findElements(By.className("dropdown-menu pull-right"));

        System.out.println(dropdownoptions.size());
    }
}