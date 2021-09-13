package com.cybertek.tests.day10_FileUpload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

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
     public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");
        //chose file button n click lazy way
        WebElement choosefile = driver.findElement(By.cssSelector("#file-upload"));
        //we can use sendkeys button to upload file
        choosefile.sendKeys("C:\\Users\\Dani\\Desktop\\file.txt");

        //upload
        driver.findElement(By.cssSelector("#file-submit")).click();
        //getting file name which uploaded from browser
        String actualFile=driver.findElement(By.id("uploaded-files")).getText();
        //verify that has uploaded corrrect one
        Assert.assertEquals(actualFile,"file.txt");

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");
        //locating choose file button
        WebElement chooseFile = driver.findElement(By.name("file"));

        //sending file with sendKeys method
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile.txt";
        String fullPath = projectPath+"/"+filePath;
        chooseFile.sendKeys(fullPath);
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        //getting the file name from browser
        String actualFileName= driver.findElement(By.id("uploaded-files")).getText();
        //verify file name is file.txt
        Assert.assertEquals(actualFileName,"textfile.txt");

    }
}
