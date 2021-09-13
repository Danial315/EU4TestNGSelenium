package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        //find chexk box
        WebElement checkBox1= driver.findElement(By.xpath("//input[1]"));
        WebElement checkBox2= driver.findElement(By.xpath("//input[2]"));
        //how to verify checkbox is selected or not
        //msgs is console are displayed from here....line24 and 25
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        //verify checkbox 1 is not slected and 2 is selected
        //here its false frst one n second one is true...cz we didnt click any box yet..2nd was clicked by default
        //all of assertions are passing so we wil not see any msgs..if false thn we see all the msgs.
        Assert.assertFalse(checkBox1.isSelected(),"verify 1 is not selected");
        Assert.assertTrue(checkBox2.isEnabled(),"verify 2 is selected");

        //how to check check boxes//click...just liike radio byttons
        checkBox1.click();

        //verify after click
        //both of them are selected
        Assert.assertTrue(checkBox1.isSelected(),"verify 1 is selected");
        Assert.assertTrue(checkBox2.isEnabled(),"verify 2 is selected");

        Thread.sleep(3000);
        driver.quit();


    }
}
