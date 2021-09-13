package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

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
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement=driver.findElement(By.id("state"));
        //for options to reach..ned o create object select and put in place of constructor the name of ur web
        // element for which you are trying to access options
        //2.create Select object by passing that element as a constructor
        Select optionsDropdown=new Select(dropdownElement);
        //we have access to all the properties of select class nw through the object of select class
        //getOptions --> returns all the available options from the dropdown
        List<WebElement> options = optionsDropdown.getOptions();//to put it in variable...n letter acces to all of them separately
         //now check how many options we have..the size..n print size too
        //print size of the options
        System.out.println("options.size() = " + options.size());//result=52 bt states 51..cz we also hv option

        //to print all the names of dropdowns..we need to use loop
        //print options one by one
        for (WebElement option : options) {

            System.out.println(option.getText());
        }

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement=driver.findElement(By.id("state"));

        //2.create Select object by passing that element as a constructor
        Select stateDropdown=new Select(dropdownElement);

        //verify that first selection is Select a state
        String expectedOption="Select a State";
        String actualOption=stateDropdown.getFirstSelectedOption().getText();
        //getFirstSelectedOption() >>to get the option...getText();>>to print the text of that option
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");


        //HOW TO SELECT OPTIONS FROM DROPDOWN ?
        //1.SELECT USING VISIBLE TEXT
        //3 different ways
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia"); //directly gv text n real option which u wana select

        //how to verify that virgiia is selcted..compare actual and expected
        expectedOption="Virginia";
        actualOption=stateDropdown.getFirstSelectedOption().getText();//getFirstSelectedOption() cz already slected
        //so frstSelectedoption is ...as on line 80 which is selected now as frst one

        Assert.assertEquals(actualOption,expectedOption,"actual and expected should be equal");

        //select using index
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //select using value
        Thread.sleep(2000);
        stateDropdown.selectByValue("TX");

        expectedOption="Texas";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"actual and expected should be equal");




    }
}
