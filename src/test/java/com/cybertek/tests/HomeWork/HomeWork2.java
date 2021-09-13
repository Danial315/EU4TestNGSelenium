package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//u cn put it anywhere..cz it works fr
        //all fin elemnts method n wait for them to be found..for all test cases..so cn put any where
        //not line dependent like thread.sleep
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000); //coz we have put dynamic wait in test 1 test case already
        driver.quit();
    }
    @Test
    public void test1() {
        //Test case #1
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. Click on “Registration Form”
        // Step 3. Enter “wrong_dob” into date of birth input box.
        // Step 4. Verify that warning message is displayed: “The date of birth is not valid”

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.cssSelector("[href='/registration_form']")).click();
        //lazy way
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("wrong_dob");
        WebElement text = driver.findElement(By.xpath("//*[.='The date of birth is not valid']"));
        //System.out.println(text.isDisplayed());//returns true flase

        Assert.assertTrue(text.isDisplayed());

//        String expectedResult="The date of birth is not valid";
//
//        if(actualResult.equals(expectedResult)){
//            System.out.println("pass");
//        }else{
//            System.out.println("fail");
//        }

    }
    @Test
    public void test2(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.cssSelector("[href='/registration_form']")).click();
        //lazy way..to check if checkboxes are displayed
        System.out.println(driver.findElement(By.id("inlineCheckbox1")).isDisplayed());

    }


}
