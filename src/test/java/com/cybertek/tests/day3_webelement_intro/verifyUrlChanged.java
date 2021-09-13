package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {

    public static void main(String[] args) throws InterruptedException {

        /* Verify URL changed
            open browser
            go to http://practice.cybertekschool.com/forgot_password Links to an external site.
            enter any email
            click on Retrieve password
            verify that url changed to http://practice.cybertekschool.com/email_sent  */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
     //open webpage
        driver.get("http://practice.cybertekschool.com/forgot_password ");
        //get expected url
        //String expectedUrl=driver.getCurrentUrl();
          //we dont need to do above tast cz in requiremnts it is already wrritten the url which needs to compare
        //with actual one  verify that url changed to http://practice.cybertekschool.com/email_sent

        //find email box.

        WebElement emailInputBox=driver.findElement(By.name("email"));
        //enter email
        emailInputBox.sendKeys("mike@cybertek.com");
        //click retrive password
        //1 find retrive passwrd button

        WebElement retrivePassword =driver.findElement(By.id("form_submit"));
        retrivePassword.click();

        Thread.sleep(3000);
        //get actual email and compare n see if chnged then test case is passed
       // verify that url changed to http://practice.cybertekschool.com/email_sent

        String expectedUrl="http://practice.cybertekschool.com/email_sent";

        String actualUrl=driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){

            System.out.println("PASS");
        }else{
            System.out.println("FAIl");
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("actualUrl = " + actualUrl);
            //to see whts dfrnce btween urls
        }


        driver.quit();





    }
}
