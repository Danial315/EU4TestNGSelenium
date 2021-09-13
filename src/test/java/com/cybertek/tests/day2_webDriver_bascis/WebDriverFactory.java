package com.cybertek.tests.day2_webDriver_bascis;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public static void main(String[] args) {

        //call method from webdriverfactory class from utility package ..get method..as  v kow in that utility package
        // webdriverfactory class has a method getbrowser so call this method ..by creating object...n we
      // know return typ of that method is WebDriver(driver) so use retrn typ obj name ...class name..input parameters
   //remembr webdriverfactory should be of utilities
        WebDriver driver= com.cybertek.utilities.WebDriverFactory.getDriver("Chrome");

        driver.get("https://www.google.com");
    }
}
