package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

        //creating object for page class  and use that object to access dynamic locators and web elements in that class
        //as v know most of time v login n its info is same so nw for 1000 cases we can change made one change in page class
        //  nd it will b done for all..dont need to do anything in class where we have test cases
        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }

    @Test
    public void wrongUsernameTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");

    }


}
