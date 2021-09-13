package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest_isSelected {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        //locating radio buttons
        WebElement blueButton=driver.findElement(By.cssSelector("#blue"));
        WebElement redButton=driver.findElement(By.cssSelector("#red"));
        //check if its selected
        //blue>>>true
        System.out.println("blueButton is Selected = " + blueButton.isSelected());
        //red>>>false
        System.out.println("redButton is Selected = " + redButton.isSelected());

        //CLICK THE RADIO BUTTON..n after clicking red..make sure that red is selected now
        redButton.click();

        //verify red is selected and blue is not selected
        Assert.assertFalse(blueButton.isSelected(),"verify blue is not selected");//always put msg..only msg is displayed
        //if test fails..if true nothing will b shown
        //should return true if false case fails
        Assert.assertTrue(redButton.isSelected(),"verify red is  selected");//shd return false cz only 1 button can be selected.n blue is
        //selected already.to pass the test it should return false..not selected

        Thread.sleep(3000);
        driver.quit();


    }
}
