package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {

    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */


    @Test
    public void contactDetailsTest() throws InterruptedException {

        //report n test cases
        extentLogger = report.createTest("Contact Info Verification");


        //1st step n 2nd is done in testbase class..through config properties and configuration reader and driver
        // classs in utilites..n we have extended inherited testbase class n have acess to all its properties

        //3 step

        LoginPage loginPage=new LoginPage();
        //at frst we will not directly cal the method from test base..we need to do manualy to check if we are going to
        //use something/login for specific data again n again then we create method for that.

      String username= ConfigurationReader.get("salesmanager_username");
      String password=ConfigurationReader.get("salesmanager_password");

        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a Sales Manager");

      loginPage.login(username,password);//calling login method whch accept two parameters from LoginIn class through object

        //4 step
        //lazy way..like driver.delemnt..we didnt create object n directly navigate..cz v ll use this page class dashboard
        //one tym only..if we r going to use again n again then we need to create object from this class

        extentLogger.info("Navigate to --> Customers > Contacts");
        new DashboardPage().navigateToModule("Customers","Contacts");

        //5step
        ContactsPage contactsPage=new ContactsPage();

        extentLogger.info("Click on mbrackstone9@example.com");
        Thread.sleep(20000);
        //contactsPage.waitUntilLoaderScreenDisappear();//wait so that screen disappers loading

        contactsPage.getContactEmail("mbrackstone9@example.com").click();//v used method to get this weelement/ email
        // from locator n click it..

        ContactInfoPage contactInfoPage = new ContactInfoPage();

       String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();//.getText() is impnt to save in string without it its
        //web elemnt n web elemnt can nto be saved in string [contactInfoPage.fullName is web elemnt in contct info page whch can not be saved in string

       extentLogger.info("Verify full name is "+ expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");

        extentLogger.info("verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","Verify email");

        extentLogger.info("verify phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify phone number");

        extentLogger.pass("PASSED");


    }

}
