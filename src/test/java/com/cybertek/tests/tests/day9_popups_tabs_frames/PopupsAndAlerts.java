package com.cybertek.tests.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

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
    public void test1() {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        //lazy way...........//click the Destroy the World button
        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();
        //click no button at popup
        driver.findElement(By.xpath("//button[.='No']")).click();

    }

    //for java script popups...difficult one
    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        //click Click For JS Alert Button
        driver.findElement(By.xpath("//button[1]")).click();//lazy way..undr sam parnt so index num
        //may be used

        //switch to JS alert pop up
        Alert alert=driver.switchTo().alert();//use Alert of slenium not java..it works only wth java script not chrome
        //notifications..n it has reasdy methods then to deal with popup..e.g accept..dismiss..getText
       Thread.sleep(2000);
       alert.accept();  //to click ok

        //to click cancel.......//click for JS confirm
        //frst click on webelemt of button
        driver.findElement(By.xpath("//button[2]")).click();
        //popup appears ..now click on cancel

        Alert alert1=driver.switchTo().alert();
        Thread.sleep(2000);//its good but optional
        alert1.dismiss();

        //click for JS Prompt......fiill the box in promp popup and click ok
        //find the button

        driver.findElement(By.xpath("//button[3]")).click();

        Alert alert2=driver.switchTo().alert();
        alert2.sendKeys("mikeSmith");
        //alert2.getText();//to get text of popup or alert

        alert2.accept();

    }
}
