package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDown {
    //drop downs without tag <SELECT

    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test(){

        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElement= driver.findElement(By.id("dropdownMenuLink"));

        //CLICK DROPDOWN TO SEE OPTION
        dropdownElement.click();
        //to see all the options..use findElements method n then put it into a variable alt+enter..to use that
        //variable further ..to see all options etc
        //get the options with findElements method and finding common locator between them
        List<WebElement> dropDownOptions = driver.findElements(By.className("dropdown-item"));
        //print size of options nd verify
        System.out.println("dropDownOptions.size() = " + dropDownOptions.size());
        Assert.assertEquals(dropDownOptions.size(),5,"verify size is equal to 5");
        //....THEN use Iter whch is java method coz there is no selenum method for this   to put it in for each loop and
        //then use getText() to print the all available options
        //print one by one
        for (WebElement element : dropDownOptions) {
            System.out.println("element.getText() = " + element.getText());
        }
        //click yahoo
        dropDownOptions.get(2).click();

    }
}
