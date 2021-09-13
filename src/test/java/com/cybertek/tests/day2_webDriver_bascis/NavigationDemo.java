package com.cybertek.tests.day2_webDriver_bascis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com");

        Thread.sleep(2000);//2 seconds wait

        driver.navigate().to("https://www.facebook.com");

        //to wait on web page before going anywhere esle//accept mili seconds so for 1 sec=1000 miliseconds
        //wait three seconds here then move on //bt need to put btween navigate so it wait between them
        Thread.sleep(3000);

        //navigate back or forward
        driver.navigate().back();
        //wait 2 seconds  at back and then go forwards
        driver.navigate().forward(); //means back to fb again
        //refresh to webpage
        driver.navigate().refresh();



    }
}
