package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        //this lines defines the page object model
        PageFactory.initElements(Driver.get(),this);//pagefactory class import from selenium thn use its initElement
        //(initialize element ) nd it accepts two parameters Driver.get(),andn obj page this (which means for this page).


    }

    //driver.findElement(By.id("prependedInput"));
    //to finf web elemnts with two locators ..which ever works find it.. {} should be in()... coma after one locator

    @FindAll({
            @FindBy(id = "prependedInput"),    //username box locators
            @FindBy(name ="_username")
    })


   // @FindBy(id = "prependedInput")   //to find element by locator..u can use only one findby or findAll..not both of them
    public WebElement usernameInput;  //webelement name gvn by us

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;


    public void login(String username, String password) {//accepting two parameters which we will use in out test classes
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }

    public void loginAsStoreManager() {

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsDriver() {

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
