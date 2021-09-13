package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement blueRadioBtn= driver.findElement(By.cssSelector("#blue"));

        blueRadioBtn.getAttribute("value");
        //get value of type attribute
        System.out.println(blueRadioBtn.getAttribute("type"));
        //get value of type attribute
        System.out.println(blueRadioBtn.getAttribute("name"));

        //get the value of checked
        //since checked attribute does not keep any value, it will return true or false based on the condition
        System.out.println(blueRadioBtn.getAttribute("checked"));

        //trying to get attribute that does not exist
        //when we use non exist attribute it will return null to us.
        System.out.println(blueRadioBtn.getAttribute("href"));

        //to get all the attribute of web elemnts in console

        System.out.println(blueRadioBtn.getAttribute("outerHTML"));
        //new way to get text or compare
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.name("button2"));

        System.out.println(button2.getAttribute("outerHTML"));
        String outerHTML=button2.getAttribute("outerHTML");
        Assert.assertTrue(outerHTML.contains("button 2"));
        //inner HTML WILL PRINT/GIVE U/ THE TEXT PART ADN OUTER HTML WILL GV/PRINT ALL THE ATTRIBUTES WIT VALUES
        //IN A STRING

        System.out.println("INNER HTML : "+button2.getAttribute("innerHTML"));


        driver.quit();

    }
}
