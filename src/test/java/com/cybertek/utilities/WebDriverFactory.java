package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverFactory {


    public static WebDriver getDriver(String browserType){

        WebDriver driver=null;


        //switch or is else to use different browsers
        // we will use as for now chrome and firefox..and use .equalsIgonreCase or .toLowerCase so avoiding errors

        switch (browserType.toLowerCase()){

            case "chrome":
                WebDriverManager.chromedriver().setup();
                 driver=new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();

                break;
        }

        return driver;
    }
}
