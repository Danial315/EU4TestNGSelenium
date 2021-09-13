package com.cybertek.tests.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {


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
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/iframe");
        //ifram so means more than one <html /html> so switch to ifram whch has your locator
        //1..switch using id or name
        driver.switchTo().frame("mce_0_ifr");

        //clear before send keys
        driver.findElement(By.cssSelector("#tinymce")).clear(); //ll clear the box if there is text written where we write

        //clear before send keys
        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith");


        //once swtched then u are in small html ...and to work on everything outside small html u need to
        // switch back to big html

        driver.switchTo().defaultContent();

        //2.switch with index...bigger html doesnt count ..if u hv only one html /ifram under bigger html their
        //index num be 0

        driver.switchTo().frame(0);
        //clear before send keys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith with Index");

       //second way to switch back to parent
        driver.switchTo().parentFrame();
       //switch by any web element
        WebElement iframElement= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframElement);

        //clear
        driver.findElement(By.tagName("iframe")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith with Webelement");

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //frst get paretn n its child ..which is top here under the grand children
        //switching to frame top
        driver.switchTo().frame("frame-top");

        //top has 3 frame under left middle and right
        //switch to frame middle
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        //now get text of right fram bt we need to go to parent then access sibblings..scnt acess siblings from siblings
        //goes back to top frame

        driver.switchTo().parentFrame();
        //access right fram by index.....cz middle comes frst n gave 0 index then left 1 then right 2..in inspect portion
        driver.switchTo().frame(2);
        //get text
        System.out.println(driver.findElement(By.tagName("body")).getText());

        // //go to main html to switch bottom ..cz it comes under main html direct..as midlle etc come under top fram direct
        //means that relationship can only be have between parents to chlden not grand paretns to grand children
        driver.switchTo().defaultContent();
        // after paretns to children
        driver.switchTo().frame("frame-bottom");
        //get text of bottom
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }

}
