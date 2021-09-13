package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    WebDriver driver;  //need to declare driver variable globally as instance variable so that could be accessed from
   // all the methods


    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome"); //open browser in before method

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    driver.quit(); //close browser in after method

    }
    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //save our web elements inside the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));  //alt+enter to put on string list..arrays
       //get how may buttons we have...so for list we use .size for this/size
        System.out.println("(buttons.size()) = " + (buttons.size()));
        Assert.assertEquals(buttons.size(),6,"verify button is equal to button size");
        //to access now every button
        //but remember that get() is java paty so index in get() starts from zero
        //buttons.get(0); to access 1st button

        //to access all buttons need to use loops...for each looop
        //it will automatically create loop for last known element or list of elemnt..iter+enter

        for (WebElement button : buttons) {
            button.getText();//to print all the buttons name.
            button.isDisplayed();//to check if all buttons are diplayed on screen
          Assert.assertTrue(button.isDisplayed());//then to verify u need to Assert.assertTrue mthd whch is v imp for test case

        }
        //click second button...get(index num)..index according to java and u need to do this outside for loop
        //to access dfrnt button
        buttons.get(1).click();

    }

    @Test
    public  void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //regular findElement method will throw NSE if locator does not exist
        //driver.findElement(By.tagName("buttonaiysdgausda"));

        //passing locator which does not exist, it will not throw NoSuchElement
        //ALT+enter or OPTION+Enter then one more enter for the shortcut
        List<WebElement> buttons2 = driver.findElements(By.tagName("button"));
        buttons2.size();

    }
}
