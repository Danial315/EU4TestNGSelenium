package com.cybertek.tests.day2_webDriver_bascis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        //Task open chrome and navigate to https://practice.cybertekschool.com

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        //getting title with selenium
        //driver.getTitle().sout


       // System.out.println(driver.getTitle()); 1 way ...driver.getTitle() ..2nd way
        //to assign getTitle method to variable n then print variale...hold alt + enter then enter
        String title = driver.getTitle();
        System.out.println("title = " + title); //soutv to print direct syso with title

        //to get the url

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);


    }
}
