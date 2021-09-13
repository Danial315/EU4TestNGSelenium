package com.cybertek.tests.day7_TestNg;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionDemo {


    @Test

    public void Test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("danial","danial");

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");

        //to return boolean if u wana compare a part on one result to other..
        String expected="cyb";
        String actual="cybertek";
        Assert.assertTrue(actual.startsWith(expected));
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void test2(){
        //verify email contains @
    //need boolean result
    String email="mike.smith.com";

    Assert.assertTrue(email.contains("@"),"verify the email");//it is searching for true but found false..output ll be like this


    }
    @Test
    public void test3(){
        Assert.assertFalse(0>1,"verify 0 is not greater than one");
       // needs false but if it gives true test cases fails..will show red
    }
    @Test
    public void test4(){
        //verify two thing not equal
        Assert.assertNotEquals("url","url"); //make sure not equals..if equals returns error n fails but
        //we will use (Assert.assertEquals) more
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("close browser");

    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("open browser");
        WebDriver driver= WebDriverFactory.getDriver("chrome");
    }


}
