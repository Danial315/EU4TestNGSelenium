package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XpathLocator {

    @Test

    public  void XpathLocator(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get(" http://practice.cybertekschool.com/forgot_password");
        WebElement HomeButton= driver.findElement(By.xpath("//a[@class='nav-link']"));
        System.out.println("HomeButton.getText() = " + HomeButton.getText());  //lazy way 1
        WebElement ForgotPassword= driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        ForgotPassword.getText();//normal way 2
        System.out.println("ForgotPassword.getText() = " + ForgotPassword.getText());
        WebElement EmailText= driver.findElement(By.xpath("//label[@for='email']")); //3
        System.out.println("EmailText.getText() = " + EmailText.getText());
        WebElement EmailBox= driver.findElement(By.xpath("//input[@type='text']")); //4
        EmailBox.sendKeys("Mike@smith.com");
        WebElement RetrievePasswordBox= driver.findElement(By.xpath("//i[text()='Retrieve password']")); //5
        System.out.println("RetrievePasswordBox.getText() = " + RetrievePasswordBox.getText());
        driver.quit();


    }



}
