package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumEasy_Checkbox_Verification2 {

    @Test
        public void test2(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get(" http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        //verify that check all text is shown in htlm of checkall button
        WebElement checkAllverify= driver.findElement(By.cssSelector("#check1"));
       checkAllverify.getAttribute("value");
        System.out.println(checkAllverify.getAttribute("value"));
        //cick check all button lazy way
        driver.findElement(By.cssSelector("#check1")).click();
        //find all checkboxes
        WebElement checkBox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        WebElement checkBox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
        WebElement checkBox3= driver.findElement(By.xpath("(//input[@type='checkbox'])[4]"));
        WebElement checkBox4= driver.findElement(By.xpath("(//input[@type='checkbox'])[5]"));
        //verify all checkboxes are selected...lazy way
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());
        Assert.assertTrue(checkBox3.isSelected());
        Assert.assertTrue(checkBox4.isSelected());

        //verify that check all text in in htlm has changed to UNCHECK ALL
        checkAllverify.getAttribute("value");
        System.out.println(checkAllverify.getAttribute("value"));


        driver.quit();


    }
    }

