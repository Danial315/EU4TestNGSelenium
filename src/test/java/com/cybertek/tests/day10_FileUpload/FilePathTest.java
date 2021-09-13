package com.cybertek.tests.day10_FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FilePathTest {
    WebDriver driver;

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/upload");


        ///sending files by ..dynamic way fr all users

        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/textfile.txt";

        //concate so that could get full path

        String fullPath=projectPath+"/"+filePath;
        System.out.println(fullPath);

    }

}

