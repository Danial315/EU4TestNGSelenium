package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void LoginAsDriver(){

        //our usenames and passwords are in configuration class(readed by configuration reader), but our locators are
        //in login page class so need to combine both of them
        LoginPage loginPage=new LoginPage();

        String username= ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("driver_password");

        loginPage.usernameInput.sendKeys(username);//we can put user name directly here from configuration properties or create a string n put it
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }


    @Test
    public void loginAsStoreManager(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        loginPage.login(username,password);//loginpage=class name...login=method in that clas then parameters from line 34/35 of this class

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");


    }

    @Test
    public void loginAsStoreManager2(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoreManager();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");


    }

}
