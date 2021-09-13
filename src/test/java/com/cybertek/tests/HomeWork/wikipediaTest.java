package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class wikipediaTest {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        WebElement SearchBox= driver.findElement(By.cssSelector("[id='searchInput']"));
        SearchBox.sendKeys("selenium webdriver");
        WebElement SearchBoxButton= driver.findElement(By.cssSelector("[class='sprite svg-search-icon']"));
        SearchBoxButton.click();
        driver.findElement(By.cssSelector("[title='Selenium (software)']")).click();
        String currentUrl=driver.getCurrentUrl();

        if(currentUrl.endsWith("Selenium_(software)")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

    }
}
