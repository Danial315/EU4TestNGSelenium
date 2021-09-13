package com.cybertek.tests.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

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
    public void switchWindowsTest(){
        driver.get("http://practice.cybertekschool.com/windows");

        //get title
        System.out.println("Title before new window:"+driver.getTitle());
        //click link ==click here
        driver.findElement(By.linkText("Click Here")).click();
        //get title again
        System.out.println("Title after new window:"+driver.getTitle());
        //we need to switch to window or slenium will gv us the same title before and after cz for one windows
        //doesnt matter how many webpages open..selenium will treat as one window nd wil consider the frst one

        //to get the last recent tab which we opened by selenium
       // System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        String currentWindowHandle = driver.getWindowHandle();
        //v know all windowshandleS too bt shuffled cnt acces by index numbers

        Set<String> windowHandles = driver.getWindowHandles();

        //how to get hte next new tab or windows opened after testing
        //we need to use loops..
        for (String handles : windowHandles) {
            if(!handles.equals(currentWindowHandle)){
                driver.switchTo().window(handles);
            }
        }
        System.out.println("Title after switch new windows = " + driver.getTitle());

    }
    @Test
    public void moreThan2Window(){

        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();

        //get title...window handle
        System.out.println("Title before switch = " + driver.getTitle());
        Set<String> windowHandles = driver.getWindowHandles(); //all windows titles

        //usinf for Loops to get title of more than two windows
        //loop through each window
        for (String handles : windowHandles) {
            //one by one change it
            driver.switchTo().window(handles);
            //whenever your title equals to your expected window title
            if(driver.getTitle().equals("new windows")){
             //stop on that window
                break;
            }

        }
        System.out.println("Title after switch = " + driver.getTitle());


    }
}
