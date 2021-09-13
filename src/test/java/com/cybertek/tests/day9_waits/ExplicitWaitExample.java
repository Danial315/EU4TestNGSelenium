package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitExample {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
         //click the start button
         driver.findElement(By.tagName("button")).click();

        WebElement usernameInput = driver.findElement(By.id("username"));
        //usernameInput is part of html so no execption will be shown bt o screen it takes time to display.so
        //we need a wait which can wait unless its displayed..but if send keys..it ll gv erer(elemnt not intractable)
        //cz its box not shown in screen.bt in html we have the username..we need exlicit wait to intract aftr fnding

        //HOW TO WAIT EXPLICITLY ?
        //create Explicit wait object
        WebDriverWait wait=new WebDriverWait(driver,20);//fr conection btwen browser n page..we put
        //driver and then directly time in seconds...so object is created for wxplicit wait now use it
        //put condition
        wait.until(ExpectedConditions.visibilityOf(usernameInput));//wait untill userinput box is appeard on scren
        //send keys then
        usernameInput.sendKeys("Mike Smith");


    }
    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

       // driver.findElement(By.cssSelector("[onclick='swapInput()']")); by css locator

        //by xpath..click emable
        driver.findElement(By.xpath("//*[.='Enable']")).click();
        //find input box
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));//by css locator frst id then of parent then > child tagname
       //send some keys...but ll not work cz not enable ..cz takes some time to be enabel so v  neet to put wait and condtion
        //that wait untill box is enable and then put some keys
        //explicit wait
       WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("Mike Smith");

    }
}
