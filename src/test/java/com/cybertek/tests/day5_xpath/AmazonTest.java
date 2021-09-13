package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        //by normal way
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("java");

        WebElement searchButton=driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
        searchButton.click();

       WebElement result= driver.findElement(By.xpath("//span[contains(text(),'results for')]"));

       String resultText=result.getText();  ///getText() ..to print out

        System.out.println("resultText = " + resultText);

        String expectedResut="1-48 of over 4,000 results for";

        if(expectedResut.equals(resultText)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
            System.out.println("expectedResut = " + expectedResut);
            System.out.println("resultText = " + resultText);
        }

    }
}
