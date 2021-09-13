package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EbayLocator {

    @Test
    public void Test(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        WebElement SearchBox= driver.findElement(By.cssSelector("[id='gh-ac']"));
        SearchBox.sendKeys("Selenium");
        WebElement SearchBoxButton= driver.findElement(By.cssSelector("[class='btn btn-prim gh-spr']"));
        SearchBoxButton.click();
        String Title=driver.getTitle();
        System.out.println("Title = " + Title);

        if(Title.contains("Selenium")){
            System.out.println("PASS");
        }else {
            System.out.println("fAIL");
        }
        driver.quit();

    }
}
