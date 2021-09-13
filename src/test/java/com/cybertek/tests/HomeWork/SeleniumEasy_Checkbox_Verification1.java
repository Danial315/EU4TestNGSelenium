package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumEasy_Checkbox_Verification1 {

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get(" http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement verifyMessage= driver.findElement(By.xpath("//div[@id='txtAge']"));
        verifyMessage.isDisplayed();
        System.out.println(verifyMessage.isDisplayed());
        // Verify “Success – Check box is checked” message is NOT displayed.
        //to verify we use assetTrue or assertFalse method
        Assert.assertFalse( verifyMessage.isDisplayed(),"msg shoult not be displayed cz nothing is selected");
        //msg/comment ll be displayed only if test fails..if passes nothing is diplayed

        WebElement singleCheckbox= driver.findElement(By.cssSelector("input[type='checkbox']"));
        singleCheckbox.click();
       // Verify “Success – Check box is checked” message is displayed.
        //verifyMessage from line 16 whch was false then now sjould be true
        Assert.assertTrue(verifyMessage.isDisplayed());
        System.out.println(verifyMessage.isDisplayed());
        driver.quit();

    }
}
