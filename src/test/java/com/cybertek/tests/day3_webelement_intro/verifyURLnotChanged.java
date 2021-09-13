package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {

    public static void main(String[] args) {

        /* Verify URL not changed
          -open chrome browser
           -go to http://practice.cybertekschool.com/forgot_password Links to an external site.
            -click on Retrieve password
             -verify that url did not change */

        //1 step open chrom browse from factoryclass

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //2 step open websites

        driver.get("http://practice.cybertekschool.com/forgot_password ");

        //expected url to compare later on at end of test cases execution with actual url. both shd be same

        String expectedUrl=driver.getCurrentUrl();

        //click on retrive password...varibale WeBElement then give name to it then = then method to find webelements
        //driver.findelement();in () By.it(htlm id name)...means that find webelemnt By id ..B shd b capital of By,id

        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //checkig url now actual url to compare

        String actualUrl=driver.getCurrentUrl();

        //checking both to pass or fail test casses
        if (expectedUrl.equals(actualUrl)){

            System.out.println("PASS");
        }else{
            System.out.println("Fail");
        }
       //close your browser
        driver.quit();


    }
}
