package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) {

        /*  Verify confirmation message
             open browser
             go to http://practice.cybertekschool.com/forgot_password    Links to an external site.
            enter any email
            verify that email is displayed in the input box
             click on Retrieve password
             verify that confirmation message says 'Your e-mail's been sent!'  */

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password ");

        WebElement emailBoxInput=driver.findElement(By.name("email"));  //to find email box

        String expectedEmail="Mike@smith.com";

        emailBoxInput.sendKeys(expectedEmail); //to input email

        String actualEmail = emailBoxInput.getAttribute("value");  //will give whatevr email  is in that email box


        System.out.println("actualEmail = " + actualEmail);

        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS"); // verify that email is displayed in the input box
        }else{
            System.out.println("FAIL");
        }

        WebElement retrievePassswrdBox=driver.findElement(By.id("form_submit"));

         retrievePassswrdBox.click();// click on Retrieve password

        //verify that confirmation message says 'Your e-mail's been sent!'

        WebElement actualConfirmationMessage=driver.findElement(By.name("confirmation_message"));

        System.out.println(actualConfirmationMessage.getText());


        String expectedMessage="Your e-mail's been sent!";
        //now to compare if msgs are equal we need to convert or assign webElement (actualConfirmationMessage) to string

        String actualMessage=actualConfirmationMessage.getText(); //always use getText() mthd if u wna print a webelement
        //OR ASSIGN IT TO STRING (FOR COMPARING) OR IT WILL GV ERROR..CZ IT IS ITS SELF A VARIABLE..LIKE INT AND STRING

       //compare...verify

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);

        }
        driver.quit();
    }
}
