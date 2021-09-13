package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void test1(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton=driver.findElement(By.id("green"));
        greenRadioButton.click();
        greenRadioButton.isEnabled();//to check if its enables /working or not..returns boolean
        System.out.println("greenRadioButton.isEnabled() = " + greenRadioButton.isEnabled());
        Assert.assertFalse(greenRadioButton.isEnabled(),"verify green button not enabled(disabled)");
        //assertFalse cz we want a false return..we dont want is enabled
        //to be true..we want isEnabled to be false
        greenRadioButton.click(); //so if isEnabled return false ..it wll not be clicked
        //driver.quit();

    }
    @Test
    public void test2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox=driver.findElement(By.cssSelector("#input-example>input"));
        //#input-example>input by css locator from parents to child > sign...write psrent id then > child tagname
        //if u put space instead of > it will slect all grandchild instead of first one

        //type somehtng ...but its disabled //error ..element not interactable
        inputBox.sendKeys("my message");
    }

}
