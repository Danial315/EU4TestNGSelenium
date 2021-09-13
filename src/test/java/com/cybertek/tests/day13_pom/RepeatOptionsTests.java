package com.cybertek.tests.day13_pom;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

     /*VERIFY RADIO BUTTONS
    Open Chrome browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    * */

    @Test
    public void test1() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        //Login as driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //Click on create calendar events
        //wait for loader mask
        Thread.sleep(10000);
        //calendarEventsPage.waitUntilLoaderScreenDisappear();
       // BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,20);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        // Click on repeat
        Thread.sleep(8000);
        createCalendarEventsPage.repeat.click();

        //Verify that repeat every days is checked
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify repeat days is selected");
        //verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"Verify weekday is not selected");

    }

        /*
     VERIFY REPEAT OPTIONS
        Open Chrome browser
        Login as driver
        Go to Activities->Calendar Events
        Click on create calendar events button
        Click on repeat checkbox
        Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
     */

    @Test
    public void test2() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        //Login as driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //Click on create calendar events
        //wait for loader mask
        Thread.sleep(10000);
        //calendarEventsPage.waitUntilLoaderScreenDisappear();
        // BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,20);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        // Click on repeat
        Thread.sleep(8000);
        createCalendarEventsPage.repeat.click();

        Select repeatsDropdown = createCalendarEventsPage.repeatOptionsList();// select method to access dropdowns...n acess to options list

        // Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)..put expected in string list
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");

        List<String> actualList = new ArrayList<>();

        //to get options used repeatdropdown method in createcalndrevenpage and use dot .getoption
        List<WebElement> actualOptions = repeatsDropdown.getOptions();//as actual options are saved as web elements
        // u need to convert and save into string list to compare with expected options..coz only same variables can be
        //compared.
        //for comparing u need loop to save every web element into empty string list created at line 97
        for (WebElement option : actualOptions) {
            //get text of each element and add to actual List
            actualList.add(option.getText());
        }
        //ready method for getting text of list of web elements
        //the easy way to get actaul list/opyions...it is in browserutility class u put webelemnts listoptions and it automatically
        //converts them into text and saves it in as string list to compare
        List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);
        //Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        Assert.assertEquals(actualList,expectedList,"Verify Daily weekly monthly yearly");

    }
}
