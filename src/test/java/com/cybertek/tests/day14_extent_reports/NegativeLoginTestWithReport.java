package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){
        //few steps need to add for report..report name...steps..and pass verification ..
       extentLogger=report.createTest("Wrong Password Test");

        //creating object for page class  and use that object to access dynamic locators and web elements in that class
        //as v know most of time v login n its info is same so nw for 1000 cases we can change made one change in page class
        //  nd it will b done for all..dont need to do anything in class where we have test cases
        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter usename : user1");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter password : somepassword");

        loginPage.loginBtn.click();
        extentLogger.info("Click login button");

        extentLogger.info("verify page url");//need to put frst to make sure this line runs..n whts our steps..we can put all
        //other extentlogger step before excpt for  .pass cz it needs to run later only if assertion passes
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
        extentLogger.pass("Wrong Password Test is passed");//we put .pass at last cz this line will run only if assertion is passed
       // or it will not run

    }

    @Test
    public void wrongUsernameTest(){

        extentLogger=report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter usename : someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter password : UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
        extentLogger.pass("Wrong Username Test is passed");

    }


}
