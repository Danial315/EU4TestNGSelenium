package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;

public class OpenBrowser {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://cybertekschool.com/");



    }
}
