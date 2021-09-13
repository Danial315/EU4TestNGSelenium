package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement usernameInput = driver.findElement(By.id("username"));
        System.out.println(usernameInput.isDisplayed());//to check if its shown on the screen or not cz
        // someyimes u need to click load to see all the screen ..means web elements are there but not displayed

        //TASK
        //verify username inputbox is not displayed on the screen
        //click start button
        //find start button and click
        //wait until elements displayed
        //verify username displayed on the screen
        Assert.assertFalse(usernameInput.isDisplayed(),"verify input box is not displayed");  //frst step
        WebElement startButton= driver.findElement(By.cssSelector("#start>button")); //2nd done
        startButton.click();  //2nd done
        Thread.sleep(8000);// wait untill all web elements are displayed
        Assert.assertTrue(usernameInput.isDisplayed(),"verify input box is displayed");

        driver.quit();









    }
}