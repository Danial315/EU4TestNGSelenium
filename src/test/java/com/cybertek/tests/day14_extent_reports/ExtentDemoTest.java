package com.cybertek.tests.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {
//move everything except for test methof to test base for better framework

    //this is a demo report class..to understand concept

     //we will create our own before after method and  all to understand...and this is one time job too in reall work
    //enviroment ..u create ur report class once n use it again and again with framework

    //need these three 3 classes to import..which are needed for reporting
    //then inilialize them in before method

    //this class is used for starting nad building reports
    ExtentReports report;
    //this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;
    //this will  define a test, enables adding logs, authors, test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setup() {
        //initialize the classes..which imported globally
        report = new ExtentReports();

        //create a report path.....for report
        String projectPath = System.getProperty("user.dir");//dynamic n everyone has its own..with this code every one can get to its dynamic project location
        String path = projectPath + "/test-output/report.html";//test-output folder is created automatically when we create reports n we need to save both of these paths to get dynamic path
        //which can be used by all our collegues of work..dynamic path

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);//put path in bracket so that reporter gets reports from there

        //attach the html report to report object
        report.attachReporter(htmlReporter); //cpz htmlreporter has the location of our report..which v save in report object

        //title in report....to give a title to our report...
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information...by object
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));

    }

    @Test
    public void test1(){
        //give name to current test...initialize extentTest class(whch is import globally)..gv ur test case info in it
        extentLogger= report.createTest("TC123 Login as Driver Test");

        //test steps...here we usually have test data but its demo class so v r writiing evrything by ourself
        extentLogger.info("Open Chrome Browser");

        extentLogger.info("Go to this URL");

        extentLogger.info("Enter driver username password");

        extentLogger.info("Click Login");

        extentLogger.info("Verify logged in");

        //pass()--> marks the test case as passed...dot.pass n num of testcase + is passed..if the test case pases
        extentLogger.pass("TC123 is passed");

    }


    @AfterMethod
    public void teardown(){
        //this is when the report is actually created...passed r failed
        report.flush();

    }





    }
