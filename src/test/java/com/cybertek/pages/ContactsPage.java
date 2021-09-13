package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactsPage extends  BasePage{

//since we are extending BasePage we do not need explicit constructor for this class
    //....for contacts page sincce we ectend to basePage n it has default (no parameter ) constrtutr with
    // pagefactory and initialize element in it..we do not need to create constructor in contact page coz  base
    // page constructor will run for both of us,,coz both need the same type of constructor mentioned above


    //    @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
//    public WebElement email; //we need dynamic locator which works fro alll email then we can use the page object betterly


  //above one is static locator we cn use only for one web  elemenyt ..
    //below is dynamic locator inside the mothod so we can call that method put email n can get web elemnt

    public WebElement getContactEmail(String email){
        String xpath ="//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));//Driver from utility class n return web elemnt email with the locator with text in it
    }



}
