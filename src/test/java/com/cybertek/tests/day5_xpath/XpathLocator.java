package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathLocator {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //lazy way

        driver.findElement(By.xpath("//button[@onclick='button2()']")).click();
    }
}
