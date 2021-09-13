package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    //@Test
    public void test1(){
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    @Test
    public void test2() throws InterruptedException {

        WebDriver driver= Driver.get();//its is getting the get() mthod from Driver cass in utility folder..which
        //further has configuration reader class and  get method which has (browser) key/ variable in it and this key has value in configuration
        //properties class

        Thread.sleep(2000);
        driver.get("https://www.google.com");

    }

    @Test
    public void test3(){
        WebDriver driver = Driver.get();

        driver.get("https://www.amazon.com");
    }

}
