package com.cybertek.tests.day_4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TagNameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //maximiz windows
        driver.manage().window().maximize();

        //browes url
        driver.get("http://practice.cybertekschool.com/sign_up");

        //by lazy and direct way practice
        //for username
        driver.findElement(By.tagName("input")).sendKeys("MikeSmith with tag name");

        //for email
       // driver.findElement(By.tagName("input")).sendKeys("mike@smith.com");
       //it ll input the email in still frst box cz selenium only accepts n understands tags name which is at first position.
        //n input in first one doesnt matter how much you ..if there r mltiple tag names wth same name..as long as v use the
        //name of that tag name ..it lll input all the data in frst input tag name
        //so use name or else locator for second one

        driver.findElement(By.name("email")).sendKeys("mike@smith.com");

        //click button
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(3000);

        //close browser
        driver.quit();
    }
}

