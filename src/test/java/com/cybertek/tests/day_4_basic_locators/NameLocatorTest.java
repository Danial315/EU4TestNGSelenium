package com.cybertek.tests.day_4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //maximize browser

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput=driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("MikeSmith");
        //put email
        WebElement emailiInput=driver.findElement(By.name("email"));
        emailiInput.sendKeys("danialkhan315@gmail.com");

       //lazy way
       // driver.findElement(By.name("email")).sendKeys("danialkhan315@gmail.com");
       // driver.findElement(By.name("email")).click();

        //click signup

        WebElement clickSignup=driver.findElement(By.name("wooden_spoon"));
        clickSignup.click();

        //lazy way

       // driver.findElement(By.name("wooden_spoon")).click();


    }

}
