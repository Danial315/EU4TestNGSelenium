package com.cybertek.tests.day2_webDriver_bascis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuite {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.navigate().to("http://practice.cybertekschool.com");
        Thread.sleep(3000);
       //close ur tab ..current tab..not all
        driver.close();
        //open new url  after closing browser you need to open new browser to search url again
       // driver=new ChromeDriver(); //use object to call new tab
        driver=new ChromeDriver();

        driver.navigate().to("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        //close all tabs
        driver.quit();


    }
}
