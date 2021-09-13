package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookLogIn {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.facebook.com/");

         //acces email box and put email
        WebElement emailInputBox=driver.findElement(By.name("email"));
       String myEmail="danialkhan315@gmail.com";
        emailInputBox.sendKeys(myEmail);

        //access pasword box an dput pasword
        WebElement passwordInputBox=driver.findElement(By.name("pass"));
        String myPassword="narikdanishnaeem12345";
        passwordInputBox.sendKeys(myPassword);

        //access and click login button
        WebElement loginButton=driver.findElement(By.id("royal_login_button"));
        loginButton.click();
    }
}
